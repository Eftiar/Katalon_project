import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable

String projectPath = RunConfiguration.getProjectDir()

String applicationPath = GlobalVariable.ipaPath

String applicationPath = projectPath + applicationPath

println('Application Path : ' + applicationPath)

//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files\\File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Install City Touch app on Device'
Mobile.startApplication(applicationPath, false)

Mobile.comment('First Time Login Navigation Flow with Mobile OTP And valid username and password')

'Verify Application Open'
Mobile.verifyElementExist(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - CityTouch Logo'), 
    0)

'Get Username from Excel Data Sheet'
String userName = ExcelKeywords.getCellValueByIndex(sheet01, 1, 8)

'Get Password from Excel Data Sheet'
String passWord = ExcelKeywords.getCellValueByIndex(sheet01, 1, 9)

'Clear Username input Field'
Mobile.clearText(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Enter your user ID'), 0)

'User input valid username'
Mobile.setText(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Enter your user ID'), userName, 
    0)

'User input valid password'
Mobile.setText(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Enter your password'), passWord, 
    0)

'User click on remember me radio button'
Mobile.tap(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Remember ID - Switch Btn'), 0)

'User click login button'
Mobile.tap(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Login Btn'), 0)

Mobile.comment('User accept terms & Condition')

'User tap accept button'
Mobile.tap(findTestObject('Registration(Android)/android.widget.Button0 - Accept'), 0)

Mobile.comment('User select OTP method and continue')

'User tap continue'
Mobile.tap(findTestObject('Registration(Android)/android.widget.Button0 - Continue'), 0)

'Save/Store OTP Number in Excel Sheet'
Mobile.callTestCase(findTestCase('Android/Utls/TC03_OTPReadFromMessageApp'), [:])

//Mobile.delay(15, FailureHandling.STOP_ON_FAILURE)
//
//'Open Notification panel to read OTP'
//Mobile.openNotifications()
//
///*Read OTP From Notification Panel SMS View*/
//String message = Mobile.getText(findTestObject('LoginScreen/OTP-msg-notification'), 0)
//
//Pattern pattern = Pattern.compile('(\\d{4})' /*Reguler Expression for 4 Digit number from the message*/ )
//
//Matcher m1 = pattern.matcher(message)
//
//String result = ''
//
//'Capture OTP from Mobile'
//if (m1.find()) {
//    result = m1.group(0)
//}
//
//'Close Notification Panel After read OTP'
//Mobile.closeNotifications()
//
//Mobile.delay(5)
Mobile.startExistingApplication(GlobalVariable.CityTouchAppID)

//Excel Data Read Intiliaze
String excelFileOTP = 'Data Files\\File.xlsx'

String sheetNameOtp = 'OTP'

workbookOTP = ExcelKeywords.getWorkbook(excelFileOTP)

OTP = ExcelKeywords.getExcelSheet(workbookOTP, sheetNameOtp)

String OtpNumber = ExcelKeywords.getCellValueByIndex(OTP, 1, 0)

'User Enter OTP PIN code'
Mobile.setText(findTestObject('Registration(Android)/android.widget.EditText0 - Enter 4-Digit One Time Password(OTP)'), 
    OtpNumber, 0)

'User click continue'
Mobile.tap(findTestObject('Registration(Android)/android.widget.Button0 - Continue (1)'), 0)

'User input 1st PIN number'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText-1'), '1', 0)

'User input 2nd PIN number'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0-2'), '2', 0)

'User input 3rd PIN number'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0-3'), '3', 0)

'User input 4th PIN number'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0-4'), '4', 0)

'User input 5th PIN number'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0-5'), '5', 0)

'User input 6th PIN number'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0-6'), '6', 0)

'User click register button'
Mobile.tap(findTestObject('LoginScreen/android.widget.Button0 - Register'), 0)

'Verify Your Mobile PIN has been Successfully set'
Mobile.verifyElementExist(findTestObject('LoginScreen/android.widget.TextView0 - Your mobile PIN has been successfully set up'), 
    0)

'User tap done to finish setup'
Mobile.tap(findTestObject('LoginScreen/android.widget.Button0 - Done'), 0)

Mobile.closeApplication()

