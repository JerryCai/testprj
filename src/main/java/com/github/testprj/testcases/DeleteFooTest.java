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

@CaseSuite(name = "Test Delete Foo")
@Owner(name = "Jerry Cai", email = "nwwh@qq.com", id = "jerrycai")
public class DeleteFooTest extends FooRestApiTestCase {
	private static final Logger logger = LogManager.getLogger();

	public static final String GROPU_NAME = "Delete Foo";

	public DeleteFooTest(String name) {
		super(name);
	}

	@CaseName("test delete foo 1")
	@Preconditions({ "1. enable A", "2. disable B", })
	@Steps({ "1. call delete foo api with correct parameters",
			"2.  check its response" })
	@ExpectedResults({ "1. its api should response success ",
			"2. check db data , its new foo is deleteed !" })
	@Test(groups = { GROPU_NAME }, invocationCount = Config.invocationCount, threadPoolSize = Config.invocationCount)
	public void testDeleteFoo1() throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("Test Delete Foo 1 executed !");
		}

	}

	@ParentCaseName("test delete foo 2")
	@CaseName("test delete foo 1 sub case")
	@Preconditions({ "1. enable A", "2. disable B", })
	@Steps({ "1. call delete foo api with correct parameters",
			"2.  check its response" })
	@ExpectedResults({ "1. its api should response success ",
			"2. check db data , its new foo is deleteed !" })
	@Test(groups = { GROPU_NAME }, invocationCount = Config.invocationCount, threadPoolSize = Config.invocationCount)
	public void testDeleteFoo1SubCase() throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("This is sub test case under parent test case [test delete foo 1] ");
		}

	}
}
