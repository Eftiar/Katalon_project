import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable as GlobalVariable


//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files/File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

Mobile.comment('User Login WIth username and Password')

'Open/Install City Touch Android App'
Mobile.startExistingApplication(GlobalVariable.CityTouchiOSID, FailureHandling.CONTINUE_ON_FAILURE)

'Get Username from Excel Data Sheet'
String userName = ExcelKeywords.getCellValueByIndex(sheet01, 1, 8)

'Get Password from Excel Data Sheet'
String passWord = ExcelKeywords.getCellValueByIndex(sheet01, 1, 9)

'Clear Username input Field'
Mobile.clearText(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Enter your user ID'), 0)

'User input valid username'
Mobile.setText(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Enter your user ID'), userName, 0)

'User input valid password'
Mobile.setText(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Enter your password'), passWord, 0)

'User click login button'
Mobile.tap(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Login Btn'), 0)

if (Mobile.verifyElementExist(findTestObject('LoginScreen/LoginScreen - Image Notification'), 30, FailureHandling.OPTIONAL)) {
	'If Image Notification Show Tap on Cross'
	Mobile.tap(findTestObject('/LoginScreen/LoginScreen - Image Notification - Cross'), 0)
}
'Get Welcome Message from Device'
String Welcome_msg = Mobile.getText(findTestObject('X_iOS/1A. LoginScreen/1A. LoginWithUserIDPassword/LoginScreen - Welcome Message'), 0).toLowerCase()

Mobile.comment('Get Welcome Message after login successfull')

String[] parts = Welcome_msg.split(',')

String part2 = parts[1].trim()

'Verify User logged in Successfully'
Mobile.verifyEqual(part2, GlobalVariable.AccName)

