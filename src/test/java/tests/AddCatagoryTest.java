package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddCatagoryPage;

import util.BasePage;

public class AddCatagoryTest {

	WebDriver driver;

	AddCatagoryPage catagoryPage;
//	DuplicatePage duplicateCatagory;

	@BeforeTest
	public void setUp() {

		driver = BasePage.initialization();
	}

	@Test(priority=1)
	public void userShouldBeAbleToAddNewCatagoryItem() {

		catagoryPage = PageFactory.initElements(driver, AddCatagoryPage.class);

		catagoryPage.userShouldBeAbleToAddNewCatagoryItem();

		catagoryPage.userClicksOnAddCatagoryButton();
		
		

		catagoryPage.validateNewCatagoryIsAdded();
	}

	@Test(priority=2)
	public void userShouldBeAbleToSeeNamesOfTheMonths() {

		catagoryPage.selectFromDropdown(AddCatagoryPage.VALIDATE_MONTH_NAMES);

	}

	
	
	@Test(priority=3)
	public void duplicateCatagoryInsertion() {
		
		catagoryPage.userShouldBeAbleToAddNewCatagoryItem();
		catagoryPage.userClicksOnAddCatagoryButton();
		
		catagoryPage.userShouldBeAbleToAddNewCatagoryItem();
		catagoryPage.userClicksOnAddCatagoryButton();

		Assert.assertEquals(AddCatagoryPage.addNewItem,"The category you want to add already exists:");
		
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}