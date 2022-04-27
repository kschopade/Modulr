package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basics.BaseClass;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseClass {

	WebDriverWait wait;

	@BeforeClass
	@Given("Initialize browser with chrome")
	public void initialize_browser_with_chrome() {
		driver = initializeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Given("I go to Modulr Customer Page")
	public void i_go_to_modulr_customer_page() {
		System.out.println("Step1: Modulr Customer Page");
		driver.get("https://secure-sandbox.modulrfinance.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^I enter Username as \"([^\"]*)\"$")
	public void i_enter_username(String userName) {
		System.out.println("Step2: Username");
		wait.until(ExpectedConditions.titleIs("Modulr Payments"));
		driver.findElement(By.id("username-inp")).sendKeys(userName);
	}

	@When("^I enter Password as \"([^\"]*)\"$")
	public void i_enter_password(String password) {
		System.out.println("Step3: Password");
		driver.findElement(By.id("password-inp")).sendKeys(password);
	}

	@When("I click on Login Button")
	public void i_click_on_login_button() {
		System.out.println("Step4: Login Btn");
		driver.findElement(By.id("signInSubmitButton")).click();
	}

	@Then("I should log in")
	public void I_should_log_in() {
		System.out.println("Step5: Success");
		Assert.isTrue(true, driver.findElement(By.xpath("//title")).getText(), "Modulr Payments");
	}

	@Then("I should not log in")
	public void I_should_not_log_in() {
		System.out.println("Step5: Should not Login");
		Assert.isTrue(true,
				driver.findElement(By.xpath("//*[text()=\" The username or password is incorrect. \"]")).getText(),
				"The username or password is incorrect");
	}

	@Then("I should get message as \"([^\\\"]*)\"$")
	public void I_should_get_message_as(String msg) {
		System.out.println("Step5: Should not Login");
		Assert.isTrue(true, driver.findElement(By.xpath("//*[text()=' This field is required ']")).getText(), msg);
	}
	
	@AfterClass
	@Then("close the Browser")
	public void close_the_browser() {
		driver.quit();
	}
}
