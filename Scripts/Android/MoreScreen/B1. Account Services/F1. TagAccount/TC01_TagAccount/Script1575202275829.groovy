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

'Verify Tag Account Header Screen'
Mobile.verifyElementExist(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - Header'), 
    0)

'Tap to Input Account Number Here'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - Enter account no. here'), 
    0)

'Enter Account Number'
Mobile.sendKeys(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - Enter account no. here'), 
    AccNumber)

'Tap Enter on Device Keyboard'
Mobile.tapAtPosition(969, 2094)

'Verify Account Name "Md. Borhan Uddin Sarker" Showing'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - Account Name'), 
    AccName)

'Set Text Mobile number input field'
Mobile.setText(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - SMS OTP Number Input'), 
    OTP_Mobile, 0)

'Tap on Next button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A5. TagAccount/Tag Account in Citytouch - Next Btn'), 0)

