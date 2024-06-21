package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name="firstName")
    private WebElement firstNameField;

    @FindBy(name="lastName")
    private WebElement lastNameField;

    @FindBy(name = "phone")
    WebElement phoneField;

    @FindBy(id = "userName")
    WebElement emailField;

    @FindBy(name = "address1")
    WebElement addressField;

    @FindBy(name = "city")
    WebElement cityField;

    @FindBy(name = "state")
    WebElement stateField;

    @FindBy(name = "postalCode")
    WebElement postalCodeField;

    @FindBy(name = "country")
    WebElement countryDropdown;

    @FindBy(name = "email")
    WebElement userNameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "confirmPassword")
    WebElement confirmPasswordField;

    @FindBy(name = "submit")
    WebElement submitButton;


    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void enterCity(String city) {
        cityField.sendKeys(city);
    }

    public void enterState(String state) {
        stateField.sendKeys(state);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void selectCountry(String country) {
        new Select(countryDropdown).selectByVisibleText(country);
    }

    public void enterUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(By.tagName("body")).getText();
    }

}
