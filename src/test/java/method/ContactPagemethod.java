package method;

import TestNG.ContactManagerAPI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.AddContactPage;

import java.util.concurrent.TimeUnit;


/**
 * Kullandığımız methodları bu sınıf içerisinde yazdık.
 *
 */

public class ContactPagemethod {

    AddContactPage addContactPage;


    public ContactPagemethod(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerAPI.Driver), this);
        addContactPage= new AddContactPage();
    }



    public void Name(String name){

        addContactPage.getContactNameField().setValue(name);

    }



    public void setMail(String mail){
        addContactPage.getContactEmailField().setValue(mail);

    }

    public void setPhone(String phone){
        addContactPage.getContactPhoneField().setValue(phone);

    }
}
