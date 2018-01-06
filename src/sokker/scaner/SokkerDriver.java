package sokker.scaner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sokker.scaner.utils.CSS;

public class SokkerDriver extends FirefoxDriver {

	public SokkerDriver(DesiredCapabilities capabilities) {
		super(capabilities);
	}

	public WebElement getElement(CSS cssSelector) {
		WebDriverWait wait = new WebDriverWait(this, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector.toString())));
		return this.findElement(By.cssSelector(cssSelector.toString()));
	}

	public List<WebElement> getElements(CSS cssSelector) {
		WebDriverWait wait = new WebDriverWait(this, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector.toString())));
		return this.findElements(By.cssSelector(cssSelector.toString()));
	}

	public WebElement getElement(CSS cssSelector, int timeout) {
		WebDriverWait wait = new WebDriverWait(this, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector.toString())));
		return this.findElement(By.cssSelector(cssSelector.toString()));
	}

	public WebDriverWait waitDriver() {
		return new WebDriverWait(this, 5);
	}
}