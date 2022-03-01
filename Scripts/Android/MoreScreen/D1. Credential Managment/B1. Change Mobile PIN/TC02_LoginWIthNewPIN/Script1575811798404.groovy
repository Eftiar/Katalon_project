import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Open/Install City Touch Android App'
Mobile.startExistingApplication('com.thecitybank.citytouch.uat', FailureHandling.CONTINUE_ON_FAILURE)

Mobile.comment('User login app with PIN code')

'User Input 1st PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-01'), '9', 0)

'User Input 2nd PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-02'), '8', 0)

'User Input 3rd PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-03'), '7', 0)

'User Input 4th PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-04'), '6', 0)

'User Input 5th PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-05'), '5', 0)

'User Input 6th PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-06'), '4', 0)

'User click login button'
Mobile.tap(findTestObject('LoginWithPIN/LoginWithPIN-LoginBTN'), 0)

if (Mobile.verifyElementExist(findTestObject('LoginScreen/LoginScreen - Image Notification'), 30, FailureHandling.OPTIONAL)) {
    'If Image Notification Show Tap on Cross'
    Mobile.tap(findTestObject('/LoginScreen/LoginScreen - Image Notification - Cross'), 0)
}

String Welcome_msg = Mobile.getText(findTestObject('LoginScreen/Welcome Message'), 0)

Mobile.comment('Get Welcome Message after login successfull')

String[] parts = Welcome_msg.split(',' //Split welcome message for static part
    )

String part2 = parts[1]

'Verify User logged in Successfully'
Mobile.verifyEqual(part2, GlobalVariable.AccName)

