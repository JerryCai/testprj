package com.github.testprj;

import com.github.testprj.testcases.Module1TestNGSuite;
import com.googlecode.openbox.testu.TestngSuite;
import com.googlecode.openbox.testu.tools.TestngSuiteBuilder;

public class TestSuiteAutoGeneratorTool {

	public static void main(String... args) {

		TestngSuite ts = new Module1TestNGSuite();

		TestngSuiteBuilder suiteBuilder = TestngSuiteBuilder.create(ts);
		try {
			suiteBuilder.createTestngSuite();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
