package leadssteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	List<String> allhandles;

	@When("Click {string} link")
	public void click_link(String text) {
		driver.findElement(By.linkText(text)).click();
	}

	@Given("Enter Company Name as {string}")
	public void enter_company_name_as(String compName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
	}

	@Given("Enter First Name as {string}")
	public void enter_first_name_as(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}

	@Given("Enter Last Name as {string}")
	public void enter_last_name_as(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}

	@Given("Enter Phone Number as {string}")
	public void enter_phone_number_as(String phNo) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
	}

	@When("Click Submit Button")
	public void click_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Title page should contains with {string}")
	public void title_page_shoul_contains_with(String expectedTitle) {
		String actTitle = driver.getTitle();
		if (actTitle.contains(expectedTitle)) {
			System.out.println("Title Matching");
			Assert.assertTrue(true);
		} else {
			System.out.println("Title Not Matching");
			Assert.assertTrue(false);
		}
	}

	@When("Click Phone Tab")
	public void click_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@Given("Give Phone Number as {string}")
	public void give_phone_number_as(String phNo) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNo);
	}

	@When("Click Find Lead Button")
	public void click_find_lead_button() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@When("Click The First LeadId")
	public void click_the_first_lead_id() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Given("Update Company Name as {string}")
	public void update_company_name_as(String compName) {
		WebElement eleUpdateCompany = driver.findElement(By.id("updateLeadForm_companyName"));
		eleUpdateCompany.clear();
		eleUpdateCompany.sendKeys(compName);
	}

	@When("Click Update Button")
	public void click_update_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Company Name Should be {string}")
	public void company_name_should_be(String expecCompName) {
		String getCompName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String updatedCompName = getCompName.replaceAll("\\d", "");
		String actCompName = updatedCompName.substring(0, updatedCompName.length() - 3);
		if (actCompName.equalsIgnoreCase(expecCompName)) {
			System.out.println("Company Name Matching");
		} else {
			System.out.println("Company Name Not Matching");
		}
		Assert.assertEquals(actCompName, expecCompName);
	}

	@Given("Get 1st LeadID Text")
	public void get_1st_lead_id_text() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
		leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	}

	@Given("Enter LeadID Text")
	public void enter_lead_id_text() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
	}

	@Then("LeadID Should not be Displayed Expected Text {string}")
	public void lead_should_be_deleted(String excepText) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("x-paging-info")));
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equalsIgnoreCase(excepText)) {
			System.out.println("Lead ID Not Displayed Successfully");
		} else {
			System.out.println("Lead ID Displaying");
		}
		Assert.assertEquals(text, "No records to display");
	}

	@When("Click From Lead Img")
	public void click_from_lead_img() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}

	@Given("Enter the First Name as {string}")
	public void enter_the_first_name_as(String fromToLead) {
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fromToLead);
	}

	@When("Click Find Lead Button in New Window")
	public void click_find_lead_button_in_new_window() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@Given("Get 1st LeadID Text in New Window")
	public void get_1st_lead_id_text_in_new_window() {
		leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	}

	@When("Click The First LeadId in New Window")
	public void click_the_first_lead_id_in_new_window() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
	}

	@When("Click To Lead Img")
	public void click_to_lead_img() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}

	@When("Handle Alert by Accept")
	public void handle_alert_by_accept() {
		driver.switchTo().alert().accept();
	}

}
