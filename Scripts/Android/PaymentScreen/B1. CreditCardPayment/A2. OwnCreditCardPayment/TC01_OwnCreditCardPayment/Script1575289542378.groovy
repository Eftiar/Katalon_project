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

//End Excel
'Tap Select Credit Card Dropdown'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Select Credit Card'), 
    0)

'Select Agora From Card list'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - Card - AMEX AGORA'), 
    0)

'Get Credit Card Value From Excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

String SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '')

'Get Minimum Payment Due Amount From Device'
String CC_paymentDueBalance = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Minimum Payment Due Amount'), 
    0)

String decValue = '.00'
//Added Decimal Value with String For Assertion
String CC_paymentDue = CC_paymentDueBalance + decValue

'Last Outstanding Balance Due'
def last_outstandingBalance = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Last Outstanding Balance Amount'), 
    0)

'Tap to select from account'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Select From Account'), 
    0)

'Tap to select from account list'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - GENERAL'), 
    0)

'Get Selected account Balance'
def AvailableBalance = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Available Balance Amount'), 
    0)

'Verify get text with Excel book amount'
Mobile.verifyMatch(AvailableBalance, SavingAccBalance1WithoutComma, false)

'User enter Transfer amount in Transfer amount input field'
Mobile.sendKeys(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Payment Amount Input'), 
    CC_paymentDue)

'Get Actual Grandtotal value from Device'
String grandTotal = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Grand Total Amount'), 0).replaceAll(',', '')

'Verify Grand Total showing accuratly'
Mobile.verifyMatch(grandTotal, CC_paymentDue, false)

'Save Grand Total Amount on Excel File'
ExcelKeywords.setValueToCellByIndex(sheet01, 11, 5, grandTotal)

if (Mobile.verifyElementNotExist(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Next')
}

'Set Payment Narration'
Mobile.setText(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CreditCardPayment - OwnCreditCard - Narration'), 'QA Test', 0)

'OTP Type Selection'
if (GlobalVariable.OTP_Option_Email) {
    Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
} else {
    println('OTP Type : SMS Enable')
}

Mobile.scrollToText('Next', FailureHandling.CONTINUE_ON_FAILURE)

'User tap on NEXT button'
Mobile.tap(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0)

'Save Excel File'
ExcelKeywords.saveWorkbook(excelFile, workbook)

