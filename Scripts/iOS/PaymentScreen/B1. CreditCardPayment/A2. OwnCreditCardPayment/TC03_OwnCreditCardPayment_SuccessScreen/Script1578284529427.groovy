import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Wait to load Page'
while (Mobile.verifyElementExist(findTestObject('Utls/Page Load - Loading'), 10, FailureHandling.OPTIONAL)) {
	Mobile.delay(5)
}

'Verify User on Success Page'
Mobile.verifyElementExist(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CC Payment - Success Screen - Reference Number Lebel'), 
    0)

'Take screenshot for detail check'
Mobile.takeScreenshot()

'Tap to Return Home Page'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CC Payment - Success Screen- Return To Home'), 
    0)

