package com.github.testprj.testcases;

import com.googlecode.openbox.testu.TestngSuite;


public class Module1TestNGSuite implements TestngSuite {

	@Override
	public String getSuiteName() {
		return "Foo Test";
	}

	@Override
	public String getTestModuleName() {
		return "Foo API Basic Functions";
	}

	@Override
	public String getTestPrefixName() {
		return "";
	}
	
	@Override
	public String getTestPostfixName() {
		return "Test";
	}
	
	@Override
	public Class<?> getSuiteClass() {
		return getClass();
	}

	@Override
	public String getTestngXmlLocation() {
		return "/src/main/resources/testng_suites/" + getSuiteClass().getSimpleName()
				+ ".xml";
	}
}
