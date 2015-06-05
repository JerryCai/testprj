package com.github.testprj.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.github.testprj.FooRestApiTestCase;
import com.github.testprj.config.Config;
import com.googlecode.openbox.testu.tester.Bugs;
import com.googlecode.openbox.testu.tester.CaseDescriptions;
import com.googlecode.openbox.testu.tester.CaseName;
import com.googlecode.openbox.testu.tester.CaseSuite;
import com.googlecode.openbox.testu.tester.ExpectedResults;
import com.googlecode.openbox.testu.tester.Owner;
import com.googlecode.openbox.testu.tester.ParentCaseName;
import com.googlecode.openbox.testu.tester.Preconditions;
import com.googlecode.openbox.testu.tester.Steps;

@CaseSuite(name = "Test Add Foo")
@Owner(name = "Jerry Cai", email = "nwwh@qq.com", id = "jerrycai")
public class AddFooTest extends FooRestApiTestCase {
	private static final Logger logger = LogManager.getLogger();
	
	public static final String GROPU_NAME = "Add Foo";
	

	public AddFooTest(String name) {
		super(name);
	}

	@CaseName("test add foo 1")
    @Preconditions({
                        "1. enable A",
                        "2. disable B",
                      })
    @Steps({
            "1. call add foo api with correct parameters",
            "2.  check its response"
           })
    @ExpectedResults({ "1. its api should response success " , 
    	"2. check db data , its new foo is added !"})
    @Test(groups = { GROPU_NAME }, invocationCount = Config.invocationCount, threadPoolSize = Config.threadPoolSize)
    public void testAddFoo1() throws Exception {
		if(logger.isInfoEnabled()){
			logger.info("Test Add Foo 1 executed !");
		}
        
    }
	
	@ParentCaseName("test add foo 2")
	@CaseName("test add foo 1 sub case")
    @Preconditions({
                        "1. enable A",
                        "2. disable B",
                      })
    @Steps({
            "1. call add foo api with correct parameters",
            "2.  check its response"
           })
    @ExpectedResults({ "1. its api should response success " , 
    	"2. check db data , its new foo is added !"})
	@Test(groups = { GROPU_NAME }, invocationCount = Config.invocationCount, threadPoolSize = Config.threadPoolSize)
	public void testAddFoo1SubCase()throws Exception{
		if(logger.isInfoEnabled()){
			logger.info("This is sub test case under parent test case [test add foo 1] ");
		}
        
	}
	
	@Owner(name = "Xiaolong Cai", email = "xiacai@cisco.com", id = "xiacai")
	@Bugs({"https//xxxbuglink.com/bug1",
		   "https//yyybuglink.com/bug2"})
	@CaseName("test add foo 3")
    @CaseDescriptions({ "call add foo with wrong input parameters , it should return failed !"})// if you want to write very concise test cases , you can use  @CaseDescriptions
    @Test(groups = { GROPU_NAME }, invocationCount = Config.invocationCount, threadPoolSize = Config.threadPoolSize)
    public void testAddFoo2()  throws Exception {
		if(logger.isInfoEnabled()){
			logger.info("Test Add Foo 2 executed !");
		}
    }
}
