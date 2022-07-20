package com.quantum.steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;

import com.google.common.collect.ImmutableMap;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.pages.FordPage;
import com.quantum.pages.GooglePage;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DeviceUtilsExtended;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class FordStepDefs  extends WebDriverBaseTestPage<WebDriverTestPage>{

	FordPage pageObj = new FordPage();
	
	@FindBy(locator="xpath=//div[@class = 'navbar-header no-float-md']")
	private QAFExtendedWebElement homepageNav;
	
	@FindBy(locator = "ford.homepage.nav.subsection")
	private QAFExtendedWebElement homepageNavSubSection;
	
	@FindBy(locator = "ford.homepage.nav.subsection.load")
	private QAFExtendedWebElement subSectionLoaded;
	
	@FindBy(locator = "ford.ca")
	private QAFExtendedWebElement car;


	@Given("I load ford homepage")
	public void iLoadFordHomePage() throws Throwable {
		pageObj.loadFordHompepage();
	}

	@When("^I load vehicle category page for \"([^\"]*)\"$")
	public void iLoadVehiclePage(String subpage) throws Throwable {
		pageObj.loadVehicleCategoryPage(subpage);
	}
	
	@When("^I load page for \"([^\"]*)\"$")
	public void iLoadPageFor(String car) throws Throwable {
		pageObj.loadCarPage(car);
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
}
