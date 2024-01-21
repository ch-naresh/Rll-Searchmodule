package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;


public class FirstCryPage extends BasePage{

    // Elements from the homepage
    @FindBy(xpath = "//span[@class='anch poplogin_main poplogin R12_61']") // Update with actual login button XPath
    private WebElement loginButton;

    @FindBy(id = "lemail") // Update with actual username field ID
    private WebElement usernameField;
    
    @FindBy(xpath = "//*[@id=\"login\"]/div[1]/ul/li")
    private WebElement VerifiedButton;
    
    @FindBy(xpath="/html/body/div[2]/div/form/div/div[3]/span") // Update with actual continue button XPath
    private WebElement continueButton;

    @FindBy(id = "lotp") // Update with actual OTP field ID
    private WebElement otpField;

    @FindBy(xpath = "//*[@id=\"verfiedbtn\"]") // Update with actual submit button ID
    private WebElement submitButton;

   
    
    @FindBy(id="search_box")
    public WebElement searchTextBox;
    
    @FindBy(xpath="<span class=\"search-button\" data-icon=\"\"></span>")
    private WebElement searchBtn;
    
    @FindBy(xpath = "//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[1]/a/img") // Update with actual search box ID
    private WebElement FirstItem;
    
    @FindBy(xpath = "//span[@class=\"search-button\"]") // Update with actual search box ID
    private WebElement searchbutton;
    
    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div[2]/form/span") 
    public WebElement searchitem;
    
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]/div[4]/div[1]/div[3]/div[2]/div/div[1]/div[1]/a/img") 
    public WebElement clickonitem;
    
    @FindBy(xpath = "/html/body/div[1]/div[8]/div/div/div[2]/div[3]/div/div/ul[1]/li[4]/a")
    private WebElement clickOnjacket;
    
    @FindBy(xpath = "//img[@title='The Souled Store Tss Originals Full Sleeves Vintage Suit Puffer Hooded Jacket - Black']")
    private WebElement chooseProduct;
    
    By hoverElementLocator = By.xpath("/html/body/div[1]/div[8]/div/div/div[1]/ul/li[2]/a");
    
    By hoverElement = By.xpath("//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[2]/a");
    
    @FindBy(xpath = "//*[@id=\"maindiv\"]/div[2]/div/div[1]/div[2]/a")
	private WebElement watchesFirstItem;
	
	@FindBy(xpath = "//*[@id=\"prod_name\"]")
	private WebElement jacketsFirstItem;
	
	@FindBy(xpath = "//a[contains(@title,'Pine Kids 100% Cotton Roll Up Full Sleeves Checkered Shirt with Inner Tee - Blue')]")
	private WebElement shirtsFirstItem;
	
	@FindBy(xpath = "//a[contains(@title,'Babyhug Full Length Stretchable Cotton Corduroy Joggers Spec Embroidery-Khaki')]")
	private WebElement pantsFirstItem;
	
	@FindBy(xpath = "//div[contains(@class,'lblock lft')]")
	private WebElement firstItem;

    // Constructor
   public FirstCryPage(WebDriver driver) {
        super(driver); // Calling BasePage constructor
    }
	

    // Method to log into the application
    public void login(String username)  {
        loginButton.click();
        usernameField.sendKeys(username);
        
    }
    
    public void clickOnCont() throws InterruptedException {
    	Thread.sleep(10000);
    	continueButton.click();
	}
	
    public void clickOnSubmitBTN() throws InterruptedException {
		Thread.sleep(20000);
		submitButton.click();
		
	}
	

    // Method to search for a product
    public void clickOnBoyFashion() throws InterruptedException {
    	WebElement BoyFashionHover = driver.findElement(hoverElementLocator);
        Actions action = new Actions(driver);
        action.moveToElement(BoyFashionHover).build().perform();
        Thread.sleep(5000);
        clickOnjacket.click();
       
    }
    
    public void entersearchText(String s) {
    	
    	searchTextBox.sendKeys(s);
    }
    
    public void clickSearchButton() {
    	searchBtn.click();
    }
    
    public void clickOnFirstItem() {
    	WebElement elementToHover = driver.findElement(hoverElement);
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).build().perform();
    	
    }
    
    public void chooseTheProduct() throws InterruptedException {
    	
    	
    	Thread.sleep(5000);
    	chooseProduct.click();
    	
    }
    
	
	public String getTitleOfWatchesFirstItem() {
		return watchesFirstItem.getText();
	}
	
	public String getTitleOfJacketsFirstItem() {
		return jacketsFirstItem.getText();
	}
	
	public String getTitleOfShirtsFirstItem() {
		return shirtsFirstItem.getText();
	}
	
	public String getTitleOfPantsFirstItem() {
		return pantsFirstItem.getText();
	}
	public String getTitleOfFirstItem() {

		return firstItem.getText();
		//driver.getWindowHandles();

	}
	

    // Additional methods for other interactions can be added here
}
