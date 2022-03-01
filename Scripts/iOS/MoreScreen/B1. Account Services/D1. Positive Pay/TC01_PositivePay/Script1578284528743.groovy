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

'Verify Positive Pay Header Screen'
Mobile.verifyElementExist(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Header'), 0)

'Tap to Select Account Number From Dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Select Account'), 0)

'Tap to select 2nd Card from dropdown'
Mobile.tapAtPosition(520, 1190)

'Get value from excel'
String SavingAccBalance2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 2)

SavingAccBalance2WithoutComma = SavingAccBalance2.replaceAll(',', '')

'Get Selected account Balance'
def FromAccBalance = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Available Balance'), 
    0).replaceAll(',', '').trim()

'Verify get text with Excel book amount'
Mobile.verifyMatch(FromAccBalance, SavingAccBalance2WithoutComma, false)

'Tap to Select Cheque Book Number'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Select Cheque Book Number'), 0)

'Tap to Select 1st Checque Book Number From dropdown'
//Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Select Cheque Book Number - 1st Option'), 
//    0)
Mobile.tapAtPosition(520, 1178)

'Tap to select unsed Cheque leaf number'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Select Unused Cheque Leaf Number'), 
    0)

'Tap to select unused cheque leaf number from dropdown'
Mobile.tapAtPosition(520, 1177)

'Tap to select data\r\n'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Select Cheque Date'), 0)

'Tap to Date 30 from Calender'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Cheque Date - 30'), 0)

'Tap to OK On Date'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Cheque Date - OK'), 0)

if (Mobile.verifyElementNotExist(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Confirm'), 
    0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Confirm')
}

'Get Fixed Deposit Amount from Excel Data Sheet'
String PositivePay_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 10, 5)

'Input Value of Amount to Positive Pay'
Mobile.setText(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Input Amount'), PositivePay_Amount, 
    0, FailureHandling.CONTINUE_ON_FAILURE)

'Input Value of Beneficiary Name'
Mobile.setText(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Beneficiary Name Input'), beneficiaryName, 
    0)

'Tap to Confirm Button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Confirm'), 0)

Mobile.delay(2)

'Tap to Submit Button 2nd Screen'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Positive Pay - Second Screen - Submit'), 0)

