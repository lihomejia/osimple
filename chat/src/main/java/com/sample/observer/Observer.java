package com.sample.observer;

/**
 * 重写观察者
 */
public interface Observer    
{    
	/**   
	* 当被观察的对象发生变化时，这个方法会被调用。   
	*/    
	void update(Observable o, Object arg);    
}