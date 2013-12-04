package com.sample.observer;

public class TestObserver extends Observable{

	public double price;//价格
	public String pName;//名称
	public TestObserver(String pName,double price){
		this.price=price;
		this.pName=pName;
		System.out.println("未改变，观察者update方法不会执行     名称="+pName+" 价格="+price);
	}
	
	/**
	 * 业务方法，改变时调用setChanged()方法
	 */
	public void doBusiness(){
		//改变价格或者名称
		this.price=33.3;
		this.pName="餐具";
		super.setChanged();//设置成已改变
		notifyObservers("传参数。。");//通知观察者
		System.out.println("已改变，通知观察者执行update方法     名称="+pName+" 价格="+price);
	}
	
	/**
	 * 被观察者
	 * @param args
	 */
	public static void main(String[] args) {
		//创建被观察者
		TestObserver able=new TestObserver("杯具",52);
		
	    //创建两个观察者
		Observer o1=new Observer1();
		Observer o2=new Observer2();
		
		//把两个观察者添加到被观察者列别表中
		able.addObserver(o1);
		able.addObserver(o2);
		
		//执行业务操作
		able.doBusiness();
	}

}
