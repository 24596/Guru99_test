package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.ExcelUtils;

public class TestCases {
    WebDriver driver;
    ConfigReader configReader;
    RegistrationPage registrationPage;

    String name;


    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        configReader = new ConfigReader();
        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
    }

    @Test(dataProvider = "validData")
    public void registerWithValidData(String firstName, String lastName, String phone, String email, String address, String city, String state, String postalCode, String country, String userName, String password, String confirmPassword) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,1000)");
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterPhone(phone);
        registrationPage.enterEmail(email);
        registrationPage.enterAddress(address);
        registrationPage.enterCity(city);
        registrationPage.enterState(state);
        registrationPage.enterPostalCode(postalCode);
        registrationPage.selectCountry(country);
        registrationPage.enterUserName(userName);
        name=userName;
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.clickSubmitButton();
        Assert.assertTrue(registrationPage.getConfirmationMessage().contains("Thank you for registering"));
    }

    @Test
    public void verifyNameOnConfirmationMessage(){
        Assert.assertEquals(registrationPage.getNameFromConfirmation(),name);
    }


    @DataProvider(name = "validData")
    public Object[][] validData() throws Exception {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/TestData.xlsx", "registration_data");
        return excelUtils.getTestData();
    }
}