package uol.rfc.common;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommand {
    private final WebDriver driver;
    private Wait<WebDriver> defaultWait;
    private Wait<WebDriver> shortWait;

    public SeleniumCommand(WebDriver driver) {
        this.driver = driver;
        this.defaultWait = new WebDriverWait(driver, 30);
        this.shortWait = new WebDriverWait(driver, 3);
    }

    /*
     * Metodos de controle
     */

    public void stop() {
        driver.quit();
    }

    /*
     * Metodos para acoes na tela
     */

    public void open(String url) {
        driver.navigate().to(url);
    }

    public void check(WebElement element) { 
        if (!element.isSelected()) {
            element.click();
            waitForChecked(element);
        }
    }

    public void uncheck(String locator) {
        WebElement element = element(locator);
        if (element.isSelected()) {
            element.click();
            waitForNotChecked(locator);
        }
    }
    
    public boolean isElementContainsText(WebElement element, String value) {
    	return element.getText().contains(value);
    }

    public void type(WebElement element, String value) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clear(WebElement element) {
        waitForVisible(element);
        element.clear();
    }

    public void click(WebElement element) {
        waitForVisible(element);
        element.click();
    }

    public void selectByVisibleText(String locator, String visibleText) {
        new Select(element(locator)).selectByVisibleText(visibleText);
    }

    public void selectByValue(String locator, String value) {
        new Select(element(locator)).selectByValue(value);
    }

    public void chooseOkOnNextConfirmation() {
        driver.switchTo().alert().accept();
    }

    public void openWindow(String url, String windowName) {
        driver.switchTo().window(windowName).navigate().to(url);
    }

    public void selectWindow(String windowName) {
        driver.switchTo().window(windowName);
    }
   
    public boolean isElementPresent(WebElement element) {
        try {
            return element!= null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isVisible(String locator) {
        try {
            WebElement element = element(locator);
            return element != null ? element.isDisplayed() : false;
        } catch (ElementNotVisibleException e) {
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getText(WebElement element) {
    	waitForVisible(element);
        return element.getText();
    }

    public String getValue(String locator) {
        return valueFrom(element(locator));
    }

    public String getAttribute(String locator, String attributeName) {
        return element(locator).getAttribute(attributeName);
    }

    public String getAttribute(String locator) {
        String[] locatorAndAttrName = locator.split("@");
        if (locatorAndAttrName.length != 2) {
            throw new IllegalArgumentException("Sintaxe esperada: cssLocator@nomeAtributo");
        }
        return getAttribute(locatorAndAttrName[0], locatorAndAttrName[1]);
    }

    public int getLocatorCount(String locator) {
        return elements(locator).size();
    }

    public String getSessionId() {
        Cookie jSessionId = driver.manage().getCookieNamed("JSESSIONID");
        return jSessionId != null ? jSessionId.getValue() : null;
    }
    
    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }
   
    public void executeJs(String jsString) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this.driver;
        jsExecutor.executeScript(jsString, "");
    }
    
    /*
     * Metodos para espera
     */

    public void waitForTitle(final String value) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().contains(value);
            }
        });
    }

    public void waitForElementPresent(final WebElement element) {
        defaultWait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
    }

    public void waitForElementNotPresent(final String locator) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return element(locator) == null;
                } catch (NotFoundException e) {
                    return true;
                }
            }
        });
    }

    public void waitForVisible(final WebElement element) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {               
                return element != null ? element.isDisplayed() : false;
            }
        });
    }

    public void waitForNotVisible(final String locator) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    WebElement element = element(locator);
                    return element != null ? !element.isDisplayed() : true;
                } catch (ElementNotVisibleException e) {
                    return true;
                } catch (NoSuchElementException e) {
                    return true;
                }
            }
        });
    }

    public void waitForChecked(final WebElement element) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return element.isSelected();
            }
        });
    }

    public void waitForNotChecked(final String locator) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return !element(locator).isSelected();
            }
        });
    }

    public void waitForTextPresent(final String text) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getPageSource().contains(text);
            }
        });
    }

    public void waitForText(final String locator, final String text) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return text.equals(element(locator).getText());
            }
        });
    }

    public void waitForAlert(final String pattern) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.switchTo().alert().getText().contains(pattern);
            }
        });
    }

    public void waitForLocatorCount(final String locator, final int expectedNumber) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return elements(locator).size() == expectedNumber;
            }
        });
    }

    public void waitForValue(final String locator, final String pattern) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return valueFrom(element(locator)).contains(pattern);
            }
        });
    }

    public void waitForPopUp(final String windowName) {
        shortWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                driver.switchTo().window(windowName);
                return true;
            }
        });
    }

    public void waitForAnyValue(final String locator) {
        defaultWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return valueFrom(element(locator)).matches(".+");
            }
        });
    }

    public void waitSeconds(long time) {
     try {
		Thread.sleep(time*1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}	
    }
    
  
    private WebElement element(String cssLocator) {
        return driver.findElement(By.cssSelector(cssLocator));
    }

    private List<WebElement> elements(String cssLocator) {
        return driver.findElements(By.cssSelector(cssLocator));
    }

    private String valueFrom(WebElement element) {
        return element.getAttribute("value");
    }

    
    
  }