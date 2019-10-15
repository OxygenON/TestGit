package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class WDStepsDefs {
    @Given("I go to {string} page and print details")
    public void iGoToPageAndPrintDetails(String page) {
       getDriver().get("https://www.google.com");
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());

    }

    @And("I go {string} page and print details")
    public void iGoPageAndPrintDetails(String page) {
        if (page.equalsIgnoreCase("sample")){
            getDriver().get("http://skryabin.com/webdriver/html/sample.html");
            System.out.println(getDriver().getTitle());
        } else if (page.equalsIgnoreCase("google")) {
            getDriver().get("https://www.google.com");
            System.out.println(getDriver().getTitle());
        } else {
            System.out.println("Unknown page: "+getDriver().getCurrentUrl());
        }
    }
//Browser control

    @And("I go back and forward then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().to("https://yahoo.com/");
        System.out.println(getDriver().getTitle());
        System.out.println("______________________________________");
        getDriver().navigate().back();
        System.out.println(getDriver().getTitle());
        getDriver().navigate().forward();
        System.out.println(getDriver().getTitle());
        getDriver().navigate().refresh();
        System.out.println(getDriver().getTitle());
    }

       @Given("I go to {string} page and print some info")
    public void iGoToPageAndPrintSomeInfo(String arg0) {
        getDriver().get("http://skryabin.com/webdriver/html/sample.html");
        System.out.println("The page title is: "+getDriver().getTitle());

    }

    @When("I fill out first name {string} and last name {string}")
    public void iFillOutFirstNameAndLastName(String firstname, String lastname) {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstname);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();

    }
    @And("I fill out required fields")
    public void iFillOutRequiredFields() throws InterruptedException {
        String username="ON";
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        String email="ON2@gmail";
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        String password="1234567";
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        String cpassword="1234567";
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(cpassword);
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

       }

    @Then("I assert submitted data")
    public void iAssertSubmittedData() throws InterruptedException {
        WebElement resultLegend=getDriver().findElement(By.xpath("//legend[@class='applicationResult']"));
        assertThat(resultLegend.isDisplayed()).isTrue();
        String actualAgreed=getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(actualAgreed).isEqualToIgnoringCase("true");
        Thread.sleep(5000);
    }

    @Given("I go to {string} page")
    public void iGoToPage(String arg0) {
        getDriver().get("http://skryabin.com/webdriver/html/sample.html");
        System.out.println(getDriver().getTitle());

    }

                        // Homework part
    @And("I fill out not required fields")
    public void iFillOutNotRequiredFields() throws InterruptedException {
        //select country
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
        Select countrydrop=new Select(getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")));
        countrydrop.selectByVisibleText("Monaco");

        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("4082345656");

        //select Birth Date from pop-up calendar
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        Select monthdrop=new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        monthdrop.selectByVisibleText("Aug");
        Select yeardrop= new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        yeardrop.selectByVisibleText("1970");
        WebElement selectDate = getDriver().findElement(By.linkText("8"));
        selectDate.click();
        Thread.sleep(4000);
        //Allowed to contact: doesnt execute but no error
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).isSelected();
        Thread.sleep(4000);
       // address
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("1414 Ksdkkd, Los Gatos, CA 95005");

       //Choose the car model
        WebElement car=getDriver().findElement(By.xpath("//option[contains(text(),'BMW')]")) ;
        car.click();
        WebElement gend=getDriver().findElement(By.xpath("//label[3]//input[1]"));
        gend.click();
        Thread.sleep(2000);

        //Related docs
        String mainWindow=getDriver().getWindowHandle();
        getDriver().findElement(By.xpath("//button[contains(text(),'Related documents (click)')]")).click();
        Thread.sleep(1000);
        getDriver().switchTo().window(mainWindow);

        //Third party docs
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().findElement(By.xpath("//span[@id='thirdPartyResponseMessage']")).isDisplayed();

        //Choose file
        WebElement uploadElement = getDriver().findElement(By.id("attachment"));
        uploadElement.sendKeys("C:\\DBAR_Ver.txt");
        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).submit();

    }
}
