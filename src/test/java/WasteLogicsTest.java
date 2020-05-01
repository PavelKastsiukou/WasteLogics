import browser.DriverManager;
import browser.DriverManagerFactory;
import browser.DriverType;
import configuration.Configuration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WasteLogics;

public class WasteLogicsTest {
    private static final String ORDER_ID = "146566";
    private static final String COMPANY = "TEST CUSTOMER";
    private static final String INV_ADDRESS = "TEST ADDRESS, TEST TOWN, 111111";
    private static final String GRADE = "Mixed Municipal Waste";
    private static final String WEIGHT = "0.460 T";
    private static final String PRICE_FLAT = "£100.00";
    private static final String PRICE_PER_TONNE = "£4.60";
    private static final String PRICE_PER_ITEM = "£110.10";

    DriverManager driverManager;
    WebDriver driver;
    JavascriptExecutor js;
    WasteLogics wasteLogics;

    @BeforeTest
    public void createEnv() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Configuration.getMainUrl());
        wasteLogics = new WasteLogics(driver, js);
    }

    @Test
    public void checkOrder() {
        Assert.assertEquals(wasteLogics.getOrderId(), ORDER_ID);
        Assert.assertEquals(wasteLogics.getCompany(), COMPANY);
        Assert.assertEquals(wasteLogics.getInvoiceAddress(), INV_ADDRESS);
        Assert.assertEquals(wasteLogics.getGrade(), GRADE);
        Assert.assertEquals(wasteLogics.getWeight(), WEIGHT);
        Assert.assertEquals(wasteLogics.getPriceFlat(), PRICE_FLAT);
        Assert.assertEquals(wasteLogics.getPriceItem(), PRICE_PER_ITEM);
        Assert.assertEquals(wasteLogics.getPricePerTonne(), PRICE_PER_TONNE);
    }

    @AfterTest
    public void closeEnv() {
        if (driver != null) {
            driverManager.quitDriver();
        }
    }
}
