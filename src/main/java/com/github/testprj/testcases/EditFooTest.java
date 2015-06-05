package com.github.testprj.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.github.testprj.FooRestApiTestCase;
import com.github.testprj.config.Config;
import com.googlecode.openbox.testu.tester.CaseName;
import com.googlecode.openbox.testu.tester.CaseSuite;
import com.googlecode.openbox.testu.tester.ExpectedResults;
import com.googlecode.openbox.testu.tester.Owner;
import com.googlecode.openbox.testu.tester.ParentCaseName;
import com.googlecode.openbox.testu.tester.Preconditions;
import com.googlecode.openbox.testu.tester.Steps;

@CaseSuite(name = "Test Edit Foo")
@Owner(name = "Jerry Cai", email = "nwwh@qq.com", id = "jerrycai")
public class EditFooTest extends FooRestApiTestCase {
	private static final Logger logger = LogManager.getLogger();

	public static final String GROPU_NAME = "Edit Foo";


	public EditFooTest(String name) {
		super(name);
	}

	@CaseName("test edit foo 1")
	@Preconditions({ "1. enable A", "2. disable B", })
	@Steps({ "1. call edit foo api with correct parameters",
			"2.  check its response" })
	@ExpectedResults({ "1. its api should response success ",
			"2. check db data , its new foo is edited !" })
	@Test(groups = { GROPU_NAME }, invocationCount = Config.invocationCount, threadPoolSize = Config.threadPoolSize)
	public void testEditFoo1() throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("Test Edit Foo 1 executed !");
		}

	}

	@ParentCaseName("test edit foo 2")
	@CaseName("test edit foo 1 sub case")
	@Preconditions({ "1. enable A", "2. disable B", })
	@Steps({ "1. call edit foo api with correct parameters",
			"2.  check its response" })
	@ExpectedResults({ "1. its api should response success ",
			"2. check db data , its new foo is edited !" })
	@Test(groups = { GROPU_NAME }, invocationCount = Config.invocationCount, threadPoolSize = Config.threadPoolSize)
	public void testEditFoo1SubCase() throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("This is sub test case under parent test case [test edit foo 1] ");
		}

	}
}
