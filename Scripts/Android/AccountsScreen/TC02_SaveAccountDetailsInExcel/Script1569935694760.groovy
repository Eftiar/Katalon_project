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
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable as GlobalVariable

// Excel Data Write
String excelFile = 'Data Files\\File.xlsx'

String sheetName = 'Account_Info'

workbook = ExcelKeywords.getWorkbook(excelFile)

sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

//Account Name Saving into Excel
String SavingAccName = Mobile.getText(findTestObject('AccountsScreen/Savings_Account_Name_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 1, 0, SavingAccName)

//Account Number Saving into Excel
def SavingAccNumber = Mobile.getText(findTestObject('AccountsScreen/Savings_Account_Number_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 1, 1, SavingAccNumber)

//Account Balance Saving into Excel
def SavingAccBalance = Mobile.getText(findTestObject('AccountsScreen/Saving_Account_Available_Balance_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 1, 2, SavingAccBalance)

//Credit Card 01 Info Saving into Excel
String CreditCardName = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Name_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 2, 0, CreditCardName)

//Credit Card 01 Info Saving into Excel
def CreditCardNumber = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Number_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 2, 1, CreditCardNumber)

//Credit Card 01 Info Saving into Excel
def CreditCardBalance = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Available_Balance_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 2, 2, CreditCardBalance)

//Credit Card 02 Info Saving into Excel
String CreditCardName2 = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Name_02'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 3, 0, CreditCardName2)

//Credit Card 01 Info Saving into Excel
def CreditCardNumber2 = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Number_02'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 3, 1, CreditCardNumber2)

//Credit Card 01 Info Saving into Excel
def CreditCardBalance2 = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Available_Balance_02'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 3, 2, CreditCardBalance2)

ExcelKeywords.saveWorkbook(excelFile, workbook)

def msg = ExcelKeywords.getCellValueByIndex(sheet01, 3, 2)

Mobile.verifyMatch(CreditCardBalance2, msg, false)