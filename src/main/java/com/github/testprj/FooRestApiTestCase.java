package com.github.testprj;

import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.googlecode.openbox.testu.RESTfulTestCase;
import com.googlecode.openbox.testu.tester.TestReportTitle;

@TestReportTitle("Foo REST API Test")
public class FooRestApiTestCase extends RESTfulTestCase {
	
	public FooRestApiTestCase(String name) {
		super(name);
	}



	@Override
	public String getUserAgent() {
		return "test foo api";
	}


	@Override
	public HttpClientBuilder getHttpClientConfig() {
		return HttpClientBuilder.create().setMaxConnPerRoute(200)
				.setMaxConnTotal(2000);
	}
	
	public void setUp() {
		super.setUp();
		beforeSuite();
		beforeClass();
		beforeTest();
	}

	public void tearDown() {
		super.tearDown();
		afterTest();
		afterClass();
		afterSuite();
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	@BeforeTest
	public void beforeTest() {
		
	}

	@AfterTest
	public void afterTest() {
	}
}
