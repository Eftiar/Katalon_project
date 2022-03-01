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

'Verify User is on add Beneciary Screen'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary Title - Header'), 0)

'User Tap Select Transfer Type Dropdown Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Select Transfer Type - Popup Btn'), 0)

'User Check Select Beneficiary Type Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Select Beneficiary Type - Popup Lebel'), 0)

'User Select Visa Instant Payment'
Mobile.tapAtPosition(GlobalVariable.VisaInstantPayment_X, GlobalVariable.VisaInstantPayment_Y)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

'User Verify Add Beneficiary - Header'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Add Beneficiary - VISA Card - Hader'), 
    0)

'User Input Nickname Eftiar'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Add Beneficiary(Visa Instant) - Input Nickname'), 
    nickName, 0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Add Beneficiary(Visa Instant) - Input Visa Card Number'), 
    0)

'User Input Visa Card Number'
Mobile.sendKeys(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Add Beneficiary(Visa Instant) - Input Visa Card Number'), 
    visaCardNumber, FailureHandling.CONTINUE_ON_FAILURE)

'Visa Card Luhan algorithm Service check'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Recipient Name'), 0)

Mobile.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

'User Input Recipient Name S M Eftiar Hossain'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Add Beneficiary(Visa Instant) - Input Receipient Name'), 
    recipientName, 0)

'User Input MOBILE NUMBER\r\n'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Add Beneficiary(Visa Instant) - Input Mobile Number'), 
    mobileNumber, 0)

'User Input email address'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Add Beneficiary(Visa Instant) - Input Email Address'), 
    emailAddress, 0)

'User Tap Next Button to add Beneficiary'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Next Button'), 0)

'User Tap Next Button to add Beneficiary'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/VisaInstant(AddBeneficiary) - Next'), 
    0)

