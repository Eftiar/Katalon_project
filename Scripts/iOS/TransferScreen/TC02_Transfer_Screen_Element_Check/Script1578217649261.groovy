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

'Verifies the presence of "City Bank Account" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/City Bank Account'), 0)) {
    'Matches the text "City Bank Account".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/City Bank Account'), 'City Bank Account')
}

'Verifies the presence of "Other Bank Account" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/Other Bank Account'), 0)) {
    'Matches the text "Other Bank Account".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/Other Bank Account'), 'Other Bank Account')
}

'Verifies the presence of "Cash by Code" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/Cash by Code'), 0)) {
    'Matches the text "Cash by Code".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/Cash by Code'), 'Cash by Code')
}

'Verifies the presence of "Email Transfer" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/Email Transfer'), 0)) {
    'Matches the text "Email Transfer".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/Email Transfer'), 'Email Transfer')
}

'Verifies the presence of "Transfer to bKash" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/Transfer to bKash'), 0)) {
    'Matches the text "Transfer to bKash".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/Transfer to bKash'), 'Transfer to bKash')
}

'Verifies the presence of "Beneficiary Management" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/Beneficiary Management'), 0)) {
    'Matches the text "Beneficiary Management".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/Beneficiary Management'), 'Benefiiciary Management')
}

'Verifies the presence of "Favorite Transfers" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/Favorite Transfers'), 0)) {
    'Matches the text "Favorite Transfers".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/Favorite Transfers'), 'Favorite Transfers')
}

'Verifies the presence of "Transfer History" on "Transfers" screen.'
if (Mobile.verifyElementExist(findTestObject('Transfers Screen/Transfer History'), 0)) {
    'Matches the text "Transfer History".'
    Mobile.verifyElementText(findTestObject('Transfers Screen/Transfer History'), 'Transfer History')
}

