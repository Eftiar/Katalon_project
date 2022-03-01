import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import org.junit.After as After
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable

//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files\\File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Get Own Account Transfer Amount from Excel Data Sheet'
String DPS_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 8, 5)

Float DPS_Amount_float = Float.parseFloat(DPS_Amount)

'Get value from excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '').trim()

'Verify Account Number'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Account Number'), AccNumber, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Verify Account Number'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Account Name'), AccTitle, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Get Available Balance from device'
String AvailAbleBalance = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Available Balance'), 
    0).replaceAll(',', '').trim()

'Verify Available Balance "From Data Sheet"'
Mobile.verifyEqual(AvailAbleBalance, SavingAccBalance1WithoutComma)

'Verify Type of account'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Type of Account'), TypeOfAccount)

Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Branch'), Branch)

Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Month'), Month)

'Get Amount from device'
String amountD = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Amount Per Installment'), 
    0).replaceAll(',', '').trim()

'Verify Available Balance "From Data Sheet"'
Mobile.verifyEqual(amountD, DPS_Amount)

'Verify Interest Rate'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Interest Rate'), InterestRate)

'Take Screenshot For Maturity Date'
Mobile.takeScreenshot()

'Click Confirm Button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A2. MonthlyDPS/OTP Screen - Submit'), 0)

