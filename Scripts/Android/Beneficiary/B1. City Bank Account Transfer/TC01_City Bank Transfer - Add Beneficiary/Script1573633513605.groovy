import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
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

'Verify User is on add Beneciary Screen'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary Title - Header'), 0)

'User Tap Select Transfer Type Dropdown Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Select Transfer Type - Popup Btn'), 0)

'User Check Select Beneficiary Type Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Select Beneficiary Type - Popup Lebel'), 
    0)

'User select Transfer Within City Bank'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Transfer Within City Bank - Popup Btn'), 0)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

'User Verify Add Beneficiary - Within City Bank Screen Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Within City Bank Header'), 
    0)

'User Input Nickname Borhan'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Nickname Input'), 
    Nickname, 0)

'Tap Random to call Account Service'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Account Number Input'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

'Input Account Number 2182603667001'
Mobile.sendKeys(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Account Number Input'), 
    AccNumber)

Mobile.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//'Tap Enter on Keyboard'
//Mobile.tapAtPosition(969, 2094)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Account Holder Name Lebel'), 
    0)

'Verify Account holder name'
Mobile.verifyElementText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Acc Holder Name'), 
    AccHolderName)

'Verify Currency type "BDT"'
Mobile.verifyElementText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Currency Type'), 
    Currency_type)

'Verify Type of Account "SAVING BANK A/C"'
Mobile.verifyElementText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Account Type'), 
    AccType)

'User Input Mobile Number "01745677420"'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Mobile Number Input'), 
    MobileNumber, 0)

'User Input email address "borhan@bs-23.net"'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Beneficiary Email Address Input'), 
    EmailId, 0)

'User Tap Next Button to add Beneficiary'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Next'), 
    0)

'User Tap Next Button to add Beneficiary'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/Add Beneficiary(WithinCityBank) - Next'), 
    0)

