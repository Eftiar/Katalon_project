import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Tap on Rate CityTouch'
Mobile.tap(findTestObject('MoreScreen/I1. RateCityTouch/Rate_Citytouch'), 0)

'Verify Rate Us Popup Open'
Mobile.verifyElementExist(findTestObject('MoreScreen/I1. RateCityTouch/TextBox - Do you want to rate us'), 0)

'Tap on Rate Us On Popup'
Mobile.tap(findTestObject('MoreScreen/I1. RateCityTouch/Rate Citytouch - Rate Us Btn'), 0)

'Verify City Touch Open in Play Store'
Mobile.verifyElementExist(findTestObject('MoreScreen/I1. RateCityTouch/Google Play - CityTouch Logo'), 0)

'Verify City Touch App Showing on Play Store'
Mobile.verifyElementExist(findTestObject('MoreScreen/I1. RateCityTouch/Google Play - Open Btn'), 0)

'Close All Application'
Mobile.closeApplication()

