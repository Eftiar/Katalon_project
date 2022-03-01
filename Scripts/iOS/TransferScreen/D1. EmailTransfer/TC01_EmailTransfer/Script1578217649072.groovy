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

'User tap on the "Email Transfer" button of "Transfers" screen.'
Mobile.tap(findTestObject('Transfers Screen/Email Transfer'), 0)

'Verify User is on Email Transfer Screen'
Mobile.verifyElementExist(findTestObject('EmailTransfer/Email Transfer - Header'), 0)

'Tap on Select Beneficiary Button'
Mobile.tap(findTestObject('EmailTransfer/Email Transfer - Email Box Button'), 0)

'Select Beneficiary'
Mobile.tap(findTestObject('EmailTransfer/Email Transfer - Select Beneficiary'), 0)

'Card Select Modal Open'
Mobile.verifyElementExist(findTestObject('EmailTransfer/Email Transfer - Select Beneficiary - Header'), 0)

'Select Beneficiary from list'
Mobile.tap(findTestObject('EmailTransfer/Email Transfer - Select Beneficiary - Beneficiary Name'), 0)

'After Tap Beneficiary Check User back to Email Transfer Screen'
Mobile.verifyElementExist(findTestObject('EmailTransfer/Email Transfer - Header'), 0)

'Tap on select from account'
Mobile.tap(findTestObject('EmailTransfer/Email Transfer - Select From Account'), 0)

'Selct 1st Name from the list with X, Y Coordinates'
Mobile.tapAtPosition(520, 1177)

'Get value from excel'
String SavingAccBalance2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 2)

SavingAccBalance2WithoutComma = SavingAccBalance2.replaceAll(',', '')

'Get Selected Card Balance'
def AvalBalance = Mobile.getText(findTestObject('Object Repository/EmailTransfer/Email Transfer - Available Transfer Amount'), 
    0).replaceAll(',', '')

'Verify get text with Excel book amount'
Mobile.verifyMatch(AvalBalance, SavingAccBalance2WithoutComma, false)

'Get Own Account Transfer Amount from Excel Data Sheet'
String ET_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 5, 5)

'User enter Transfer amount in Transfer amount input field'
Mobile.sendKeys(findTestObject('EmailTransfer/Email Transfer - Enter Payment Amount Here'), ET_Amount)

'User enter Beneficiary Number in Beneficiary Mobile Number'
Mobile.sendKeys(findTestObject('EmailTransfer/Email Transfer - Enter Your Security Question'), SecurityQ)

'User enter Beneficiary Number in Beneficiary Mobile Number'
Mobile.sendKeys(findTestObject('EmailTransfer/Email Transfer - Enter Your Answer'), SecurityA)

Mobile.sendKeys(findTestObject('EmailTransfer/Email Transfer - Remarks'), 'QA Test')

if (Mobile.verifyElementNotExist(findTestObject('CashByCode/Cash by Code - Next'), 0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Back')
}

'OTP Type Selection'
if (GlobalVariable.OTP_Option_Email) {
	Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
}else{
	println('OTP Type : SMS Enable')
}

'Verify Notes Section Showing'
Mobile.verifyElementExist(findTestObject('EmailTransfer/Email Transfer - Notes Lebel'), 0)

'Tap Next Button'
Mobile.tap(findTestObject('EmailTransfer/Email Transfer - Next Btn'), 0)

