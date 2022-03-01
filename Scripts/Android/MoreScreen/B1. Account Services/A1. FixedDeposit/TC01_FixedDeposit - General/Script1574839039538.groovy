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

'Verify Fixed Deposit Header Screen'
Mobile.verifyElementExist(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Header'), 0)

'Tap to Select Account Number From Dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Select Account Number'), 0)

'Tap to select 1st Card from dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Select Account Number - 1st Card'), 
    0)

'Verify Account title Name "MD. MAZADUL ISLAM"'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Account Title'), 
    accountTitle)

'Get value from excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '')

'Get Selected account Balance'
def FromAccBalance = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Available Balance'), 
    0).replaceAll(',', '').trim()

'Verify get text with Excel book amount'
Mobile.verifyMatch(FromAccBalance, SavingAccBalance1WithoutComma, false)

'Tap to select type of account'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Type of Account - Select Account Type'), 
    0)

'Tap to Select Fixed Deposit General'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Type of Account - Select Account Type - Fixed Deposit - General'), 
    0)

'Tap to select tenure type'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Select Tenure Type'), 0)

'Tap to select tenure type - month from dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Select Tenure Type - Months'), 
    0)

'Tap to select tenure(Period)'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Tenure(Period) - Select Tenure(Period)'), 
    0)

'Tap to select tenure period 12'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Tenure(Period) - 12'), 0)

'If Principal Only Selected Credit Interest To Field Showing'
Mobile.verifyElementExist(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Credit Interest To Lebel'), 
    0)

'Select Renew Type - Both Principal & Interest'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Renew Type - Both Principal  Interest'), 
    0)

'If Both Principal & Interest Selected Credit Interest To Field Should Not Showing'
Mobile.verifyElementNotExist(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Credit Interest To Lebel'), 
    0)

'Tap to select Auto Renewal No'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Auto Renewal Type - No'), 0)

'Get Fixed Deposit Amount from Excel Data Sheet'
String FD_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 7, 5)

Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Amount Input'), 0)

Mobile.sendKeys(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Amount Input'), FD_Amount, 
    FailureHandling.CONTINUE_ON_FAILURE)

Mobile.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

'Tap Enter On Mobile Keyboard'
Mobile.tapAtPosition(969, 2094)

'Tap to select branch'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Select Branch'), 0)

'Select AMBARKHANA Branch From Dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Select Branch - AMBARKHANA'), 
    0)

if (Mobile.verifyElementNotExist(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Confirm Btn'), 
    0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Confirm')
}

'OTP Type Selection From Global Variable'
if (GlobalVariable.OTP_Option_Email) {
    Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
} else {
    println('OTP Type : SMS Enable')
}

'Tap to Confirm Button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Confirm Btn'), 0)

