import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
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

'Verify CC Amount field section'
Mobile.verifyElementText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/OTP Screen - CC Holder Name'), 
    HolderName)

'Verify Pay From Account'
Mobile.verifyElementText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/OTP Screen - CC Pay From'), 
    PayFrom, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Payment Amount'
Mobile.verifyElementText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/OTP Screen - CC Payment Amount'), 
    PaymentAmount)

'Get grand Total from excel sheet'
String grandTotal = ExcelKeywords.getCellValueByIndex(sheet01, 11, 5)

'Get Actual Amount showing on Device'
String actualGrandTotal = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/OTP Screen - Grand Total'), 0).replaceAll('[a-zA-Z]+', '').trim()

'Verify Grand Total Amount'
Mobile.verifyEqual(actualGrandTotal, grandTotal)


if (GlobalVariable.OTP_Option_Email) {
    'Save/Store OTP Number from gmail app to Excel Data Sheet'
    Mobile.callTestCase(findTestCase('Android/Utls/TC04_OTPReadFromEmail'), [:], FailureHandling.CONTINUE_ON_FAILURE)
} else {
    'Save/Store OTP Number from message app to Excel Data Sheet'
    Mobile.callTestCase(findTestCase('Android/Utls/TC03_OTPReadFromMessageApp'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

'Start City Touch App Again'
Mobile.startExistingApplication(GlobalVariable.CityTouchAppID)

//Excel Data Read Intiliaze
String excelFileOTP = 'Data Files\\File.xlsx'

String sheetNameOtp = 'OTP'

workbookOTP = ExcelKeywords.getWorkbook(excelFileOTP)

OTP = ExcelKeywords.getExcelSheet(workbookOTP, sheetNameOtp)

String OtpNumber = ExcelKeywords.getCellValueByIndex(OTP, 1, 0)

'Enter OTP Number From Excel OTP Sheet'
Mobile.setText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/OTP Screen - Enter OTP here'), OtpNumber, 
    0)

'Click Transfer Button'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/OTP Screen - Payment Btn'), 0)

