package TestNG;
import com.github.javafaker.service.RandomService;
import Devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import Method.ContactPagemethod;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.AddContactPage;
import Pages.HomePage;
import Utility.DeviceFarmUtility;
import com.github.javafaker.service.FakeValuesService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ContactManagerAPI {
    public static AppiumDriver<?> Driver;

    AddContactPage addContactPage;
    ContactPagemethod methodc;
    DesiredCapabilities capabilities;
    HomePage homePage;
    private String oreo;


    //Bu alanda mail ve usurname alanlarını her seferinde farklı gelecek şekilde ayarlıyoruz.
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    String email = fakeValuesService.bothify("????##@gmail.com");
    String username =  fakeValuesService.bothify("???????##");



    public ContactManagerAPI(){
         oreo = DeviceFarm.ANDROID_OREO.path;

    }

    //Testlere başlamadan önce tüm ayarlamaları bu kısımdan yapıyoruz.
    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException {

        capabilities = new DesiredCapabilities();
        capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
        capabilities.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());
        Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        homePage = new HomePage();
        addContactPage = new AddContactPage();
        methodc=new ContactPagemethod();

    }

    //Homepage sayfasında butona tıklıyoruz ve AddPage sayfasının açıldığını kontrol ediyoruz.
    @Test(priority = 1)
    public void openAddContactOnOreo() throws NullPointerException, InterruptedException {
        homePage.getAddContactBtn().click();
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        Assert.assertEquals(addContactPage.getTitle().getText(),"Add Contact");
    }


    //Bu test içerisinde Add Contact Page üzerinde bulunan tüm elementlerin başlıklarını kontrol ediyoruz.
    @Test(priority = 2)
    public void checkTitle() throws InterruptedException {
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);

        Assert.assertEquals(addContactPage.getTargetAccountTitle().getText(), "Target Account");
        Assert.assertEquals(addContactPage.getContactNameTitle().getText(),"Contact Name");
        Assert.assertEquals(addContactPage.getConcactPhoneTitle().getText(), "Contact Phone");
        Assert.assertEquals(addContactPage.getContactMailTitle().getText(), "Contact Email");

    }


    //Bu test içerisinde name inputuna rakam girebiliyor muyuz onu test ediyoruz.
    @Test(priority = 3)
    public void nameControl() throws InterruptedException {
        String num="2";
        methodc.Name(num);
        Assert.assertEquals(addContactPage.getContactNameField().getText(),num);
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        //İnputu temizliyoruz
        addContactPage.getContactNameField().clear();
    }

    //Bu test içerisinde mail inputuna "@" karakteri girebiliyor muyuz onu test ediyoruz.
    @Test(priority = 4)
    public void mailControl() throws InterruptedException {
        String character="@";
        methodc.setMail(character);
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        Assert.assertEquals(addContactPage.getContactEmailField().getText(),character);

        //İnputu temizliyoruz
        addContactPage.getContactEmailField().clear();

    }




    //Tüm gerekli inputları doldurup butona basarak kullanıcı kaydediyoruz
    @Test(priority = 6)
    public void userAdd(){
        String numPhone="0553698584";

        methodc.Name(username);
        methodc.setMail(email);
        methodc.setPhone(numPhone);

        addContactPage.getContactSaveBtn().click();

    }




    //Kullanıcıyı kayıt olmuş mu onu test ediyoruz.
    @Test(priority = 7)
    public void userAddCheck(){
       homePage.getUserAdd().get(0).click();
    }




    //Phone inputuna standart olarak alan kodu hariç birlikte 11 karakter girilebiliyor,
    // bu testimizde 11'den fazla karakter girebiliyor muyuz onu test ediyoruz.(App'de alan kodu bulunmuyor.)
    @Test(priority = 4)
    public void phoneNumberOfCharacter() throws InterruptedException {
        String phoneNum="055748695522563333";
        String phoneNumCheck;
        methodc.setMail(phoneNum);
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        phoneNumCheck=addContactPage.getContactPhoneField().getText();
        Assert.assertEquals(phoneNumCheck.length(),11);

    }







}
