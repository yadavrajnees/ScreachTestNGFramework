package org.cressanda.IFM.WebUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.Getter;

@Getter
public class Uti {

	private static Uti instance;
	private WebDriver driver;

	private Uti() {

	}

	public static Uti getInstance() {
		if (instance == null) {
			instance = new Uti();
		}
		return instance;
	}

	public void launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins");
				option.addArguments("--incognito");
				driver = new ChromeDriver(option);

			} else if (browserName.equalsIgnoreCase("firfox")) {

			} else if (browserName.equalsIgnoreCase("edge")) {

			} else if (browserName.equalsIgnoreCase("safari")) {

			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			printMsgPass(browserName + " is launched successfully");
		} catch (Exception e) {
			printMsgFail(browserName + " is launched successfully");
		}
	}

	public void openApplication(String url) {
		try {
			driver.get(url);
			printMsgPass(url + " hit successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			String script = "window.location.href='" + url + "';";
			jse.executeScript(script);
			printMsgPass(url + " hit successfully");
		} catch (Exception e) {
			printMsgFail(url + " not hitted");
		}
	}

	public void windowMaximize(String browserName) {
		try {
			driver.manage().window().maximize();
			printMsgPass(browserName + " window is maximized");
		} catch (Exception e) {
			printMsgFail(browserName + " window is not maximized");
		}
	}

	public void printMsgFail(String failMsg) {
		System.err.println("FAILLED :" + failMsg);
	}

	public void printMsgPass(String passMsg) {
		System.err.println("PASSED :" + passMsg);
	}

	public void implicitlyWait(long seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			printMsgPass("the maximum time for waiting is " + seconds);
		} catch (Exception e) {
			printMsgFail("the maximum time for " + seconds + " is not waitted");
		}
	}

	private Properties prop;

	public void loadProperties(String fileName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src\\main\\resources\\" + fileName + ".properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getPropertyData(String keyName) {
		String data = prop.getProperty(keyName);
		return data;
	}

	public void sendKeys(WebElement weObj, String inputData) {
		String element = weObj.getAccessibleName();
		if (weObj.isDisplayed() && weObj.isEnabled()) {

			try {
				weObj.sendKeys(inputData);
			} catch (ElementNotInteractableException e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].value='" + inputData + "'", weObj);

			} catch (StaleElementReferenceException e) {
				weObj.sendKeys(inputData);
			} catch (Exception e) {

			}
		} else {

		}
	}

	public void click(WebElement weObj) {
		String element = weObj.getAccessibleName();

		if (weObj.isDisplayed() && weObj.isEnabled()) {

			try {
				weObj.click();
			} catch (ElementClickInterceptedException e) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click()", weObj);

			} catch (StaleElementReferenceException e) {
				weObj.click();
			} catch (Exception e) {

			}
		} else {

		}
	}

}
