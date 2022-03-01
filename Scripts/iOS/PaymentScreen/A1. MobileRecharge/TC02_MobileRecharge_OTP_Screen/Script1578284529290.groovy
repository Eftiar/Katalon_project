import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern

import org.junit.After

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

'Get Own Account Transfer Amount from Excel Data Sheet'
String MR_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 6, 5)

Float MR_Amount_float = Float.parseFloat(MR_Amount)

'Verify Transfer amount is "From Data Sheet"'
Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - Operator Value'), 
    Operator, FailureHandling.CONTINUE_ON_FAILURE)

'Get Payment Amount from device'
String PaymentAmn = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - Payment Amount'), 0, FailureHandling.CONTINUE_ON_FAILURE).replaceAll('[A-Z]', ' ').trim()

'Verify Mobile Recharge Amount is "From Data Sheet"'
Mobile.verifyEqual(PaymentAmn, MR_Amount)

//'Verify Service Charge amount "8.00"'
//Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - Service Charge Amount'), 
//    ServiceCharge)

//String serviceCge = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - Service Charge Amount'), 
//    0).replaceAll('[A-Z]', ' ').trim()
//
//Float serviceChargeFloat = Float.parseFloat(serviceCge)

//'Verify Vat amount is "3.00"'
//Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - VAT Amount'), VatAmn)
//
//String vatAmount = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - VAT Amount'), 
//    0).replaceAll('[A-Z]', ' ').trim()
//
//Float vatAmountFloat = Float.parseFloat(vatAmount)

String grandTotal = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - Grand Total Amount'), 
    0).replaceAll('[A-Z]', ' ').trim()

	Float grandTotalFloat = Float.parseFloat(grandTotal)
	
	//Float grandTotalExpected = MR_Amount_float + serviceChargeFloat + vatAmountFloat
	
	'Verify Grand Total amount is "50.00"'
	Mobile.verifyEqual(grandTotalFloat, MR_Amount_float)

if (GlobalVariable.OTP_Option_Email) {
    'Save/Store OTP Number from gmail app to Excel Data Sheet'
    Mobile.callTestCase(findTestCase('Android/Utls/TC04_OTPReadFromEmail'), [:], FailureHandling.CONTINUE_ON_FAILURE)
} else {
    'Save/Store OTP Number from message app to Excel Data Sheet'
    Mobile.callTestCase(findTestCase('Android/Utls/TC03_OTPReadFromMessageApp'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}

'Start City Touch App Again'
Mobile.startExistingApplication(GlobalVariable.CityTouchAppID)

//Excel Data Read Intiliaze
String excelFileOTP = 'Data Files\\File.xlsx'

String sheetNameOtp = 'OTP'

workbookOTP = ExcelKeywords.getWorkbook(excelFileOTP)

OTP = ExcelKeywords.getExcelSheet(workbookOTP, sheetNameOtp)

String OtpNumber = ExcelKeywords.getCellValueByIndex(OTP, 1, 0)

'Enter OTP Number From Excel OTP Sheet'
Mobile.setText(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - Enter OTP here'), OtpNumber, 
    0)

'Click Transfer Button'
Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/B1. Mobile Recharge - OTP Screen/OTP Screen - Payment Button'), 0)

'Check Transfer Successfull Page Showing'
Mobile.waitForElementPresent(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - Receipt'), 
    60, FailureHandling.CONTINUE_ON_FAILURE)

