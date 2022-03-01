import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files\\File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Verify Thank You text Showing'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - Thank You'), 
    0)

'Verify Your transfer was successful Text Showing'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - Your transfer was successful.'), 
    0)

'Get Own Account Transfer Amount from Excel Data Sheet'
String OBT_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 3, 5)

def TransferAmount = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - Ammount'), 
    0, FailureHandling.CONTINUE_ON_FAILURE).replaceAll(',', '')

'Verify Transfer Amount is "1,200"'
Mobile.verifyMatch(TransferAmount, OBT_Amount, false, FailureHandling.CONTINUE_ON_FAILURE)

def AccName = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - From_AccountNumber'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Acutal Card Name Showing'
if (AccName.contains('HIGH VALUE SAVINGS A/C')) {
    println('Actual Card Showing')
}

'Return to Transfer Screen Showing'
Mobile.tap(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - Return To Home Button'), 
    0)

