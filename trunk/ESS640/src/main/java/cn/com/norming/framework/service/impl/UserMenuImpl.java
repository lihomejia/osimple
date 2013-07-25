package cn.com.norming.framework.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.norming.common.init.AppContext;
import cn.com.norming.framework.service.IUserMenu;


public class UserMenuImpl implements IUserMenu {
	
	private final static String MENUPATH = "/resources/menus/essmenu.xml";
	
	private final static String ATTR_ID 		= "id";
	private final static String ATTR_TEXT 		= "text";
	private final static String ATTR_DESKICON 	= "deskicon";
	private final static String ATTR_CLS 		= "cls";
	
	
	public Element getRmMenu() {
		Document menu = getUserMenuDoc(new File(AppContext.getAppPath() + MENUPATH));
		return menu.getRootElement();
	}
	
	private static Document getUserMenuDoc(File file) {
		if (!file.exists()) {
			throw new RuntimeException("Menu file not found:" + file.getAbsolutePath());
		}

		Document doc;
		try {
			doc = new SAXReader().read(file);
		} catch (DocumentException e) {
			throw new RuntimeException("xml file not well format:" + file.getAbsolutePath(), e);
		}
		return doc;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.norming.ess.framework.service.IUserMenu#queryShortcuts()
	 */
	public List<Map<String, Object>> queryShortcuts() {
		return this.queryShortcuts(this.getRmMenu());
	}
	
	private List<Map<String, Object>> queryShortcuts(Element root) {
		List<Map<String, Object>> ret = new ArrayList<>();
		
		List<?> nodes = root.selectNodes("//item");
		
		
		for (Object oNode : nodes) {
			Element ele = (Element) oNode;
			
			Map<String, Object> mShortcut = new HashMap<>();
			
			String itemId = ele.attributeValue(ATTR_ID);
			String cls = ele.attributeValue(ATTR_CLS);
			String text = ele.attributeValue(ATTR_TEXT);
			
			mShortcut.put("cls", 		 cls);
			mShortcut.put("text", 		 text);
			mShortcut.put("itemId",		 itemId);
			mShortcut.put("deskicon", 	 ele.attributeValue(ATTR_DESKICON));
			mShortcut.put("accessable",  true);
			ret.add(mShortcut);
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		File app = new File("src/main/webapp");
		File file = new File(app, MENUPATH);
		
		Document document = UserMenuImpl.getUserMenuDoc(file);
		Element root = document.getRootElement();
		
		UserMenuImpl impl = new UserMenuImpl();
		
		System.out.println("-----------queryShortcuts-------------");
		System.out.println(impl.queryShortcuts(root));
	}
}