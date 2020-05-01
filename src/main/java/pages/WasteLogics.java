package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WasteLogics {
    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = "(//table[@id='MyYardDisclosure9577009378082_frm']/tbody/tr[@class='gl-1'])[2]" +
            "/td[contains(text(),'146566')]")
    private WebElement orderId;

    @FindBy(xpath = "(//*[@class='gl-0 tgl eo ui-selectee']/tr/td[@class='cal' and contains (text()," +
            " 'TEST CUSTOMER')])[2]")
    private WebElement company;

    @FindBy(xpath = "(//*[@class='gl-0 tgl eo ui-selectee']/tr/td[@class='cal' and contains (text()," +
            " 'TEST ADDRESS, TEST TOWN, 111111')])[2]")
    private WebElement invoiceAddress;

    @FindBy(xpath = "(//i[@class='bls icon-chevron-sign-down blm'])[6]/..")
    private WebElement grade;

    @FindBy(xpath = "//*[@class='car' and contains (text(), '0.460 T')]")
    private WebElement weight;

    @FindBy(xpath = "(//*[@class='car' and contains (text(), '£100.00')])[4]")
    private WebElement priceFlat;

    @FindBy(xpath = "//*[@class='car' and contains (text(), '£4.60')]")
    private WebElement priceTonne;

    @FindBy(xpath = "//*[@class='car' and contains (text(), '£110.10')]")
    private WebElement priceItem;

    public WasteLogics(WebDriver driver, JavascriptExecutor js) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderId() {
        js.executeScript("arguments[0].scrollIntoView();", orderId);
        return orderId.getText();
    }

    public String getCompany() {
        js.executeScript("arguments[0].scrollIntoView();", company);
        return company.getText();
    }

    public String getInvoiceAddress() {
        js.executeScript("arguments[0].scrollIntoView();", invoiceAddress);
        return invoiceAddress.getText();
    }

    public String getGrade() {
        js.executeScript("arguments[0].scrollIntoView();", grade);
        return grade.getText();
    }

    public String getWeight() {
        js.executeScript("arguments[0].scrollIntoView();", weight);
        return weight.getText();
    }

    public String getPriceFlat() {
        js.executeScript("arguments[0].scrollIntoView();", priceFlat);
        return priceFlat.getText();
    }

    public String getPriceItem() {
        js.executeScript("arguments[0].scrollIntoView();", priceItem);
        return priceItem.getText();
    }

    public String getPricePerTonne() {
        js.executeScript("arguments[0].scrollIntoView();", priceTonne);
        return priceTonne.getText();
    }
}
