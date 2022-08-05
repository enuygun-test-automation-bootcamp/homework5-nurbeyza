package pages;

import TestNG.ContactManagerAPI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;


@Data
public class AddContactPage {



    public AddContactPage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerAPI.Driver), this);
    }

    @AndroidFindBy(id = "android:id/title")
    private MobileElement title;

    @AndroidFindBys({@AndroidFindBy(id="title"),@AndroidFindBy(tagName = "title")})
    private MobileElement titleBys;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Name\"]")
    private MobileElement contactNameTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Target Account\"]")
    private MobileElement targetAccountTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Phone\"]")
    private MobileElement concactPhoneTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Email\"]")
    private MobileElement contactMailTitle;


    @AndroidFindBy(id = "accountSpinner")
    private MobileElement targetAccountField;

    @AndroidFindBy(id = "contactNameEditText")
    private MobileElement contactNameField;

    @AndroidFindBy(id = "contactEmailEditText")
    private MobileElement contactEmailField;

    @AndroidFindBy(id = "contactPhoneEditText")
    private MobileElement contactPhoneField;

    @AndroidFindBy(id = "contactEmailTypeSpinner")
    private MobileElement contactEmailDrop;




    @AndroidFindBy(id = "contactSaveButton")
    private MobileElement contactSaveBtn;


}
