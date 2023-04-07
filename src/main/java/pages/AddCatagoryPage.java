package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import util.BasePage;

public class AddCatagoryPage extends BasePage {

	WebDriver driver;
	public static String addNewItem = "Sudip's new Catagory";

	SoftAssert softAssert;

	public AddCatagoryPage(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(xpath = "//input[@name='categorydata']")
	WebElement ADD_NEW_CATAGORY;

	@FindBy(xpath = "//input[@value='Add category']")
	WebElement ADD_NEW_CATAGORY_BUTTON;

	@FindBy(xpath = "//*[contains(text(),'Sudip')]")
	WebElement VALIDATE_ADDED_CATAGORY;

	@FindBy(xpath = "//select[@name='due_month']")
	public static WebElement VALIDATE_MONTH_NAMES;

	@FindBy(xpath = "//*[contains(text(),'The category you want to add already exists:')]")
	WebElement DUPLICATE_CATAGORY_MESSAGE;

	public void userShouldBeAbleToAddNewCatagoryItem() {

		ADD_NEW_CATAGORY.sendKeys(addNewItem);

	}

	public void userClicksOnAddCatagoryButton() {
		ADD_NEW_CATAGORY_BUTTON.click();
	}

	public void validateNewCatagoryIsAdded() {

		softAssert.assertEquals(addNewItem, VALIDATE_ADDED_CATAGORY, "Added New Catagory Not Found");

	}

	public void selectFromDropdown(WebElement elemnt) {

		String before_xpath = "//*[@id='extra']/select[3]/option[";
		String after_xpath = "]";
		for (int i = 2; i <= 13; i++) {
			String month = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(month);

		}

	}

	public void validateNewCatagoryIsDuplicated() {

		Assert.assertEquals(AddCatagoryPage.addNewItem, DUPLICATE_CATAGORY_MESSAGE, "We Cannot Duplicate Catagories");

	}
}
