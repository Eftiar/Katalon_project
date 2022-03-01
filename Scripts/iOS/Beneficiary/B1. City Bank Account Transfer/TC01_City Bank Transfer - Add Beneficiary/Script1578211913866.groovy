import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.HidesKeyboardWithKeyName as HidesKeyboardWithKeyName
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import io.appium.java_client.remote.HideKeyboardStrategy as HideKeyboardStrategy
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.detroitlabs.katalonmobileutil.testobject.TextField as TextField

'Verify User is on add Beneciary Screen'
Mobile.verifyElementExist(findTestObject('X_iOS/1C. BeneficiaryManagment/1A. Beneficiary/Add Beneficiary - Header Title'), 
    0)

'User Tap Select Transfer Type Dropdown Button'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1A. Beneficiary/Add Beneficiary - SELECT BENEFICIARY TYPE'), 0)

'User select Transfer Within City Bank'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1A. Beneficiary/Add Beneficiary - SELECT BENEFICIARY TYPE - Transfer Within Other CBL Account'), 
    0)

'User Tap Next Button'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1A. Beneficiary/Add Beneficiary - Next Btn'), 0)

'User Verify Add Beneficiary - Within City Bank Screen Showing'
Mobile.verifyElementExist(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank - Header Title'), 
    0)

'User Input Nickname Borhan'
Mobile.setText(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank  - Enter nickname'), 
    Nickname, 0)

'Tap Random to call Account Service'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank  - Enter account number'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

'Input Account Number 2182603667001'
Mobile.setText(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank  - Enter account number'), 
    AccNumber, 0)

'Tap on Account Holder Name to Load Account Info'
Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank - Account Holder Name Lebel'), 
    0)

'Tap Done button on Keyboard'
Mobile.tap(findTestObject('X_iOS/1X. KeyboardActionButton/Kayboard - Done Button'), 0)

Mobile.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.setText(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank  - Enter mobile no here'), 
    MobileNumber, 0)

'Tap Done button on Keyboard'
Mobile.tap(findTestObject('X_iOS/1X. KeyboardActionButton/Kayboard - Done Button'), 0)

Mobile.setText(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank - Enter email address here'), 
    EmailId, 0)

'Tap Done button on Keyboard'
Mobile.tap(findTestObject('X_iOS/1X. KeyboardActionButton/Kayboard - Done Button'), 0)

Mobile.scrollToText('Next', FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank  - Next Btn'), 
    0)

Mobile.tap(findTestObject('X_iOS/1C. BeneficiaryManagment/1B. Add Beneficiary-Within City Bank/Add Beneficiary-Within City Bank - Add Beneficiary'), 
    0)

