import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

// Excel Data Write
String excelFile = 'Data Files\\File.xlsx'

String sheetName = 'Account_Info'

workbook = ExcelKeywords.getWorkbook(excelFile)

sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Get Current Password From Excel'
String currentPassword = ExcelKeywords.getCellValueByIndex(sheet01, 1, 9)

Mobile.comment('First Time Login Navigation Flow with Mobile OTP And valid username and password')

'User input valid password'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0 - Enter Your Password'), currentPassword, 0)

'User click login button'
Mobile.tap(findTestObject('LoginScreen/android.widget.Button0 - Login'), 0)

'User Tap on "More" button of the footer.'
Mobile.tap(findTestObject('Footer/More'), 0)

'User Tap on "Settings" button of the footer.'
Mobile.tap(findTestObject('MoreScreen/More Screen - Settings'), 0)

Mobile.tap(findTestObject('MoreScreen/A1. Settings/B1. PIN Login/PIN Code Screen'), 0)

Mobile.tap(findTestObject('MoreScreen/A1. Settings/B1. PIN Login/PIn On - Switch'), 0)

Mobile.verifyElementExist(findTestObject('MoreScreen/A1. Settings/B1. PIN Login/PIN Login Screen - Enter Your PIN Number'), 
    0)

