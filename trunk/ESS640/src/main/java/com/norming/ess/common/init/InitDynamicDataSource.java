package com.norming.ess.common.init;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.norming.ess.base.util.FileHelper;
import com.norming.ess.common.dao.impl.CommonDaoImpl;


/**
 * 初始化动态数据源.
 * @author lh.jia
 *
 */
public class InitDynamicDataSource extends CommonDaoImpl implements BeanFactoryPostProcessor {
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String comSql = new StringBuffer()
			.append("select NMCOMS_COMID")
			.append(", NMCOMS_DBTYPE, NMCOMS_DBSERVER, NMCOMS_DBNAME, NMCOMS_DBPORT, NMCOMS_DBUSER, NMCOMS_DBPWD")
			.append(" from NMCOMS")
		.toString();
		List<Map<String, Object>> comList = getJdbcTemplate().queryForList(comSql);
		
		if (comList == null || comList.size() == 0) return;
		
		
		/** 得到配置文件的路径. */
		Resource dsResource = new ClassPathResource("dynamic-dataSource.xml");
		
		File dsFile = this.getFileByResource(dsResource);
		
		String ds = FileHelper.readFile(dsFile);
		
		/** DataSource Bean模板 */
		String dsTpl = "";
		
		StringBuffer dsList = new StringBuffer();
		for (Map<String, Object> mCom : comList) {
			
			String ENTID 	= ObjectUtils.toString(mCom.get("NMCOMS_COMID"));
			String DBTYPE 	= ObjectUtils.toString(mCom.get("NMCOMS_DBTYPE"));
			String DBSERVER = ObjectUtils.toString(mCom.get("NMCOMS_DBSERVER"));
			String DBNAME 	= ObjectUtils.toString(mCom.get("NMCOMS_DBNAME"));
			String DBPORT 	= ObjectUtils.toString(mCom.get("NMCOMS_DBPORT"));
			String DBUSER 	= ObjectUtils.toString(mCom.get("NMCOMS_DBUSER"));
			String DBPWD 	= ObjectUtils.toString(mCom.get("NMCOMS_DBPWD"));
			
			if (StringUtils.isEmpty(dsTpl)) {
				String tplName = "";
				if ("0".equals(DBTYPE)) {
					tplName += "dynamic-dataSource-tpl(mysql).xml";
				}
				else if ("1".equals(DBTYPE)) {
					tplName += "dynamic-dataSource-tpl(mssql).xml";
				}
				else {
					tplName += "dynamic-dataSource-tpl(oracle).xml";
				}
				Resource tplResource = new ClassPathResource(tplName);
				
				dsTpl = FileHelper.readFile(this.getFileByResource(tplResource));
			}
			
			dsTpl.replace("$$", ENTID).replace("$$", DBSERVER);
			
			/** 将数据源的模板替换为真实的DataSource配置 */
			dsList.append("\n").append(
				dsTpl.replace("$dataSourceID$", 	ENTID)
					.replace("$server$", 			DBSERVER)
					.replace("$dbname$", 			DBNAME)
					.replace("$port$", 				DBPORT)
					.replace("$username$", 			DBUSER)
					.replace("$password$", 			DBPWD)
			);
		}
		
		String ds_run = ds.replace("<bean/>", dsList);
		
		/** 此文件为动态数据源的Bean定义 */
		String configLocationString = "dynamic-dataSource-run.xml";
		
		File target = new File(dsFile.getParentFile(), configLocationString);
		
		
		/** 生成或覆盖 一个动态数据源的Spring配置文件 */
		FileHelper.writeFile(target, ds_run, false);
		
		/** 将动态的数据源加载到当前环境 */
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(configLocationString);
	}
	
	private File getFileByResource(Resource resource) {
		try {
			return resource.getFile();
		} catch (IOException e) {
			return null;
		}
	}
}