package ryanairways.ryanairone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paymentPage {

	WebDriver driver;

	public paymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void rSeven() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);

		Actions A = new Actions(driver);

		WebElement phnNumber = driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/ng-component[1]/ry-spinner[1]/div[1]/payment-form[1]/form[1]/div[1]/contact-details[1]/div[1]/div[1]/div[1]/div[2]/ry-input-d[1]/div[1]/input[1]"));

		wait.until(ExpectedConditions.visibilityOf(phnNumber));
		wait.until(ExpectedConditions.elementToBeClickable(phnNumber));
		phnNumber.sendKeys("123456788");

		driver.findElement(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[2]/insurance/div/div[3]/div[1]/ry-checkbox/label/div/div[1]"))
				.click();

		WebElement frameOne = driver.findElement(By.xpath("//span[contains(text(),' Credit Card ')]"));
		js.executeScript("arguments[0].scrollIntoView();", frameOne);

		driver.switchTo()
				.frame(driver.findElement(By.cssSelector("iframe.modal__credit-card-iframe.ng-star-inserted")));
		driver.findElement(By.xpath("/html/body/app-root/div/ry-input-d/div/input")).sendKeys("123456789123456");
		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='cc-exp']")));

		driver.findElement(By.xpath("//input[@name='cc-exp']")).sendKeys("0725");
		driver.findElement(By.xpath("//input[@placeholder='CVV']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@name='ccname']")).sendKeys("gagan hn");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/div/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[1]/div/input")));
		driver.findElement(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/div/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[1]/div/input"))
				.sendKeys("35 woodlawn grove");
		driver.findElement(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/div/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[3]/div/input"))
				.sendKeys("Waterford");

		WebElement countryName = driver.findElement(By.xpath("(//input[@type='text']) [6]"));

		A.moveToElement(countryName).click();
		A.moveToElement(countryName).click().sendKeys("ireland").sendKeys(Keys.ENTER).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/div/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[4]/div/input")));
		driver.findElement(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/div/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[4]/div/input"))
				.sendKeys("123456");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[8]/div/terms-and-conditions/div/div/ry-checkbox/label/div/div[1]")));
		driver.findElement(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[8]/div/terms-and-conditions/div/div/ry-checkbox/label/div/div[1]"))
				.click();
		driver.findElement(By.xpath("//button[contains(text(),' Pay now ')]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/div[1]/ry-alert/div")));

		WebElement transactionErrorMessage = driver.findElement(By.xpath(
				"/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/div[1]/ry-alert/div"));

		System.out.println(transactionErrorMessage.getText());

	}
}
