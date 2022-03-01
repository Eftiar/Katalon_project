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
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable

Mobile.comment('User check Saving Account')

'User verify saving account type name \'General Savings Staff A/C\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Savings_Account_Name_01'), findTestData('TestExcle').getValue(1, 
        1))

'User verify Saving account number \'2251439350001\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Savings_Account_Number_01'), findTestData('TestExcle').getValue(
        2, 1))

'User Verify Available Balance \'315,285.32\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Saving_Account_Available_Balance_01'), findTestData('TestExcle').getValue(
        3, 1))

Mobile.comment('User check Credit Card 1')

'User verify Credit Card type name \'AMEX AGORA\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Credit_Card_Name_01'), findTestData('TestExcle').getValue(1, 2))

'User verify Credit Account account number \'376948*****5460\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Credit_Card_Number_01'), findTestData('TestExcle').getValue(2, 2))

'User Verify Available Balance \'-4,498.00\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Credit_Card_Available_Balance_01'), findTestData('TestExcle').getValue(
        3, 2))

Mobile.comment('User check Credit Card 2')

'User verify Credit Card type name \'AMEX\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Credit_Card_Name_02'), findTestData('TestExcle').getValue(1, 3))

'User verify Credit account number \'376948*****3353\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Credit_Card_Number_02'), findTestData('TestExcle').getValue(2, 3))

' User Verify Available Balance \'-53.60\''
Mobile.verifyElementText(findTestObject('AccountsScreen/Credit_Card_Available_Balance_02'), findTestData('TestExcle').getValue(
        3, 3))


