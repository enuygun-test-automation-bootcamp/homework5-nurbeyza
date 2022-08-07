<h1 align="center"> Beyzanur Özer - Enuygun Ödev 5 </h1>

> >##  ``` Appium ile mobil test   ``` 
ContactManager.apk uygulaması için mobil testler yazıldı.
Derste kurulan yapı geliştirilerek oluşturulan test caseler için testler yazıldı.

## Proje için kurulan yapı aşağıda belirtilmiştir.
> Test package altında oluşturulan yapı aşağıdaki gibidir.
# Java
* [Devices](#devices)
* [Method](#method)
* [Pages](#pages)
* [TestNG](#testng)
* Utilityy

# Resources
* [apps](#apps)
* [capabilities](#capabilities)
* [Charlesproxy](#charlesproxy)

## Devices
Devices package altında <b>DevicesFarm</b> isimli bir enum oluşturulmuştur. Bu enum içerisinde kullandığımız device yolu verilmiştir.

## Method
Method package altında <b>ContactPagemethod</b> isimli bir java class oluşturulmuştur. Bu sınıf içerisinde testlerimizde kullandığımız methodlar yazılmıştır.   
 
<details>
<summary><h4>Methodları görüntülemek için tıklayın</h4></summary>

```java
public void Name(String name){
        addContactPage.getContactNameField().setValue(name);
    }
    
    public void setMail(String mail){
        addContactPage.getContactEmailField().setValue(mail);
    }

    public void setPhone(String phone){
        addContactPage.getContactPhoneField().setValue(phone);
    }
```
</details>

## Pages
Devices package altında <b>Contactpage</b>  ve <b>Homepage</b> isimli 2 java class bulunmaktadır. Bu sınıflar içerisinde Home ve Contact sayfalarında bulunan elementlerin id veya xpath kullanarak locators'larını alarak bir mobil element içerisine atıyoruz.

<details>
<summary><h4>Örnek bir element bulmayı görüntülemek için tıklayın</h4></summary>

```java
  @AndroidFindBy(id = "android:id/title")
  private MobileElement title;

  @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Contact Name\"]")
  private MobileElement contactNameTitle;

```
</details>

## TestNG
TestNG package altında testlerden önce gerçekleştirdiğimiz adımlar(device bağlantısı, uygulamayı açma vb.) ve testlerimiz bulunmaktadır.

<details>
<summary><h4>Örnek bir test görüntülemek için tıklayın</h4></summary>

```java
  public void openAddContactOnOreo() throws NullPointerException, InterruptedException {
        homePage.getAddContactBtn().click();
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        Assert.assertEquals(contactPage.getTitle().getText(),"Add Contact");
        }

```
</details>


## apps
Apps package altında test apk bulunmaktadır.

## capabilities
Capabilities package altında kullandığımız device için yazılan json formatında veriler yer almaktadır.

## Charlesproxy
Charlesproxy package altında Charles proxy için yapılan araştırmalar yer almaktadır.