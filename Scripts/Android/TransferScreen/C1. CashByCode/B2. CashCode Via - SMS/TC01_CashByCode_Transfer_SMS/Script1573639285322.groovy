import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
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

'User tap on the "Other Bank Account" button of "Transfers" screen.'
Mobile.tap(findTestObject('Transfers Screen/Cash by Code'), 0)

'Verify User is on Cash By COde Screen'
Mobile.verifyElementExist(findTestObject('CashByCode/Cash by Code - Header'), 0)

'Tap on Debit Card Select'
Mobile.tap(findTestObject('CashByCode/Cash by Code - Debit Card Select'), 0)

'Card Select Modal Open'
Mobile.verifyElementExist(findTestObject('CashByCode/Cash by Code - Select Card Popup'), 0)

'Select Visa Debit Card from The Pop up'
Mobile.tapAtPosition(GlobalVariable.CashByCodeAccount_X, GlobalVariable.CashByCodeAccount_Y)

'Get value from excel'
String SavingAccBalance2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 2)

SavingAccBalance2WithoutComma = SavingAccBalance2.replaceAll(',', '')

'Get Selected Card Balance'
def AvalBalance = Mobile.getText(findTestObject('CashByCode/Cash by Code - Available Balance Amount'), 0).replaceAll(',', 
    '')

'Verify get text with Excel book amount'
Mobile.verifyMatch(AvalBalance, SavingAccBalance2WithoutComma, false)

'Get Own Account Transfer Amount from Excel Data Sheet'
String CC_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 4, 5)

'User enter Transfer amount in Transfer amount input field'
Mobile.sendKeys(findTestObject('CashByCode/Cash by Code - Enter amount here'), CC_Amount)

'User enter Beneficiary Number in Beneficiary Mobile Number'
Mobile.sendKeys(findTestObject('CashByCode/Cash by Code - Beneficiary Mobile Number Input'), BeneficiaryNumber)

'User enter Beneficiary Number in Beneficiary Mobile Number'
Mobile.sendKeys(findTestObject('CashByCode/Cash by Code -  Remarks Input'), 'QA Test')

'Select Cash Code Via \'SMS\''
Mobile.tap(findTestObject('CashByCode/Cash by Code - SMS'), 0)

if (Mobile.verifyElementNotExist(findTestObject('CashByCode/Cash by Code - Next'), 0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Back')
}

'OTP Type Selection'
if (GlobalVariable.OTP_Option_Email) {
    Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
} else {
    println('OTP Type : SMS Enable')
}

'Verify Notes Section Showing'
Mobile.verifyElementExist(findTestObject('CashByCode/Cash by Code - Notes'), 0)

'Tap Next Button'
Mobile.tap(findTestObject('CashByCode/Cash by Code - Next'), 0)

