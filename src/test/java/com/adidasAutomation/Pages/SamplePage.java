package com.adidasAutomation.Pages;

import com.adidasAutomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamplePage {

    public SamplePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//textarea[@id='comment']")
    public WebElement commentBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(id = "comment-submit")
    public WebElement postCommentButton;

    @FindBy(xpath = "//iframe[@loading='lazy']")
    public WebElement frame;

    @FindBy(xpath = "//textarea[@title='Enter your comment here...']")
    public WebElement newCommentBox;

    public String getInvalidEmailMessage(){
        return Driver.get().findElement(By.id("email")).getAttribute("validationMessage");
    }






}
