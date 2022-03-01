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

// Excel Data Write
String excelFile = 'Data Files\\File.xlsx'

String sheetName = 'Account_Info'

workbook = ExcelKeywords.getWorkbook(excelFile)

sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Get Current Password From Excel'
String  currentPassword = ExcelKeywords.getCellValueByIndex(sheet01, 1, 9)

'Get New Password From Excel'
String  newPassword = ExcelKeywords.getCellValueByIndex(sheet01, 1, 10)

'Verify Change Login Password Screen Showing'
Mobile.verifyElementExist(findTestObject('MoreScreen/D1. Credential Managment/A1. ChangeLoginPassword/Change Login Password - Header'), 
    0)

'Set Current Password'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/A1. ChangeLoginPassword/Change Login Password - Enter Current Password'), 
    currentPassword, 0)

'Set new Password'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/A1. ChangeLoginPassword/Change Login Password - Enter New Password'), 
    newPassword, 0)

'Set new passord again'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/A1. ChangeLoginPassword/Change Login Password - Re-enter New Password'), 
    newPassword, 0)

if (Mobile.verifyElementNotExist(findTestObject('MoreScreen/D1. Credential Managment/A1. ChangeLoginPassword/Change Login Password - Next'), 
    0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Next')
}

'Tap to next button'
Mobile.tap(findTestObject('MoreScreen/D1. Credential Managment/A1. ChangeLoginPassword/Change Login Password - Next'), 0)

if (Mobile.verifyElementExist(findTestObject('LoginScreen/android.widget.ImageView0'), 20, FailureHandling.OPTIONAL)) {
	
	//Update Excel sheet with new password
	ExcelKeywords.setValueToCellByIndex(sheet01, 1, 9, newPassword)
	
	//Remove Password from New Password cell
	ExcelKeywords.setValueToCellByIndex(sheet01, 1, 10, 'Please Enter New Password Here')
	
	//Save Excel Sheet
	ExcelKeywords.saveWorkbook(excelFile, workbook)
	
}else{
	
	Mobile.closeApplication(FailureHandling.STOP_ON_FAILURE)
}



