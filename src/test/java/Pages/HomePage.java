package Pages;

import TestNG.ContactManagerAPI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerAPI.Driver), this);

    }
    @AndroidFindBy(id = "addContactButton")
    private MobileElement addContactBtn;

    @AndroidFindBy(id = "addContactButton")
    public static MobileElement addContactBtnMert;

    @AndroidFindBy(id = "showInvisible")
    private MobileElement invisibleCheck;

    //kayıt olan kullanıcının kontrolü için element bilgisi
    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactList")
    private List<MobileElement> userAdd;

}
