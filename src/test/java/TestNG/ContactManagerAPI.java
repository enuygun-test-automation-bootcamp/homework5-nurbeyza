package TestNG;
import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.HomePage;
import utilityy.DeviceFarmUtility;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ContactManagerAPI {
    public static AppiumDriver<?> Driver;

    AddContactPage addContactPage;
    DesiredCapabilities capabilities;
    HomePage homePage;
    private String oreo;

    public ContactManagerAPI(){
         oreo = DeviceFarm.ANDROID_OREO.path;

    }
    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException {

        capabilities = new DesiredCapabilities();
        capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
        capabilities.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());
        Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        homePage = new HomePage();
        addContactPage = new AddContactPage();

    }


    @Test(priority = 1)
    public void openAddContactOnOreo() throws NullPointerException, InterruptedException {
        homePage.getAddContactBtn().click();
        Thread.sleep(5000);

    }


    //Bu test içerisinde Add Contact Page üzerinde bulunan tüm elementlerin başlıklarını kontrol ediyoruz.
    @Test
    public void checkTitle() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(addContactPage.getTitle().getText(),"Add Contact");
        Assert.assertEquals(addContactPage.getTargetAccountTitle().getText(), "Target Account");
        Assert.assertEquals(addContactPage.getContactNameTitle().getText(),"Contact Name");
        Assert.assertEquals(addContactPage.getConcactPhoneTitle().getText(), "Contact Phone");
        Assert.assertEquals(addContactPage.getContactMailTitle().getText(), "Contact Email");

    }

    //Bu test içerisinde name inputuna rakam girebiliyor muyuz onu test ediyoruz.
    @Test
    public void nameControl() throws InterruptedException {
        String num="2";
        addContactPage.getContactNameField().setValue(num);
        Thread.sleep(1000);
        Assert.assertEquals(addContactPage.getContactNameField().getText(),num);
    }

    //Bu test içerisinde mail inputuna "@" karakteri girebiliyor muyuz onu test ediyoruz.
    @Test
    public void mailControl() throws InterruptedException {
        String character="@";
        addContactPage.getContactEmailField().setValue(character);
        Thread.sleep(1000);
        Assert.assertEquals(addContactPage.getContactEmailField().getText(),character);

    }

    //Tüm gerekli inputları doldurup butona basarak kullanıcı kaydediyoruz
    @Test
    public void userAdd(){
        String name="beyza";
        String mail="beyza@gmail.com";
        String num="0553698584";

        addContactPage.getContactNameField().setValue(name);
        addContactPage.getContactEmailField().setValue(mail);
        addContactPage.getContactPhoneField().setValue(num);

        addContactPage.getContactSaveBtn().click();

    }


    //Kullanıcıyı kayıt olmuş mu onu test ediyoruz.
    @Test
    public void userAddCheck(){
       Assert.assertEquals( homePage.getUserAdd().getText(),"beyza");
    }



}
