package com.bms.test;

import javax.persistence.Persistence;

public class SchemaExporterTest {
	
	public void test1() {
		Persistence.createEntityManagerFactory("mysql");
	}
	
	public static void main(String[] args) {
		new SchemaExporterTest().test1();
	}
}
