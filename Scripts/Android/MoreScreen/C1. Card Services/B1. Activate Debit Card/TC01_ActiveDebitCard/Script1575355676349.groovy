import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable
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

'Verify Debit Card Activation Screen'
Mobile.verifyElementExist(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Header'), 
    0)

'Tap to Select Card Number From Dropdown'
Mobile.tap(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Select Card Number'), 
    0)

'Tap to select 1st Card from dropdown'
Mobile.tapAtPosition(520, 1178)

'Verify Debit Card Holder Name'
Mobile.verifyElementText(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Card Holder Name'), 
    cardHolder)

'Verify Debit Card Status'
Mobile.verifyElementText(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Card Status'), 
    cardStatus)

'Verify Debit Card State'
Mobile.verifyElementText(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Card State'), 
    cardState)

'Verify Debit Card Type'
Mobile.verifyElementText(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Card Type'), 
    cardType)

Mobile.tap(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Select Expire Date'), 
    0)

Mobile.tap(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Select Expire Date - Done'), 
    0)

if (Mobile.verifyElementNotExist(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Next'), 
    0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Next')
}

'OTP Type Selection From Global Variable'
if (GlobalVariable.OTP_Option_Email) {
    Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
} else {
    println('OTP Type : SMS Enable')
}

'Tap to next button'
Mobile.tap(findTestObject('MoreScreen/C1. Card Services/B1. ActivateDebitCard/Debit Card Activation - Next'), 0)

