package com.github.testprj;

import com.googlecode.openbox.testu.tester.TestReport;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.googlecode.openbox.testu.RESTfulTestCase;
import com.googlecode.openbox.testu.tester.TestReportTitle;

@TestReport(title = "Foo REST API Test" , expand = false)
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
	
	public void setUp() throws Exception {
		super.setUp();
		beforeSuite();
		beforeClass();
		beforeTest();
	}

	public void tearDown() throws  Exception{
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
