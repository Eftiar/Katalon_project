import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable

'Start City Touch App'
Mobile.startExistingApplication('com.thecitybank.citytouch.uat', FailureHandling.CONTINUE_ON_FAILURE)

'Tap to login with User ID'
Mobile.tap(findTestObject('LoginWithPIN/Login with User ID (BTN)'), 0)

'Tap on Forget User ID or Password or PIN to Navigate Forget Screen'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/LoginScreen - Forgot User ID or Password or PIN'), 0)

'Tap to Select Forget Type'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Select Type'), 0)

'Tap to select forget password from dropdown'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Select Type - Forgot both User ID and Password'), 0)

//'Enter User ID'
//Mobile.setText(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Enter User ID here'), GlobalVariable.Username, 0)
'Tap to set text on account field'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Enter account number here'), 0)

'Enter Account number here'
Mobile.sendKeys(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Enter account number here'), '2801815151001', FailureHandling.CONTINUE_ON_FAILURE)

'Tap on Keyboard Enter Button'
Mobile.tapAtPosition(969, 2094)

'Tap to select card from dropdown'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Select Card'), 0)

'Select first card from dropdown list'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Select Card - Select 1st Card'), 0)

'Set PIN Number'
Mobile.setText(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Enter PIN here'), '1234', 0)

'Tap on next button'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - Next'), 0)

'Tap OK Button on Popup box'
Mobile.tap(findTestObject('LoginScreen/ForgetScreen/ForgetScreen - OTP Screen - OK'), 0)

if (GlobalVariable.OTP_Option_Email) {
    'Save/Store OTP Number from gmail app to Excel Data Sheet'
    Mobile.callTestCase(findTestCase('Android/Utls/TC04_OTPReadFromEmail'), [:], FailureHandling.CONTINUE_ON_FAILURE)
} else {
    'Save/Store OTP Number from message app to Excel Data Sheet'
    Mobile.callTestCase(findTestCase('Android/Utls/TC03_OTPReadFromMessageApp'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

'Start City Touch App Again'
Mobile.startExistingApplication('com.thecitybank.citytouch.uat')

//Excel Data Read Intiliaze
String excelFileOTP = 'Data Files\\File.xlsx'

String sheetNameOtp = 'OTP'

workbookOTP = ExcelKeywords.getWorkbook(excelFileOTP)

OTP = ExcelKeywords.getExcelSheet(workbookOTP, sheetNameOtp)

String OtpNumber = ExcelKeywords.getCellValueByIndex(OTP, 1, 0)

'Enter OTP Number From Excel OTP Sheet'
Mobile.setText(findTestObject('LoginScreen/ForgetScreen/ForgetScreen- OTP Screen - Enter OTP here'), OtpNumber, 0)

