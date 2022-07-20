package com.quantum.utils;

import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.quantum.utils.DeviceUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class DeviceUtilsExtended extends DeviceUtils {


	/***************************************************************************************
	 * @description	switch driver
	 * @param 
	 * @return
	 **************************************************************************************/
	public static void switchToDriver(String driverName) {

		System.out.println("----- Switching to driver -----" + driverName);
		ConfigurationManager.getBundle().setProperty(driverName.replaceAll("(?i)remote", "") + ".env.resources",
				ConfigurationManager.getBundle().getString("env.resources"));
		DriverUtils.switchToDriver(driverName);

	}

	/***************************************************************************************
	 * @description	type text
	 * @param  "https://developers.perfectomobile.com/display/PD/Type"
	 * @return String
	 **************************************************************************************/
	public static String type(String text) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("text", String.valueOf(text));
		String result= (String) getQAFDriver().executeScript("mobile:typetext", new Object[] { params });
		System.out.println("mobile:typetext---" + text + ":::" + result);
		return result;
	}


	/***************************************************************************************
	 * @description	set text on field using visual analysis to find it
	 * @param "https://developers.perfectomobile.com/pages/viewpage.action?pageId=14877169"
	 * @return
	 **************************************************************************************/
	public static String setTextvisualAnalysis(String...parameters ) {

		Map<String, Object> params = new HashMap<>();
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
		}
		String result = (String) getQAFDriver().executeScript("mobile:edit-text:set",params);
		System.out.println("mobile:edit-text:set---" + result);
		return result;
	}


	/***************************************************************************************
	 * @description
	 * @param "https://developers.perfectomobile.com/pages/viewpage.action?pageId=14877145"
	 * @return
	 **************************************************************************************/
	public static String clickButtonTextVisualAnalysis(String... parameters) {

		Map<String, Object> params = new HashMap<>();
		String label = null;
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
			if (arrParameter[0].equals("label")) {
				label = arrParameter[1];
			}
		}
		String result = (String) getQAFDriver().executeScript("mobile:button-text:click", params);
		System.out.println("mobile:button-text:click---" + label + ":::" + result);
		return result;
	}


	/***************************************************************************************
	 * @description	
	 * @param 	"https://developers.perfectomobile.com/pages/viewpage.action?pageId=14876853"
	 * @return
	 **************************************************************************************/
	public static String clickImageVisualAnalysis(String... parameters) {

		Map<String, Object> params = new HashMap<>();
		String label = null;
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
			if (arrParameter[0].equals("label")) {
				label = arrParameter[1];
			}
		}
		String result = (String) getQAFDriver().executeScript("mobile:button-image:click", params);
		System.out.println("mobile:button-image:click---" + label + ":::" + result);
		return result;

	}


	/***************************************************************************************
	 * @description looking for text with visual analysis using mobile:checkpoint:text
	 * @param 	"https://developers.perfectomobile.com/pages/viewpage.action?pageId=14877166"
	 * @return
	 **************************************************************************************/
	public static boolean isTextVisibleCheckpointVisualAnalysis(String... parameters) {

		Map<String, Object> params = new HashMap<>();
		String content = null;
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
			if (arrParameter[0].equals("content")) {
				content = arrParameter[1];
			}
		}
		String result = (String) getQAFDriver().executeScript("mobile:checkpoint:text", params);
		System.out.println("mobile:checkpoint:text---" + content + ":::" + result);
		return result.equals("true");
	}
	
	
	/***************************************************************************************
	 * @description looking for text with visual analysis using mobile:find:text
	 * @param 	"https://developers.perfectomobile.com/pages/viewpage.action?pageId=14877225"
	 * @return
	 **************************************************************************************/
	public static boolean isTextVisibleFindVisualAnalysis(String... parameters) {

		Map<String, Object> params = new HashMap<>();
		String content = null;
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
			if (arrParameter[0].equals("content")) {
				content = arrParameter[1];
			}
		}
		String result = (String) getQAFDriver().executeScript("mobile:checkpoint:text", params);
		System.out.println("mobile:find:text---" + content + ":::" + result);
		return result.equals("true");
	}
	
	
	/***************************************************************************************
	 * @description looking for text with visual analysis using mobile:screen:text
	 * @param 	"https://developers.perfectomobile.com/pages/viewpage.action?pageId=14877227"
	 * @return
	 **************************************************************************************/
	public static boolean isTextVisibleScreenTextVisualAnalysis(String... parameters) {

		Map<String, Object> params = new HashMap<>();
		String content = null;
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
			if (arrParameter[0].equals("content")) {
				content = arrParameter[1];
			}
		}
		String result = (String) getQAFDriver().executeScript("mobile:checkpoint:text", params);
		System.out.println("mobile:screen:text---" + content + ":::" + result);
		return result.equals("true");
	}


	/***************************************************************************************
	 * @description set text using keyboard
	 * @param 	
	 * @return
	 **************************************************************************************/
	public static void sendKeys(String t) {

		System.out.println("---- Get keyboard - sendKeys ----");
		getQAFDriver().getKeyboard().sendKeys(t);
	}


	/***************************************************************************************
	 * @description close keyboard
	 * @param 	
	 * @return
	 **************************************************************************************/
	public static String closeKeyboard() {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", "off");
		String result= (String) getQAFDriver().executeScript("mobile:keyboard:display", new Object[] { params });
		System.out.println("mobile:keyboard:display---" + result);
		return result;
	}


	public static String callMe(String n) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to.handset", String.valueOf(n));
		String result = (String) getQAFDriver().executeScript("mobile:gateway:call", new Object[] { params });
		System.out.println("mobile:gateway:call---" + result);
		return result;
	}


	public static String gpsOn() {

		return sendADB("settings put secure location_providers_allowed +gps");
	}


	public static String gpsOff() {

		return sendADB("settings put secure location_providers_allowed -gps");
	}


	public static String sendADB(String cmd) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("command", cmd);
		String result = (String) getQAFDriver().executeScript("mobile:handset:shell", new Object[] { params });
		System.out.println("mobile:handset:shell ---- " + cmd + " ==== " );
		return result;
	}


	public static QAFExtendedWebElement  findElementByLinkText(String tx) {

		return getQAFDriver().findElement(By.linkText(tx));
	}


	public static QAFExtendedWebDriver getQAFDriver() {

		return (new WebDriverTestBase()).getDriver();
	}


	public static boolean startRecord() {

		HashMap<?, ?> params = new HashMap<Object, Object>();
		return (boolean) getQAFDriver().executeScript("mobile:audio.recording:start", new Object[] { params });
	}


	public static boolean stopRecord() {

		HashMap<?, ?> params = new HashMap<Object, Object>();
		return (boolean) getQAFDriver().executeScript("mobile:audio.recording:stop", new Object[] { params });
	}


	public static String speech2Text(String link) {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("AudioLink", link);
		return getQAFDriver().executeScript("mobile:Audio:speech2text", new Object[] { params }).toString();
	}


	/***************************************************************************************
	 * @description	get device phone number
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getDevicePhoneNumber() {

		System.out.println("--- Getting device phone number ----");
		Map<String, Object> params = new HashMap<>();
		params.put("property", "phoneNumber");
		return (String) getQAFDriver().executeScript("mobile:handset:info", params);

	}

	/***************************************************************************************
	 * @description	get device manufacturer
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getDeviceManufacturer() {

		System.out.println("--- Getting device manufacturer ----");
		Map<String, Object> params = new HashMap<>();
		params.put("property", "manufacturer");
		return (String) getQAFDriver().executeScript("mobile:handset:info", params);

	}

	/***************************************************************************************
	 * @description	get device model
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getDeviceModel() {

		System.out.println("--- Getting device model ----");
		Map<String, Object> params = new HashMap<>();
		params.put("property", "model");
		return (String) getQAFDriver().executeScript("mobile:handset:info", params);

	}

	/***************************************************************************************
	 * @description	get device OS
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getDeviceOs() {

		System.out.println("--- Getting device OS ----");
		Map<String, Object> params = new HashMap<>();
		params.put("property", "os");
		return (String) getQAFDriver().executeScript("mobile:handset:info", params);

	}


	/***************************************************************************************
	 * @description	get the full device os version; e.g. 8.1.0
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getDeviceOsVersion() {

		System.out.println("--- Getting full device OS version ----");
		Map<String, Object> params = new HashMap<>();
		params.put("property", "osVersion");
		return (String) getQAFDriver().executeScript("mobile:handset:info", params);

	}


	/***************************************************************************************
	 * @description	get the main os version; e.g. for os version 8.1.0 will return 8
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getRelativeDeviceOsVersion() {

		System.out.println("--- Getting relative device OS version ----");
		Map<String, Object> params = new HashMap<>();
		params.put("property", "osVersion");
		String fullDeviceVersion =  (String) getQAFDriver().executeScript("mobile:handset:info", params);
		return fullDeviceVersion.indexOf(".")==-1?fullDeviceVersion:fullDeviceVersion.substring(0,fullDeviceVersion.indexOf("."));

	}


	/***************************************************************************************
	 * @description	get device resolution width
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getDeviceResolutionWidth() {

		Map<String, Object> params = new HashMap<>();
		params.put("property", "resolutionWidth");
		String result = (String) getQAFDriver().executeScript("mobile:handset:info", params);
		System.out.println("mobile:handset:info---resolutionWidth---" + result);
		return result;

	}


	/***************************************************************************************
	 * @description	get device resolution height
	 * @param 
	 * @return
	 **************************************************************************************/
	public static String getDeviceResolutionHeight() {

		Map<String, Object> params = new HashMap<>();
		params.put("property", "resolutionHeight");
		String result = (String) getQAFDriver().executeScript("mobile:handset:info", params);
		System.out.println("mobile:handset:info---resolutionHeight---" + result);
		return result;

	}


	/***************************************************************************************
	 * @description	every 5 minutes (300seconds) get the phone number so that the session stays active
	 * @param: seconds 
	 * @return
	 **************************************************************************************/
	public static void waitForSeconds(long seconds) {

		ReportUtils.logStepStart("Waiting for "+seconds+ " seconds");
		System.out.println("----- Waiting for "+seconds+ " seconds ------");
		if (seconds <= 0)
			return;

		Map<String, Object> params = new HashMap<>();
		params.put("property", "phoneNumber");

		int timeFrames = 1;

		if (seconds > 300) {
			timeFrames = (int) Math.ceil((double) seconds / 300);
			System.out.println("frame=" + timeFrames);
		}

		for (int i = 0; i < timeFrames; i++) {

			if (i + 1 == timeFrames) {
				if (seconds % 300 == 0) {
					// System.out.println("sleep last 300="+300);
					try {
						Thread.sleep(300 * 1000);
						System.out.println("----- Keep device session active for current device -----");
						getQAFDriver().executeScript("mobile:handset:info", params);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					// System.out.println("sleep only remaining="+seconds%300);
					try {
						Thread.sleep((seconds % 300) * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				// System.out.println("sleep another 300="+300);
				try {
					Thread.sleep(300 * 1000);
					System.out.println("----- Keep device session active for current device -----");
					getQAFDriver().executeScript("mobile:handset:info", params);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}


	/***************************************************************************************
	 * @description	every 5 minutes (300seconds) get the phone number so that the session stays active
	 * @param: device1, device2 and seconds 
	 * @return
	 **************************************************************************************/
	public static void waitForSeconds(String device1, String device2, long seconds) {

		ReportUtils.logStepStart("Waiting for "+seconds+ " seconds");
		System.out.println("----- Waiting for "+seconds+ " seconds ------");
		int timeFrames = 1;

		if (seconds > 180) {
			timeFrames = (int) Math.ceil((double) seconds / 180);
			// stem.out.println("frame="+timeFrames);
		}

		for (int i = 0; i < timeFrames; i++) {

			if (i + 1 == timeFrames) {
				if (seconds % 180 == 0) {
					// System.out.println("sleep last 180="+180);
					try {
						Thread.sleep(300 * 1000);
						System.out.println("----- Keep device session active for all device1 and device2 -----");
						switchToDriver(device1);
						getDevicePhoneNumber();
						switchToDriver(device2);
						getDevicePhoneNumber();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					// System.out.println("sleep only remaining="+seconds%300);
					try {
						Thread.sleep((seconds % 180) * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				// System.out.println("sleep another 180="+180);
				try {
					Thread.sleep(180 * 1000);
					System.out.println("----- Keep device session active for all device1 and device2 -----");
					switchToDriver(device1);
					getDevicePhoneNumber();
					switchToDriver(device2);
					getDevicePhoneNumber();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/***************************************************************************************
	 * @description	every 5 minutes (300seconds) get the phone number so that the session stays active
	 * @param: device1, device2, device3 and seconds 
	 * @return
	 **************************************************************************************/
	public static void waitForSeconds(String device1, String device2, String device3, long seconds) {

		ReportUtils.logStepStart("Waiting for "+seconds+ " seconds");
		System.out.println("----- Waiting for "+seconds+ " seconds ------");
		int timeFrames = 1;

		if (seconds > 180) {
			timeFrames = (int) Math.ceil((double) seconds / 180);
			// stem.out.println("frame="+timeFrames);
		}

		for (int i = 0; i < timeFrames; i++) {

			if (i + 1 == timeFrames) {
				if (seconds % 180 == 0) {
					// System.out.println("sleep last 180="+180);
					try {
						Thread.sleep(300 * 1000);
						System.out.println("----- Keep device session active for all device1 and device2 -----");
						switchToDriver(device1);
						getDevicePhoneNumber();
						switchToDriver(device2);
						getDevicePhoneNumber();
						switchToDriver(device3);
						getDevicePhoneNumber();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					// System.out.println("sleep only remaining="+seconds%300);
					try {
						Thread.sleep((seconds % 180) * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				// System.out.println("sleep another 180="+180);
				try {
					Thread.sleep(180 * 1000);
					System.out.println("----- Keep device session active for all device1 and device2 -----");
					switchToDriver(device1);
					getDevicePhoneNumber();
					switchToDriver(device2);
					getDevicePhoneNumber();
					switchToDriver(device3);
					getDevicePhoneNumber();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}


	/***************************************************************************************
	 * @description	keep session active on all devices by getting their device OS
	 * @param: 
	 * @return
	 **************************************************************************************/
	public static void keepDeviceSessionActiveOnAllDevices() {

		ReportUtils.logStepStart("Keep device session active for all devices");
		System.out.println("----- Keep device session active for all devices -----");

		String currentDriver = TestBaseProvider.instance().get().getDriverName();;
		if(currentDriver.contains("Driver")) {
			currentDriver = currentDriver.substring(0,currentDriver.lastIndexOf("Driver"));
		}

		for(String drivers:ConfigurationManager.getBundle().getString("driverNameList").split("\\s*,\\s*")) {
			switchToDriver(drivers.trim());
			getDeviceOs();
		}

		switchToDriver(currentDriver);
	}



	/***************************************************************************************
	 * @description set wifi, aeroplane, data and radiomode
	 * @param: 	wifi: enabled | disabled
				data : enabled | disabled
				airplanemode : enabled | disabled
				radioMode : enabled | disabled
	 * @return
	 **************************************************************************************/
	public static String setNetworkSettings(String wifi, String data, String airplanemode, String radioMode) {

		Map<String, Object> params = new HashMap<>();
		params.put("wifi", wifi);
		params.put("data", data);
		params.put("airplanemode", airplanemode);
		params.put("radioMode", radioMode);
		String result = (String) getQAFDriver().executeScript("mobile:network.settings:set", params);
		System.out.println("mobile:network.settings:get---data, wifi, airplanemode, radioMode---" + result);
		return result;
	}


	/***************************************************************************************
	 * @description set wifi mode
	 * @param: wifi: enabled | disabled
	 * @return
	 **************************************************************************************/
	public static String setWifi(String wifiEnabledDisabled) {

		Map<String, Object> params = new HashMap<>();
		params.put("wifi", wifiEnabledDisabled);
		String result = (String) getQAFDriver().executeScript("mobile:network.settings:set", params);
		System.out.println("mobile:network.settings:get---wifi---" + result);
		return result;

	}

	/***************************************************************************************
	 * @description set aeroplane mode
	 * @param: wifi: airplanemode : enabled | disabled
	 * @return
	 **************************************************************************************/
	public static String setAeroplaneMode(String aeroplaneModeEnabledDisabled) {

		Map<String, Object> params = new HashMap<>();
		params.put("airplanemode", aeroplaneModeEnabledDisabled);
		String result = (String) getQAFDriver().executeScript("mobile:network.settings:set", params);
		System.out.println("mobile:network.settings:get---aeroplane---" + result);
		return result;

	}

	/***************************************************************************************
	 * @description set data mode
	 * @param: data: enabled | disabled
	 * @return
	 **************************************************************************************/
	public static String setData(String dataEnabledDisabled) {

		Map<String, Object> params = new HashMap<>();
		params.put("data", dataEnabledDisabled);
		String result = (String) getQAFDriver().executeScript("mobile:network.settings:set", params);
		System.out.println("mobile:network.settings:set---data---" + result);
		return result;
	}


	/***************************************************************************************
	 * @description	Indicates if the requested network is "true" (on) or "false" (off)
	 * @param: https://developers.perfectomobile.com/pages/viewpage.action?pageId=14876783 
	 * @return
	 **************************************************************************************/
	public static String getWiFiStatus() {

		Map<String, Object> params = new HashMap<>();
		//params.put("property", "wifi");
		String getNetworkSettings = (String) getQAFDriver().executeScript("mobile:network.settings:get", params);
		System.out.println("mobile:network.settings:get---" + getNetworkSettings);		

		Map<String, String> myMap  = new HashMap<String, String>();
		String[] pairs = getNetworkSettings.replace("{","").replace("}","").split(",");
		for (int i=0;i<pairs.length;i++) {
			String pair = pairs[i];
			String[] keyValue = pair.trim().split("=");
			myMap.put(keyValue[0], keyValue[1]);
		}
		System.out.println("mobile:network.settings:get---wifi---" + myMap.get("wifi"));
		return myMap.get("wifi");
	}


	/***************************************************************************************
	 * @description	Indicates if the requested network is "true" (on) or "false" (off)
	 * @param: https://developers.perfectomobile.com/pages/viewpage.action?pageId=14876783
	 * @return
	 **************************************************************************************/
	public static String getAirplaneModeStatus() {

		Map<String, Object> params = new HashMap<>();
		//params.put("property", "airplanemode");
		String getNetworkSettings = (String) getQAFDriver().executeScript("mobile:network.settings:get", params);
		System.out.println("mobile:network.settings:get---" + getNetworkSettings);		

		Map<String, String> myMap  = new HashMap<String, String>();
		String[] pairs = getNetworkSettings.replace("{","").replace("}","").split(",");
		for (int i=0;i<pairs.length;i++) {
			String pair = pairs[i];
			String[] keyValue = pair.trim().split("=");
			myMap.put(keyValue[0], keyValue[1]);
		}
		System.out.println("mobile:network.settings:get---wifi---" + myMap.get("airplanemode"));
		return myMap.get("airplanemode");
	}

	/***************************************************************************************
	 * @description	Indicates if the requested network is "true" (on) or "false" (off)
	 * @param: https://developers.perfectomobile.com/pages/viewpage.action?pageId=14876783
	 * @return
	 **************************************************************************************/
	public static String getDataModeStatus() {

		Map<String, Object> params = new HashMap<>();
		//params.put("property", "data");
		String getNetworkSettings = (String) getQAFDriver().executeScript("mobile:network.settings:get", params);
		System.out.println("mobile:network.settings:get---" + getNetworkSettings);		

		Map<String, String> myMap  = new HashMap<String, String>();
		String[] pairs = getNetworkSettings.replace("{","").replace("}","").split(",");
		for (int i=0;i<pairs.length;i++) {
			String pair = pairs[i];
			String[] keyValue = pair.trim().split("=");
			myMap.put(keyValue[0], keyValue[1]);
		}
		System.out.println("mobile:network.settings:get---wifi---" + myMap.get("data"));
		return myMap.get("data");
	}


	/***************************************************************************************
	 * @description	Indicates if the requested network is "true" (on) or "false" (off)
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static String getDataStatus() {

		Map<String, Object> params = new HashMap<>();
		params.put("property", "data ");
		String result = (String) getQAFDriver().executeScript("mobile:network.settings:get", params);
		System.out.println("mobile:network.settings:get---data---" + result);
		return result;

	}


	/***************************************************************************************
	 * @description	scroll down to text
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static boolean scrollDownToText(String text) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", text);
		params.put("scrolling", "scroll");
		params.put("threshold", 99);
		params.put("maxscroll", 20);
		params.put("next", "SWIPE_UP");
		String result = (String) getQAFDriver().executeScript("mobile:checkpoint:text", params);
		System.out.println("mobile:checkpoint:text---scroll down---" + result);
		return result.equals("true");
	}


	/***************************************************************************************
	 * @description	scroll up to text
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static boolean scrollUpToText(String text) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("content", text);
		params.put("scrolling", "scroll");
		params.put("threshold", 99);
		params.put("maxscroll", 10);
		params.put("next", "SWIPE_DOWN");
		String result = (String) getQAFDriver().executeScript("mobile:checkpoint:text", params);
		System.out.println("mobile:checkpoint:text---scroll up---" + result);
		return result.equals("true");
	}


	/***************************************************************************************
	 * @description	scroll down to element
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static boolean scrollDownToElement(QAFExtendedWebElement webElement) {

		int count=1;
		while(true){
			try {
				webElement.isDisplayed();
				return true;
			}
			catch(Exception e) {
				count=count+1;
				Map<String, Object> params = new HashMap<>();
				params.put("start","50%,80%");
				params.put("end","50%,30%");
				params.put("duration","2");
				getQAFDriver().executeScript("mobile:touch:swipe",params);
				if(count==5){
					return false;
				}
			}
		}
	}
	
	/***************************************************************************************
	 * @description	scroll up to element
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static boolean scrollUpToElement(QAFExtendedWebElement webElement) {

		int count=1;
		while(true){
			try {
				webElement.isDisplayed();
				return true;
			}
			catch(Exception e) {
				count=count+1;
				Map<String, Object> params = new HashMap<>();
				params.put("start","50%,40%");
				params.put("end","50%,90%");
				params.put("duration","2");
				getQAFDriver().executeScript("mobile:touch:swipe",params);
				if(count==5){
					return false;
				}
			}
		}
	}


	/***************************************************************************************
	 * @description	tap web element
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static String tapWebElement(QAFExtendedWebElement webElement) {

		// get location and size
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();

		// determine location to click and convert to an appropriate string
		int xToClick = location.getX() + (size.getWidth() / 2);
		int yToClick = location.getY() + (size.getHeight() / 2);
		String clickLocation = xToClick + "," + yToClick;

		Map<String, Object> params = new HashMap<>();
		params.put("location", clickLocation);
		String result = (String) getQAFDriver().executeScript("mobile:touch:tap", params);
		System.out.println("mobile:touch:tap---" + result);
		return result;

	}


	/***************************************************************************************
	 * @description	long tap web element
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static String longTapWebElement(QAFExtendedWebElement webElement, int seconds) {

		// get location and size
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();

		// determine location to click and convert to an appropriate string
		int xToClick = location.getX() + (size.getWidth() / 2);
		int yToClick = location.getY() + (size.getHeight() / 2);
		String clickLocation = xToClick + "," + yToClick;

		Map<String, Object> params = new HashMap<>();
		params.put("location", clickLocation);
		params.put("duration", seconds);
		String result = (String) getQAFDriver().executeScript("mobile:touch:tap", params);
		System.out.println("mobile:touch:tap---long---" + result);
		return result;
	}


	/***************************************************************************************
	 * @description	double tap web element
	 * @param: data
	 * @return
	 **************************************************************************************/
	public static String doubleTapWebElement(QAFExtendedWebElement webElement) {

		// get location and size
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();

		// determine location to click and convert to an appropriate string
		int xToClick = location.getX() + (size.getWidth() / 2);
		int yToClick = location.getY() + (size.getHeight() / 2);
		String clickLocation = xToClick + "," + yToClick;

		Map<String, Object> params = new HashMap<>();
		params.put("location", clickLocation);
		params.put("operation", "double");
		String result = (String) getQAFDriver().executeScript("mobile:touch:tap", params);
		System.out.println("mobile:touch:tap---double---" + result);
		return result;

	}
	
	
	/***************************************************************************************
	 * @description	inject audio
	 * @param "https://help.perfecto.io/perfecto-help/content/perfecto/automation-testing/inject_audio__fr_.htm"
	 * @return
	 **************************************************************************************/
	public static String audioInject(String...parameters ) {

		Map<String, Object> params = new HashMap<>();
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
		}
		String result = (String) getQAFDriver().executeScript("mobile:audio:inject",params);
		System.out.println("mobile:audio:inject---" + result);
		return result;
	}
	
	
	/***************************************************************************************
	 * @description	start audio recording
	 * @param "https://help.perfecto.io/perfecto-help/content/perfecto/automation-testing/start_audio_recording__fr_.htm"
	 * @return
	 **************************************************************************************/
	public static String startAudioRecording(String...parameters ) {

		Map<String, Object> params = new HashMap<>();
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
		}
		String result = (String) getQAFDriver().executeScript("mobile:audio.recording:start",params);
		System.out.println("mobile:audio.recording:start---" + result);
		return result;
	}
	
	
	/***************************************************************************************
	 * @description	stop audio recording
	 * @param "https://help.perfecto.io/perfecto-help/content/perfecto/automation-testing/stop_audio_recording__fr_.htm"
	 * @return
	 **************************************************************************************/
	public static String stopAudioRecording(String...parameters ) {

		Map<String, Object> params = new HashMap<>();
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
		}
		String result = (String) getQAFDriver().executeScript("mobile:audio.recording:stop",params);
		System.out.println("mobile:audio.recording:stop---" + result);
		return result;
	}
	
	
	
	/***************************************************************************************
	 * @description	audio validation
	 * @param "https://help.perfecto.io/perfecto-help/content/perfecto/automation-testing/audio_validation__fr_.htm"
	 * @return
	 **************************************************************************************/
	public static String audioValidation(String...parameters ) {

		Map<String, Object> params = new HashMap<>();
		for (String parameter : parameters) {
			String[] arrParameter = parameter.split("=", 2);
			params.put(arrParameter[0], arrParameter[1]);
		}
		String result = (String) getQAFDriver().executeScript("mobile:audio:validation",params);
		System.out.println("mobile:audio:validation---" + result);
		return result;
	}
	
	//BC -07/07/22: Changed to String return type to be able to evaluate any adb commands that return a value
	public static String abdshell(String cmd)
    {
        HashMap<String,String> params = new HashMap<>();
        params.put("command", cmd);
        return (String) getQAFDriver().executeScript("mobile:handset:shell", new Object[]{params});
    }
	
	public static void adbAnswer()
    {
        String cmd = "input keyevent 5"; ////*[@resource-id="com.samsung.android.incallui:id/incomingCallImageWidget"]/android.widget.FrameLayout[1]/android.widget.ImageView[1]
        abdshell(cmd);
    }
	
	public static void adbHangUp()
    {
    	//Check if call is active before attempting to terminate it (can cause black screen issue on subsequent test case)
		HashMap<String,String> params = new HashMap<>();
		String cmd =  "dumpsys telecom";
		String callList = abdshell(cmd).split("mCalls:")[1].split("mCallAudioManager")[0];
		if(callList.contains("state=ACTIVE")){ //There is an active call... go ahead and terminate
			cmd = "input keyevent KEYCODE_ENDCALL";
			abdshell(cmd);
		}else{
			System.out.println("Call is no longer active... skipping termination");
		}
    }
	
	public static boolean isDisplayed(QAFWebElement ele) {
		try {
			return ele.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String makeACallToHandset() {

		HashMap<String, String> params = new HashMap<String, String>();
		
		params.put("to.handset", DeviceUtils.getDeviceProperty("deviceId"));
		String result = (String) getQAFDriver().executeScript("mobile:gateway:call", new Object[] { params });
		System.out.println("mobile:gateway:call---" + result);
		return result;
	}

	public static void restartDevice() {
		Map<String, Object> pars = new HashMap<>();
		getQAFDriver().executeScript("mobile:handset:reboot", pars);
	}

	public static boolean waitForDisplayed(QAFExtendedWebElement e, int seconds){
		WebDriverWait wait = new WebDriverWait( getQAFDriver(), seconds);
		wait.until(ExpectedConditions.visibilityOf(e));
		return e.isDisplayed();
	}
	
	public static boolean waitForText(String text, Integer timeout) throws InterruptedException
	{
		String value = DeviceUtils.isText(text, 0);
		int initialCounter = 0;
		while(!value.equals("true") && initialCounter <= timeout)
		{
			Thread.sleep(1000);
			value = DeviceUtils.isText(text, 0);
			initialCounter++;
		}
		if(value.equals("true"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
