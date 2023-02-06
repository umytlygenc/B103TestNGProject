package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_PositiveLoginTest {
    /*
    B103TestNGProject
     */

    /*
    Name: US100201_Admin_Login
    Description:
    Admin bilgileriyle giriş
    Acceptance Criteria:
    Admin olarak, uygulamaya giriş yapabilmeliyim
    https://www.bluerentalcars.com/
    Admin email: jack@gmail.com
    Admin password: 12345
         */
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test
    public void US100201_Admin_Login(){
        Reporter.log("SAYFAYA GIT ");
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Reporter.log("GIRIS BILGILERINI  GIR ");
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin_sifre"));
        blueRentalLoginPage.loginButton.click();
        Reporter.log("GIRIS YAPILDIGINI DOGRULA");
        Reporter.log("DRIVERI KAPAT");
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
        Driver.closeDriver();
        /*
        Smoke test e saga tiklayip xml dosyasi olustur
Run Et
Projeye tıkla > Run > Edit configuration
Xml dosyasını sec > listeners > + a tikla > reports lari ekle
APPLY > OK
XML i run et
Projeyi yenile
test-output dosyasında raporlar cikmis olacak
******************************
Eclipse: test-output dosyası testng non xml raportlari otomatik olacak oluşur
IntelliJ: bu dosyanın oluşması icin mini bir ayar gerekir
******TRABLE SHOOOTING***
1. Xml dosyası classa saga tiknayip create xml seklinde oluşturulmalı
2. Xml RUN edilmeli
3. proje>run edit configurations>listeners> rapolari ekle ve kaydet
4. RAPORTARIN CIKMASI ICIN BU ILISKILENDIRDIGIM XML DOSYASI RUN EDILMESI
         */

    }
}