package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertTrue;
/**
 * Created by neha.p on 30-06-2014.
 */
public class MyStepdefs extends Constants {


    @Given("^I am on Home Page$")
    public void I_am_on_Home_Page() throws Throwable {

        driver.get("http://demo.actitime.com/login.do");


        String home_title = driver.getTitle();
        System.out.println(home_title);
    }

    @When("^I provide credentials and click on login$")
    public void I_provide_credentials_and_click_on_login() throws Throwable {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(3000);
    }

    @Then("^I should be on Welcome page$")
    public void I_should_be_on_Welcome_page() throws Throwable {

        String link_text = driver.findElement(By.id("logoutLink")).getText();
        String Verify_text = "Logout";

        assertTrue(Verify_text + "link doesn't match ", Verify_text.equals(link_text));

        Logout();
        Thread.sleep(5000);
        //exit();


    }

    public  void Logout(){

        String link_text = driver.findElement(By.id("logoutLink")).getText();
        if(link_text.equals("Logout")){
            driver.findElement(By.id("logoutLink")).click();
        }

        driver.close();
    }

    public void exit(){

        driver.close();
    }
}
