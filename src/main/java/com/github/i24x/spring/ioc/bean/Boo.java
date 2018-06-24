package com.github.i24x.spring.ioc.bean;

public class Boo extends Aoo implements ICoo{
	public String boo;
	public String address;
	/*public static Boo instance = new Boo();
	public static Boo getInstance(){
		return instance;
	}*/
	public /*private*/ Boo(){
		System.out.println("初始化......");
	}
	
	public Boo(String boo, String address) {
		super(boo, address);
		this.boo = boo;
		this.address = address;
		System.out.println("Boo(String boo, String address)");
	}
	public String getBoo() {
		return boo;
	}
	public void setBoo(String boo) {
		this.boo = boo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public void sayGoodBye() {
		System.out.println("Boo:"+","+this.address);
	}
	public String sayHi(String K){
		System.out.println("Boo:"+K+","+this.address);
		return K;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Boo 对象销毁......");
		super.finalize();
	}
	
}
