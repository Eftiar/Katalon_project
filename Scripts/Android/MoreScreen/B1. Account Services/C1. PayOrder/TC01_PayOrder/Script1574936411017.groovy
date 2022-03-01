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

//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files\\File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Verify Pay Order Header Screen'
Mobile.verifyElementExist(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order -  Header'), 0)

'Tap to Select Account Number From Dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Select Account'), 0)

'Tap to select 1st Card from dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Select Account - 1st Card'), 0)

'Get value from excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '').trim()

'Get Selected account Balance'
def FromAccBalance = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Available Balance'), 
    0).replaceAll(',', '').trim()

'Verify get text with Excel book amount'
Mobile.verifyMatch(FromAccBalance, SavingAccBalance1WithoutComma, false)

'Tap to Select Delivery Location'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Select Delivery Location'), 0)

'Tap to Select 1st Option'
Mobile.tapAtPosition(520, 1177)

'Tap to Select Branch From Dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Select Branch'), 0)

'Tap to select AMBARKHANA'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Select Branch - AMBARKHANA'), 0)

if (Mobile.verifyElementNotExist(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Confirm'), 0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Confirm')
}

'Get Pay Order Amount from Excel Data Sheet'
String PO_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 9, 5)

Float PO_AmountFloat = Float.parseFloat(PO_Amount)

Mobile.setText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Amount Input'), PO_Amount, 0)

Mobile.setText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Beneficiary Name Input'), 'Borhan', 
    0)

'Verify Service Charge amount "100.00"'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Service Chanrge'), '100.00')

String serviceCharge = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Service Chanrge'), 
    0)

Float serviceChargeFloat = Float.parseFloat(serviceCharge)

'Verify Vat amount is "15.00"'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Vat'), '15.00')

String vatAmount = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Vat'), 0)

Float vatAmountFloat = Float.parseFloat(vatAmount)

String grandTotal = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/Pay Order - Grand Total'), 
    0).replaceAll(',', '').trim()

Float grandTotalFloat = Float.parseFloat(grandTotal)

Float grandTotalExpected = PO_AmountFloat + serviceChargeFloat + vatAmountFloat

'Verify Grand Total amount is "1115.00"'
Mobile.verifyEqual(grandTotalFloat, grandTotalExpected)

'OTP Type Selection From Global Variable'
if (GlobalVariable.OTP_Option_Email) {
    Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
} else {
    println('OTP Type : SMS Enable')
}

'Tap to Confirm Button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Confirm Btn'), 0)

