import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import io.appium.java_client.AppiumDriver as AppiumDriver

'Verify User is on City Touch Security Verification Screen'
Mobile.verifyElementExist(findTestObject('X_iOS/1C. BeneficiaryManagment/1X. CardVerificationScreem/Card Verification Screen - Header Title'), 
    0)

'Tap on Select Card'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1X. CardVerificationScreem/Card Verification Screen - SELECT CARD'), 
    0)

'Select Amex Card from Pop Up'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1X. CardVerificationScreem/Card Verification Screen - Select Card - AMEX'), 
    0)

'User Input PIN Code for the card'
Mobile.setText(findTestObject('X_iOS/1C. BeneficiaryManagment/1X. CardVerificationScreem/Card Verification Screen - Type PIN number'), 
    PIN, 0)

'User tap Add Button'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1X. CardVerificationScreem/Card Verification Screen - Add'), 0)

//Toast message handle
Mobile.delay(50)

