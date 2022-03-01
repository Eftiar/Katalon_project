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

'Verify Monthly DPS Header Screen'
Mobile.verifyElementExist(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Header'), 0)

'Tap to Select Account Number From Dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Account Number'), 0)

'Tap to select 1st Card from dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Account Number - 1st Card'), 
    0)

'Verify Account title Name "MD. MAZADUL ISLAM"'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Account Name'), accountTitle)

'Get value from excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '')

'Get Selected account Balance'
def FromAccBalance = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Available Balance'), 
    0).replaceAll(',', '').trim()

'Verify get text with Excel book amount'
Mobile.verifyMatch(FromAccBalance, SavingAccBalance1WithoutComma, false)

'Tap to select type of account'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Account Type'), 0)

'Tap to Select DPS High value'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Type of Account - DPS high value'), 
    0)

'Tap to select Branch from Dropdown'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Branch'), 0)

'Tap to select Branch Name AMBARKHANA'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Branch - AMBARKHANA'), 0)

'Tap to select Start Date'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Installment Start Date'), 
    0)

'Tap to Date 30 from Calender'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Installment Start Date - 30'), 
    0)

'Tap to OK On Date'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Installment Start Date - Caender - OK'), 
    0)

if (Mobile.verifyElementNotExist(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Confirm'),
	0, FailureHandling.OPTIONAL)) {
	'For Small Length Device'
	Mobile.scrollToText('Confirm')
}

'Tap to Select Month'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Month'), 0)

'Tap to Select Month 36'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Select Month - 36'), 0)

'Get Fixed Deposit Amount from Excel Data Sheet'
String DPS_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 8, 5)

'Tap on Input Value of Amount to Installment'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Amount Per Installment Input'), 0)

Mobile.sendKeys(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/Monthly DPS - Amount Per Installment Input'), 
    DPS_Amount)

Mobile.delay(2)

'Tap Enter on Keyboard'
Mobile.tapAtPosition(969, 2094)

Mobile.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

'Hide Keyboard'
Mobile.hideKeyboard()

'Tap to Confirm Button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/Fixed Deposit - Confirm Btn'), 0)

