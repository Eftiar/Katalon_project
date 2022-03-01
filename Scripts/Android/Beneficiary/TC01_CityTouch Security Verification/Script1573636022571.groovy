import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil

import io.appium.java_client.AppiumDriver

'Verify User is on City Touch Security Verification Screen'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Citytouch Security Verification/Citytouch Security Verification - Header'), 
    0)

'Tap on Select Card'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Citytouch Security Verification/Select Card - Popup Button'), 
    0)

'Select Amex Card from Pop Up'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Citytouch Security Verification/1st Credit Card- Btn (Select Debit Card - Popup)'), 
    0)

'User Input PIN Code for the card'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Citytouch Security Verification/Card PIN - Text Box'), 
    PIN, 0)

'User tap Add Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Citytouch Security Verification/Add - Btn'), 
    0)


//Toast message handle
Mobile.delay(1)

String ToastXpath = '//android.widget.Toast[1]'

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

'Check for Beneficiary Toast Message'
def toast = driver.findElementByXPath(ToastXpath)

if (toast != null) {
	
	String _msg = toast.getText()
	'Beneficiary Added Successfully with Toast Message'
	KeywordUtil.markPassed('Toast Message : ' + _msg)
		
}

