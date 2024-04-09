package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setEmail("yelunina@ukr.net").setPassword("Yelunina1234$"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on Add link
        clickOnAddLink();
        //enter name
        //enter surname
        //enter phone
        //enter email
        //enter address
        //enter description
        fillAddContactForm(new Contact()
                .setName("Iryna")
                .setLastName("Yelunina")
                .setPhone("1234567890")
                .setEmail("yelunina@ukr.net")
                .setAddress("Kyiv")
                .setDescription("student"));
        //click on Save button
        clickOnSaveButton();
        //assert Contact is added by text
        Assert.assertTrue(isContactCreated("Iryna"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }

}
