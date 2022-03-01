import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable

'Tap On button on Pop up box'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - OTP Send Message Box - OK Btn'), 
    0)

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
Mobile.setText(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - OTP Screen -Enter OTP here'), 
    OtpNumber, 0)

'Take Screenshot For Maturity Date'
Mobile.takeScreenshot()

'Click Continue Button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - OTP Screen - Continue'), 
    0)

'Tap OK button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - Success PopUp - Ok Btn'), 
    0)

