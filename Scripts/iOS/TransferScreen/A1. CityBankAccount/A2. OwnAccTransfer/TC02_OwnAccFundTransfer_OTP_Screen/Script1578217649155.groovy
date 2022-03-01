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

'Check OTP Page Navigate Successfully'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Own Account Fund Transfer'), 0)

'Get Own Account Transfer Amount from Excel Data Sheet'
String OAT_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 1, 5)

Float OAT_Amount_float = Float.parseFloat(OAT_Amount)

'Verify showing From Account number with Excel Data Saving Account Number 02'
if (Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - From Account Lebel'), 0).TRUE) {
    def frmAcc = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - From Account Number'), 0)

    Pattern pattern = Pattern.compile('(\\d+)' /*Reguler Expression for Digit number from the message*/ )

    Matcher m1 = pattern.matcher(frmAcc)

    String result = ''

    'Capture Only Account Number'
    if (m1.find()) {
        result = m1.group(0)
    }
    
    'Get value from excel'
    def SavingAccNumber2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 1)

    /*Match from account number with excel store data*/
    Mobile.verifyMatch(result, SavingAccNumber2, false)
}

'Verify showing to Account number with Excel Data Saving Account Number 01'
if (Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - To Account Lebel'), 0).TRUE) {
    def toAcc = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - To Account Number'), 0)

    'Get value from excel'
    def SavingAccNumber1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 1)

    /*Match from account number with excel store data*/
    Mobile.verifyMatch(toAcc, SavingAccNumber1, false)
}

'Verify Transfer Amount field section'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Transfer Amount Lebel'), 0)

'Verify Transfer amount is "From Data SHeet"'
Mobile.verifyElementText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - TransferAmount'), OAT_Amount, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Service Charge Amount field Showing'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Service Charge Lebel'), 0)

'Verify Service Charge amount "0"'
Mobile.verifyElementText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Service Charge Amn'), '0.00')

'Verify Vat Field Showing'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - VAT Lebel'), 0)

'Verify Vat amount is "500"'
Mobile.verifyElementText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - VAT Amn'), '0.00')

'Verify Grand Total Field Showing'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Grand Total Lebel'), 0)

String grandTotal = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Grand Total Amn'), 0)

'Verify Grand Total amount is "500"'
Mobile.verifyMatch(grandTotal, OAT_Amount, false, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Remarks Field Showing'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Remarks Lebel'), 0)

'Verify Remarks Text is "QA Test"'
Mobile.verifyElementText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Remarks Text'), 'QA Test')

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
Mobile.setText(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Enter OTP here'), OtpNumber, 0)

'Click Transfer Button'
Mobile.tap(findTestObject('CityBankAccount/OwnAccount/OTP Screen - Transfer Button'), 0)


'Check Transfer Successfull Page Showing'
Mobile.waitForElementPresent(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - Receipt'), 
    60, FailureHandling.CONTINUE_ON_FAILURE)

