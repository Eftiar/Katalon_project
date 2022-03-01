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
Mobile.verifyElementExist(findTestObject('EmailTransfer/OTP Screen - Confirm Email Transfer - Header'), 0)

'Get Own Account Transfer Amount from Excel Data Sheet'
String ET_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 5, 5)

Float ET_Amount_float = Float.parseFloat(ET_Amount)

String SavingAccount2Balance = ExcelKeywords.getCellValueByIndex(sheet01, 2, 2)
String Curenncy = 'BDT'

'Verify showing From Account number with Excel Data Saving Account Number 02'
if (Mobile.verifyElementExist(findTestObject('EmailTransfer/OTP Screen - Available Balance Lebel'), 0).TRUE) {
    def ETAmn = Mobile.getText(findTestObject('EmailTransfer/OTP Screen - Payment Amount'), 0, FailureHandling.CONTINUE_ON_FAILURE)

    Pattern pattern = Pattern.compile('(\\d+)' /*Reguler Expression for Digit number from the message*/ )

    Matcher m1 = pattern.matcher(ETAmn)

    Matcher m2 = pattern.matcher(ET_Amount)

    String Accresult = ''

    'Capture Only Account Number'
    if (m1.find()) {
        result = m1.group(0)
    }
    
    String Expresult = ''

    'Capture Only Account Number'
    if (m2.find()) {
        result = m2.group(0)
    }
    
    /*Match from account number with excel store data*/
    Mobile.verifyMatch(Accresult, Expresult, false)
}

Mobile.verifyElementText(findTestObject('EmailTransfer/OTP Screen - Beneficiary Name'), 'Borhan QA')

Mobile.verifyElementText(findTestObject('EmailTransfer/OTP Screen - Beneficiary Mobile Number'), '01745677520')

Mobile.verifyElementText(findTestObject('EmailTransfer/OTP Screen - From Account Number'), '2801815151001')

String ExcelSave2BalancewithCurrency = SavingAccount2Balance + " " + Curenncy + " "

Mobile.verifyElementText(findTestObject('EmailTransfer/OTP Screen - Available Balance Amount'), ExcelSave2BalancewithCurrency)

Mobile.verifyElementText(findTestObject('EmailTransfer/OTP Screen - Security Q'), 'Your Birth Palace')

Mobile.verifyElementText(findTestObject('EmailTransfer/OTP Screen - Answer'), 'Rajshahi')

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
Mobile.setText(findTestObject('EmailTransfer/OTP Screen -  Enter OTP here'), OtpNumber, 0)

'Click Transfer Button'
Mobile.tap(findTestObject('EmailTransfer/OTP Screen -  Transfer Btn'), 0)

