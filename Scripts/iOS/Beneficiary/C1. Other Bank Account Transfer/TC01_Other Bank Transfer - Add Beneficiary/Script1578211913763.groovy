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

'User select Transfer Other Bank'
Mobile.tap(findTestObject('/Beneficiary Management/Add Beneficiary/Transfer Other Bank - Popup Btn'), 0)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

'User Verify Add Beneficiary - Other Bank Screen Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Add Beneficiary - Other Bank - Header'), 
    0)

'User Input Nickname Borhan'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Add Beneficiary(OtherBank) - Nickname Input'), 
    Nickname, 0)

'User tap on select account type dropdown'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select Account Type - Popup Btn'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

'User Selec Account from select account type'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select Account Type - Account'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

'Input Account Number 2182603667001'
Mobile.sendKeys(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Add Beneficiary - Other Bank - Acc Number'), 
    AccNumber)

'Input Account Name '
Mobile.sendKeys(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Add Beneficiary - Other Bank - Account Name - Input'), 
    AccName)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select Bank Name - Popup Btn'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select Bank Name/CITI BANK N A - Btn (Select Bank Name - Popup)'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select District Name - Popup Btn'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select District Name/Select District Name - City Bank N A - DHAKA-NORTH'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select Branch Name - Popup Btn'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Select Branch Name/Select Branch Name - City Bank N A - DHANMONDI'), 
    0)

Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Beneficiary Mobile Number - Input'), 
    MobileNumber, 0)

Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Beneficiary Email Address - Input'), 
    EmailId, 0)

if (Mobile.verifyElementNotExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Next - Btn'), 
    0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Back')
}

'Verify Notes Section Present'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Notes Lebel'), 
    0)

'User tap on NEXT button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Next - Btn'), 0)

'User tap on NEXT button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Next - Btn'), 0)

