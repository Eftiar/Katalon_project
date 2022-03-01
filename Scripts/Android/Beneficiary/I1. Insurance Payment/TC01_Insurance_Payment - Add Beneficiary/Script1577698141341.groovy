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

'User Select Insurance Payment'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Insurance Payment - Popup Btn'), 0)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

'User Verify Add Beneficiary - Header'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Insurant Payment/Add Beneficiary - Insurance - Header'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Insurant Payment/Select Insurance Payment Type'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Insurant Payment/Dropdown value - MetLife'), 
    0)

'User Input Nickname Eftiar'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Insurant Payment/Metlife - Add Beneficiary/Metlife Nickname - Please enter here'), 
    nickName, 0)

'User Input Visa Card Number'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Insurant Payment/Metlife - Add Beneficiary/Metlife Policy Number - Please fill up'), 
    policyNumber, 0)

'Visa Card Luhan algorithm Service check'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Insurant Payment/Metlife - Add Beneficiary/Metlife PolicyHolders Name - Please fill up'), 
    policyholderName, 0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Insurant Payment/Metlife - Add Beneficiary/Metlife(add beni) - Next Button'), 
    0)

'User Tap Next Button to add Beneficiary'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - VisaInstantPayment/Next Button'), 0)

