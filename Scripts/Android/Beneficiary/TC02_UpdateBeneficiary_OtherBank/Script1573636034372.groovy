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

'Calling login test case for login.'
WebUI.callTestCase(findTestCase('Android/LoginScreen/TC02_LoginWIthPIN'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Calling Navigate to transfer screen test case for redirecting to the Transfer Screen.'
WebUI.callTestCase(findTestCase('Android/TransferScreen/TC01_Navigate_Transfer_Screen'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Calling tesat case for navigating to the Other Bank account.'
WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Searching for "Select Nickname" popup button.'
Mobile.scrollToText('Select Nickname', FailureHandling.CONTINUE_ON_FAILURE)

'User tap on the "Select Nickname" button for opening the popup window.'
Mobile.tap(findTestObject('OtherBankAccount/Select Nickname - Popup'), 0)

'User click on the "BBL CC Payment" button from the "Select Nickname" popup window.'
Mobile.tap(findTestObject('OtherBankAccount/Nickname - BBL CC Payment'), 0)

'Verifying the existence of the "Update Beneficiary" popup window.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Popup Lebel'), 0)

'Verifying the existence of the "No" button on the "Update Beneficiary" popup window.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/No - Btn (Beneficiary Popup)'), 0)

'Verifying the existence of the "Yes" button on the "Update Beneficiary" popup window.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Yes - Btn (Beneficiary Popup)'), 0)

'User tap on the "No" button on the "Update Beneficiary" popup window.'
Mobile.tap(findTestObject('OtherBankAccount/No - Btn (Beneficiary Popup)'), 0)

'Verifying the none existence of the "No" button on the "Update Beneficiary" popup window.'
Mobile.verifyElementNotExist(findTestObject('OtherBankAccount/No - Btn (Beneficiary Popup)'), 0)

'User tap on the "Select Nickname" button for opening the popup window.'
Mobile.tap(findTestObject('OtherBankAccount/Select Nickname - Popup'), 0)

'User click on the "BBL CC Payment" button from the "Select Nickname" popup window.'
Mobile.tap(findTestObject('OtherBankAccount/Nickname - BBL CC Payment'), 0)

'User tap on the "Yes" button on the "Update Beneficiary" popup window.'
Mobile.tap(findTestObject('OtherBankAccount/Yes - Btn (Beneficiary Popup)'), 0)

'Verifying the existance of the "Auto Filled Up" popup window.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Auto Filled Up - Popup Lebel'), 0)

'User tap on the "Ok" button of the "Auto Filled Up" popup window.'
Mobile.tap(findTestObject('OtherBankAccount/OK - Btn (Auto Filled Up-Popup)'), 0)

'Verfying the existence of the "Nickname" lebel. '
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Nickname - Lebel'), 0)

'Matching the velue of "Nickname".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/Nickname - Text'), Nickname)

'Verifying the existence of "Account Type" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Account Type - Lebel'), 0)

Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/Account Type - Value'), AccountType)

'Verifying existance of the "Account/Card Number" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/AccountCard Number - Lebel'), 0)

'Matching the Account/Card number.'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/AccountCard Number - Value'), AccountCardNumber)

'Verifying the existance of the "Account/ Card Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/AccountCard Name - Value'), 0)

'Matching the value of "Account/ Card Name".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/AccountCard Name - Value'), AccountCardName)

'Verifying the exxistance of "Bank Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Bank Name - Lebel'), 0)

'Matching the value of "Bank Name".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/Bank Name - Value'), BankName)

'Verifying the existance of "District Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/District Name - Lebel'), 0)

'Matching the value of "District Name".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/District Name - Value'), DistrictName)

'Verifying the existance of "Branch Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Branch Name - Lebel'), 0)

'Matching the value of "Branch Name"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/Branch Name - Value'), BranchName)

Mobile.scrollToText('Beneficiary Mobile Number', FailureHandling.CONTINUE_ON_FAILURE)

'Verifying the existance of "Beneficiary Mobile Number" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Beneficiary Mobile Number(optional) - Lebel'), 
    0)

'Matching the value of "Beneficiary Mobile Number".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/Beneficiary Mobile Number(optional) - Value'), 
    BeneficiaryMobileNumber)

Mobile.scrollToText('Beneficiary Email Address', FailureHandling.CONTINUE_ON_FAILURE)

'Verifying the existance of "Beneficiary Email Address" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Beneficiary Email Address(optional) - Lebel'), 
    0)

'Matching the value of "Beneficiary Email Address".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary/Beneficiary Email Address(optional) - Value'), 
    BeneficiaryEmailAddress)

Mobile.scrollToText('Notes', FailureHandling.CONTINUE_ON_FAILURE)

'Verifying the existance of "Notes" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Notes - Lebel'), 0)

'Verifying the existance of "Notes" data.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Notes - Text'), 0)

Mobile.scrollToText('Back', FailureHandling.CONTINUE_ON_FAILURE)

'Verifying the existance of "Next"button.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary/Next - Btn'), 0)

'User tap on the "Next" button.'
Mobile.tap(findTestObject('OtherBankAccount/Update Beneficiary/Next - Btn'), 0)

'Verifying the exstence of "Nickname" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Nickname - Lebel'), 0)

'Matching the value of "Nickname".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Nickname - Value'), Nickname)

'Verifying the exstance of "Account Type" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Account Type - Lebel'), 0)

'Matching the value of "Account Type".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Account Type - Value'), AccountType)

'Verifying the existance of "Account/ Card Number" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/AccountCard Number - Lebel'), 
    0)

'Matching the value of "Account/ Card Number".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/AccountCard Number - Value'), 
    AccountCardNumber)

'Verifying the existance of "Account/ Card Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/AccountCard Name - Lebel'), 
    0)

'Matching the value of "Account/ Card Name".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/AccountCard Name - Value'), 
    AccountCardName)

'Verifying the existance of "Bank Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Bank Name - Lebel'), 0)

'Matching the value of "Bank Name" value.'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Bank Name - Value'), BankName)

'Verfying the existance of "District Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/District Name - Lebel'), 0)

'Matching the value of "District Name" value.'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/District Name - Value'), DistrictName)

'Verifying the existance of "Branch Name" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Branch Name - Lebel'), 0)

'Matching the value of "Branch Name".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Branch Name - Value'), BranchName)

'Verifying the existance of "Beneficiary Mobile Number" lebel.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Beneficiary Mobile Number - Lebel'), 
    0)

'Matching the value of "Beneficiary Mobile Number".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Beneficiary Mobile Number - Value'), 
    BeneficiaryMobileNumber)

'Verifying the existance of "Beneficiary Email Address".'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Beneficiary Email Address - Lebel'), 
    0)

'Matching the value of "Beneficiary Email Address".'
Mobile.verifyElementText(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Beneficiary Email Address - Value'), 
    BeneficiaryEmailAddress)

'Verifying the existance of "Back" button.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Back - Btn'), 0)

'Verifying the existance of "Next" button.'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Next - Btn'), 0)

'User tap on the "Next" button'
Mobile.tap(findTestObject('OtherBankAccount/Update Beneficiary - Confirmation/Next - Btn'), 0)

