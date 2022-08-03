package com.quantum.pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.PropertyUtil;
import com.quantum.utils.DeviceUtilsExtended;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;


public class FordPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	PropertyUtil props = ConfigurationManager.getBundle();

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	@FindBy(locator="xpath=//div[@class = 'navbar-header no-float-md']")
	private QAFExtendedWebElement homepageNav;
	
	@FindBy(locator = "ford.homepage.nav.subsection")
	private QAFExtendedWebElement homepageNavSubSection;
	
	@FindBy(locator = "ford.homepage.nav.subsection.load")
	private QAFExtendedWebElement subSectionLoaded;
	
	@FindBy(locator = "ford.ca")
	private QAFExtendedWebElement car;
	
	@FindBy(locator="xpath=//span[@class = 'model-name']")
	private QAFExtendedWebElement buildPrice;

	public void loadFordHompepage() {
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		DriverUtils.getDriver().get("https://www.ford.ca/");
		DeviceUtilsExtended.waitForDisplayed(homepageNav, 5000);
		
		stopwatch.stop();
		long x = stopwatch.getTime();
		String time = Long.toString(x);
		
		Map<String, Object> params1 = new HashMap<>();
		params1.put("name", "HomePage Timer");
		params1.put("result", time);
		Object result =  DriverUtils.getDriver().executeScript("mobile:status:timer", params1);
		System.out.println("HomePage Timer " + result);
	}

	public void loadVehicleCategoryPage(String subpage){
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		QAFExtendedWebElement loadSubPage = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("ford.homepage.nav.subsection"), subpage));
		loadSubPage.click();
		subSectionLoaded.waitForVisible(20000);
		
		stopwatch.stop();
		long x = stopwatch.getTime();
		String time = Long.toString(x);
		
		Map<String, Object> params1 = new HashMap<>();
		params1.put("name", subpage + " Timer");
		params1.put("result", time);
		Object result =  DriverUtils.getDriver().executeScript("mobile:status:timer", params1);
		System.out.println("Subpage Timer " + result);
	}

	public void loadCarPage(String car){
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		QAFExtendedWebElement loadSubPage = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("ford.car"), car));
		loadSubPage.click();
		buildPrice.waitForVisible(10000);
		
		stopwatch.stop();
		long x = stopwatch.getTime();
		String time = Long.toString(x);
		
		Map<String, Object> params1 = new HashMap<>();
		params1.put("name", car + " Timer");
		params1.put("result", time);
		Object result =  DriverUtils.getDriver().executeScript("mobile:status:timer", params1);
		System.out.println("Car Timer " + result);
	}
}
