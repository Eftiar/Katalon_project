import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords

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

Mobile.comment('User Login WIth username and Password')

'Open/Install City Touch Android App'
Mobile.startExistingApplication(GlobalVariable.CityTouchAppID, FailureHandling.CONTINUE_ON_FAILURE)

'Get Username from Excel Data Sheet'
String userName = ExcelKeywords.getCellValueByIndex(sheet01, 1, 8)

'Get Password from Excel Data Sheet'
String passWord = ExcelKeywords.getCellValueByIndex(sheet01, 1, 9)

'Clear Username input Field'
Mobile.clearText(findTestObject('LoginScreen/android.widget.EditText0 - Enter Your User ID'), 0)

'User input valid username'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0 - Enter Your User ID'), userName, 0)

'User input valid password'
Mobile.setText(findTestObject('LoginScreen/android.widget.EditText0 - Enter Your Password'), passWord, 0)

'User click login button'
Mobile.tap(findTestObject('LoginScreen/android.widget.Button0 - Login'), 0)