package org.Pages;

import Base.DriverSetUp;
import Base.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends Helpers {
    @FindBy(xpath = "//div/h5[text()='Elements']/..")
    private WebElement element;
    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBox;

    @FindBy(id = "userName")
    private WebElement userName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(id = "currentAddress")
    private WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;
    @FindBy(id = "submitt")
    private WebElement saveBtn;
    public ElementsPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void clickOnElementsButton(){
        scrollDown(element);
        element.click();
        logMsg("User is able to click on Elements Button !!");
    }
    public void clickOnTexBox(){
        textBox.click();
        logMsg("User is able to click on Elements Button !!");
    }

    public void enterDetails(){
        userName.sendKeys(getRandomString());
        userEmail.sendKeys(getRandomString()+"@gmail.com");
        currentAddress.sendKeys(getRandomString());
        permanentAddress.sendKeys(getRandomString());
        saveBtn.click();
    }
}
