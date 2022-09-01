package definitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;


public class ForreeTestingApps {

    By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    By skipPhase = By.id("coffee.fore2.fore:id/skip_text");
    By nextButton = By.id("coffee.fore2.fore:id/button_text_button");
    By onlyThisTime = By.id("com.android.permissioncontroller:id/permission_allow_one_time_button");
    By orderNow = By.id("coffee.fore2.fore:id/home_text_order_label");
    By addToCart = By.id("coffee.fore2.fore:id/button_text_button");
    By loginButton = By.id("coffee.fore2.fore:id/login_button");
    By cartSummary = By.id("coffee.fore2.fore:id/catalog_header_cart_icon");
    By inputPhone = By.id("coffee.fore2.fore:id/input_text_input");


    By manukaCategories = By.xpath("//android.widget.TextView[@text='Manuka']");
    By manukaAmericano = By.xpath("//android.widget.TextView[@text='Manuka Americano']");
    By coffeeCategories = By.xpath("//android.widget.TextView[@text='Coffee']");
    By cartIcon = By.id("coffee.fore2.fore:id/catalog_header_cart_layout");
    By closeButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ImageView");

    String containsText ="//android.widget.TextView[@text='%s']";
    String containsText2 ="//android.widget.TextView[contains(@text, '%s')]";


    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @Before
    public void setupConfig(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "Android");
            caps.setCapability("appPackage", "coffee.fore2.fore");
            caps.setCapability("appActivity", "coffee.fore2.fore.MainActivity");
            caps.setCapability("platformName", "Android");
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("platformVersion", "13.0");
            //caps.setCapability("noReset", true);
            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
            wait = new WebDriverWait(driver, 3000);

        }catch (Exception e){
            System.out.println("Terjadi Error "+e.getMessage());
        }
    }


    @Given("Open Foree apps and enter dashboard")
    public void openAppsEnterDashboard(){



        //System.out.println("If UPDATE Button is displayed");
        //String syrupManukaHoney = String.format(containsText, "UPDATE");
        //boolean isDisplayUpdateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(syrupManukaHoney))).isDisplayed();
        //if(isDisplayUpdateButton){
        //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(syrupManukaHoney))).click();
        //}

        System.out.println("Click Allow Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowButton)).click();


        System.out.println("Click Skip Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(skipPhase)).click();

        System.out.println("Click Next Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton)).click();

        System.out.println("Click Only this time Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(onlyThisTime)).click();

        System.out.println("Click Location Store Icon");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coffee.fore2.fore:id/home_card_store_location_icon"))).click();

        System.out.println("Find Location Store");
        MobileElement mobileElement = driver.findElementById("coffee.fore2.fore:id/search_bar_input");
        mobileElement.sendKeys("Binjai Super Mall");

        System.out.println("Click Binjai Super Mall");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"))).click();

        System.out.println("Select Binjai Super Mall");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coffee.fore2.fore:id/button_text_button"))).click();
    }

    @Given("Search Manuka Affericano and add to cart")
    public void searchManukaAffericanoAndAddToCart(){


        System.out.println("Click Manuka Categories");
        wait.until(ExpectedConditions.visibilityOfElementLocated(manukaCategories)).click();

        System.out.println("Click Manuka Americano Coffee");
        wait.until(ExpectedConditions.visibilityOfElementLocated(manukaAmericano)).click();

        //scrolling element until down
        //System.out.println("Scrolling until down");
        while (driver.findElements(addToCart).size()==0){
            Dimension size = driver.manage().window().getSize();
            int starty = (int) (size.height * 0.80);
            int endy = (int) (size.height * 0.20);
            int startx = size.width / 2;
            System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
            driver.swipe(startx, starty, startx, endy, 3000);
        }

        //TouchAction action = new TouchAction(driver).longPress(20,20).moveTo(20, 2000).release();
        //action.perform();

        System.out.println("Click Ice cube coffe toping");
        String iceCube = String.format(containsText ,"ICE CUBE");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iceCube))).click();


        System.out.println("Click less ice toping");
        String lessIceCube = String.format(containsText, "Less Ice");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lessIceCube))).click();


        System.out.println("Click Ice cube coffe toping");
        String syrupCategories = String.format(containsText, "SYRUP");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(syrupCategories))).click();


        System.out.println("Click Ice cube aren");
        String syrupManukaHoney = String.format(containsText, "Aren");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(syrupManukaHoney))).click();


        System.out.println("Click Add To Cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).click();

        System.out.println("Click Skip Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(skipPhase)).click();

        System.out.println("Click Close Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).click();

    }

    @And("Search Coffee and add to cart")
    public void searchCoffeeAndAddToCart(){


        System.out.println("Click categori coffee");
        wait.until(ExpectedConditions.visibilityOfElementLocated(coffeeCategories)).click();

        System.out.println("Click expresso");
        String expresso = String.format(containsText, "Espresso");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expresso))).click();

        System.out.println("Compare price expresso, if price 17.000 then passed");
        String price = driver.findElementById("coffee.fore2.fore:id/product_detail_product_price").getText().replace("Rp ", "");
        Assert.assertEquals("17.000",price);


        while (driver.findElements(addToCart).size()==0){
            Dimension size = driver.manage().window().getSize();
            int starty = (int) (size.height * 0.80);
            int endy = (int) (size.height * 0.20);
            int startx = size.width / 2;
            System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

            driver.swipe(startx, starty, startx, endy, 3000);
        }

        System.out.println("Click Add To Cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).click();

        System.out.println("Click Skip Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(skipPhase)).click();

        System.out.println("Click Close Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).click();

        System.out.println("Validate Total Item");
        String cartCount = driver.findElementById("coffee.fore2.fore:id/catalog_header_cart_count").getText();
        Assert.assertEquals("2",cartCount);

        String countSummary = driver.findElementById("coffee.fore2.fore:id/cart_summary_text_count").getText();
        Assert.assertTrue(countSummary.contains(cartCount));
    }

    @When("Buy all the items in cart")
    public void buyAllItemsInCart(){
        System.out.println("Click Cart Summary");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartSummary)).click();

        System.out.println("Click Add Item");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).click();

        System.out.println("Click Skip Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(skipPhase)).click();

        System.out.println("Click Close Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView"))).click();

    }

    @But("Input invalid phone number")
    public void inputInvalidPhoneNumber(){
        System.out.println("Click Pesan Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coffee.fore2.fore:id/catalog_cart_summary"))).click();
        //System.out.println("Click Beli Sekarang Button");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coffee.fore2.fore:id/button_text_button"))).click();

        System.out.println("Click Login Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coffee.fore2.fore:id/login_button"))).click();

        System.out.println("Input Invalid Phone Number");
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhone)).sendKeys("@!@#$%^&*()");
    }

    @Then("Showing error message")
    public void showingErrorMessage(){
        System.out.println("Click Next Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coffee.fore2.fore:id/next_button"))).click();

        System.out.println("Validate Top Snackbar Error");
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Textview[@text='Nomor telepon tidak valid']"));
    }

    @After
    public void dispatchConfig(){
        driver.quit();
    }

}
