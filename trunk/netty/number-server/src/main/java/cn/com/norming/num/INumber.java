package cn.com.norming.num;

import java.util.Map;



/**
 * 
 * @author lh.jia
 *
 */
public interface INumber {
	
	/**
	 * 返回一个单据号，并将标记位+1
	 * @return
	 */
	String getAndIncrease(Map<String, Object> params);
	
}
