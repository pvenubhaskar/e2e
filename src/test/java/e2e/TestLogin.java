package e2e;

import org.testng.annotations.Test;

import pageobjects.HomePage;


public class TestLogin extends BaseClass{
	//first test
    @Test
    public void test1(){
        System.out.println("Test 1");
        HomePage lp = new HomePage(driver);
        lp.setUserName("Admin");
        lp.setPassword("admin123");
        lp.clickLogin();
        logger.info("Login test executed successfully");
    }

}

