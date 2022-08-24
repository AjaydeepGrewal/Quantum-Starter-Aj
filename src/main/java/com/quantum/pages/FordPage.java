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
	
	StopWatch stopwatch = new StopWatch();

	public void loadFordHompepage() {
		DriverUtils.getDriver().get("https://www.ford.ca/");
		
		stopwatch.start();
		DeviceUtilsExtended.waitForDisplayed(homepageNav, 20000);
		stopwatch.stop();
		
		long x = stopwatch.getTime();
		String time = Long.toString(x);
		
		injectTimerValueTestReport("HomePage Timer", time);
	}

	public void loadVehicleCategoryPage(String subpage) {
		stopwatch.reset();
		
		QAFExtendedWebElement loadSubPage = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("ford.homepage.nav.subsection"), subpage));
		try
		{
			loadSubPage.click();
		}
		catch(Exception e)
		{
			DriverUtils.getDriver().get("https://www.ford.ca/");
			loadSubPage.click();
		}
		stopwatch.start();	
		DeviceUtilsExtended.waitForDisplayed(subSectionLoaded, 20000);			
		stopwatch.stop();
		
		long x = stopwatch.getTime();
		String time = Long.toString(x);
		
		injectTimerValueTestReport(subpage + " Timer", time);
	}

	public void loadCarPage(String car){
		stopwatch.reset();
		QAFExtendedWebElement loadSubPage = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("ford.homepage.nav.subsection"), "SUVS & CROSSOVERS"));
		QAFExtendedWebElement loadVehiclePage = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("ford.car"), car));
		try
		{
			loadVehiclePage.click();
		}
		catch(Exception e)
		{
			DriverUtils.getDriver().get("https://www.ford.ca/");
			loadSubPage.click();
			loadVehiclePage.click();
		}
		
		stopwatch.start();	
		buildPrice.waitForVisible(10000);			
		stopwatch.stop();
		
		long x = stopwatch.getTime();
		String time = Long.toString(x);
		
		injectTimerValueTestReport(car + " Timer", time);
	}
	
	public void injectTimerValueTestReport(String timeName, String timerValue)
	{
		Map<String, Object> params1 = new HashMap<>();
		params1.put("name", timeName);
		params1.put("result", timerValue);
		Object result =  DriverUtils.getDriver().executeScript("mobile:status:timer", params1);
		System.out.println(timeName + ":" + result);
	}
}
