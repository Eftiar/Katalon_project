import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.java.util.jar.pack.Instruction.Switch as Switch
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Open/Install City Touch Android App'
Mobile.startExistingApplication(GlobalVariable.CityTouchAppID, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.comment('User login app with PIN code')

'User Input 1st PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-01'), '1', 0)

'User Input 2nd PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-02'), '2', 0)

'User Input 3rd PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-03'), '3', 0)

'User Input 4th PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-04'), '4', 0)

'User Input 5th PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-05'), '5', 0)

'User Input 6th PIN'
Mobile.setText(findTestObject('LoginWithPIN/LoginPin-06'), '6', 0)

'Hide Keyboard'
Mobile.hideKeyboard(FailureHandling.CONTINUE_ON_FAILURE)

'User click login button'
Mobile.tap(findTestObject('LoginWithPIN/LoginWithPIN-LoginBTN'), 0)

//Mobile.delay(1)
//
//String ToastXpath = '//android.widget.Toast[1]'
//
//AppiumDriver<?> driver = MobileDriverFactory.getDriver()
//
//'Check for login Error Toast Message'
//def toast = driver.findElementByXPath(ToastXpath)
//
//
//if (toast != null) {
//	
//    String _msg = toast.getText()
//	
//		switch (_msg) {
//			case("We are unable to process your request at this moment, we regret for any inconvenience."):
//		
//				'Login Failed with toast Message'
//				KeywordUtil.markFailedAndStop('ERROR : ' + _msg)
//				
//				break
//			
//			case("Login credentials not matching, please login again"):
//			
//				'Login Failed with toast Message'
//				KeywordUtil.markFailedAndStop('ERROR : ' + _msg)
//				
//				break
//				
//			default:
//				'Login Failed without unspecified toast message'
//				KeywordUtil.markFailedAndStop('ERROR : No Specified Toast message Matched')
//			
//				break
//		}
//		
//}

if (Mobile.verifyElementExist(findTestObject('LoginScreen/LoginScreen - Image Notification'), 30, FailureHandling.OPTIONAL)) {
	'If Image Notification Show Tap on Cross'
	Mobile.tap(findTestObject('/LoginScreen/LoginScreen - Image Notification - Cross'), 0)
}

String Welcome_msg = Mobile.getText(findTestObject('LoginScreen/Welcome Message'), 0)

Mobile.comment('Get Welcome Message after login successfull')

String[] parts = Welcome_msg.split(',')

String part2 = parts[1].trim()

'Verify User logged in Successfully'
Mobile.verifyEqual(part2, GlobalVariable.AccName)
