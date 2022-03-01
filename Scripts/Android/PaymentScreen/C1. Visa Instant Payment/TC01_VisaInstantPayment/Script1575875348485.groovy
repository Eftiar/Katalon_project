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

'Verify VISA Instant Payment Screen Showing'
Mobile.verifyElementText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Header'), 'VISA Instant Payment')

//End Excel
'Navigate to VISA Instant Payment'
Mobile.tap(findTestObject('Payment Screen/PaymentScreen - VISA Instant Payment'), 0)

'Get Saving Account Balance From Excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

String SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '')

'Select From Account'
Mobile.tap(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Select From Account'), 0)

'Select From Account 1st Card from Dropdown list'
Mobile.tap(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Select From Account - 1st Card'), 
    0)

'Get Minimum Payment Due Amount From Device'
String availableBalance = Mobile.getText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Available Balance Amount'), 
    0)

'Verify Match With Available Balance'
Mobile.verifyEqual(availableBalance, SavingAccBalance1WithoutComma)

'Tap to select Nickname'
Mobile.tap(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Select Nickname'), 0)

'Select 1st Nickname from List'
Mobile.tapAtPosition(GlobalVariable.position_X,GlobalVariable.position_Y)

'Get Saving Account Balance From Excel'
String visaPayment = ExcelKeywords.getCellValueByIndex(sheet01, 13, 5) 

Float visaPaymentFloat = Float.parseFloat(visaPayment)

'Get Selected account Balance'
Mobile.setText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Transfer Amount Input'), visaPayment, 
    0)

'Verify Servie Charge'
Mobile.verifyElementText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Service Charge'), 
    '40.25')

'Get Actual Service Charge value from Device'
String serviceCharge = Mobile.getText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Service Charge'), 
    0).replaceAll(',', '')
	
Float serviceChargeFloat = 	Float.parseFloat(serviceCharge)

'Get Actual Grand total value from Device'
String grandTotal = Mobile.getText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Grand Total'), 0).replaceAll(',', '')

Float grandTotalFloat = Float.parseFloat(grandTotal)
	
'Verify Grand Total Value'	
Mobile.verifyElementText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Grand Total'),
		grandTotal) 

Float totalAmn = visaPaymentFloat + serviceChargeFloat

'Verify Grand Total showing accuratly'
Mobile.verifyEqual(grandTotalFloat, totalAmn)

'Save Grand Total Amount on Excel File'
ExcelKeywords.setValueToCellByIndex(sheet01, 11, 5, grandTotal)

if (Mobile.verifyElementNotExist(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Next'), 0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Next')
}

'Set Payment Remarks'
Mobile.setText(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Remarks Input'), 
    'QA Test', 0)

'OTP Type Selection'
if (GlobalVariable.OTP_Option_Email) {
    Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
} else {
    println('OTP Type : SMS Enable')
}

'User tap on NEXT button'
Mobile.tap(findTestObject('Payment Screen/C1. VISA Instant Payment/VISA Instant Payment - Next'), 0)

'Save Excel File'
ExcelKeywords.saveWorkbook(excelFile, workbook)

