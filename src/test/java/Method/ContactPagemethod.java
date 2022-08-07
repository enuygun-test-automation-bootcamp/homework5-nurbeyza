package Method;

import TestNG.ContactManagerAPI;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import Pages.ContactPage;


/**
 * Kullandığımız methodları bu sınıf içerisinde yazdık.
 *
 */

public class ContactPagemethod {

    ContactPage contactPage;

    public ContactPagemethod(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerAPI.Driver), this);
        contactPage = new ContactPage();
    }


    //Name inputuna data ekleme
    public void Name(String name){
        contactPage.getContactNameField().setValue(name);
    }

    //mail inputuna data ekleme
    public void setMail(String mail){
        contactPage.getContactEmailField().setValue(mail);
    }

    //phone inputuna data ekleme
    public void setPhone(String phone){
        contactPage.getContactPhoneField().setValue(phone);
    }
}
