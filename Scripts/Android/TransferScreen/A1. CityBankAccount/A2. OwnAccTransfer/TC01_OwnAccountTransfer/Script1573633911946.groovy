import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

import internal.GlobalVariable

//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files\\File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

//End Excel
'Tap on from account popup selection'
Mobile.tap(findTestObject('CityBankAccount/OwnAccount/AccSelection - From Account'), 0)

'Check PopUp Open'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/SELECT ACCOUNT - From - PopUp'), 0)

'Select high value acc.'
Mobile.tap(findTestObject('CityBankAccount/OwnAccount/SelectAcc- From - HighValue'), 0)

'Get value from excel'
String SavingAccBalance2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 2)

SavingAccBalance2WithoutComma = SavingAccBalance2.replaceAll(',', '')

'Get Selected account Balance'
def FromAccBalance = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/AccSelection - FromAcc - AvailBalAmn'), 0)

'Verify get text with Excel book amount'
Mobile.verifyMatch(FromAccBalance, SavingAccBalance2WithoutComma, false)

'Select To Account'
Mobile.tap(findTestObject('CityBankAccount/OwnAccount/AccSelection - To Account'), 0)

Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/SELECT ACCOUNT - TO - PopUp'), 0)

Mobile.tap(findTestObject('CityBankAccount/OwnAccount/SelectAcc - TO -GENERAL SB AC PAYROLL'), 0)

'Get value from excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '')

'Get Selected account Balance'
def ToAccBalance = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/AccSelection - ToAcc - AvailBalAmn'), 0)

'Verify get text with Excel book amount'
Mobile.verifyMatch(ToAccBalance, SavingAccBalance1WithoutComma, false)

'Get Own Account Transfer Amount from Excel Data Sheet'
String OAT_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 1, 5)

'User enter Transfer amount in Transfer amount input field'
Mobile.sendKeys(findTestObject('CityBankAccount/OwnAccount/Transfer Amount - Input'), OAT_Amount)

'User Service charge field exist'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/Service Charge FiledLebel'), 0)

def serviceCharge = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/Service Charge Amount'), 0)

'Verify Service charge showing accuratly'
Mobile.verifyMatch(serviceCharge, '0.00', false)

def vatAmount = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/VAT Amount'), 0)

'Verify VAT showing accuratly'
Mobile.verifyMatch(vatAmount, '0.00', false)

def grandTotal = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/Grand Total Amount'), 0).replaceAll(',', '')

'Verify Grand Total showing accuratly'
Mobile.verifyMatch(grandTotal, OAT_Amount, false)

if (Mobile.verifyElementNotExist(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Next')
}

Mobile.setText(findTestObject('CityBankAccount/OwnAccount/Remarks - Input'), 'QA Test', 0)

'OTP Type Selection From Global Variable'
if (GlobalVariable.OTP_Option_Email) {	
	Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
}else{	
	println('OTP Type : SMS Enable')
}

'Verify Notes Section Present'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/Notes Lebel'), 0)

Mobile.scrollToText('Next', FailureHandling.CONTINUE_ON_FAILURE)

'User tap on NEXT button'
Mobile.tap(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0)

