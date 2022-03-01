import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern

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

'Check OTP Page Navigate Successfully'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Other Bank Account Fund Transfer Header'), 
    0)

'Get Own Account Transfer Amount from Excel Data Sheet'
String OBT_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 3, 5)

Float OBT_Amount_float = Float.parseFloat(OBT_Amount)

'Verify showing From Account number with Excel Data Saving Account Number 02'
if (Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - From Account Lebel'), 
    0).TRUE) {
    def frmAcc = Mobile.getText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - From Account'), 
        0)

    Pattern pattern = Pattern.compile('(\\d+)' /*Reguler Expression for Digit number from the message*/ )

    Matcher m1 = pattern.matcher(frmAcc)

    String result = ''

    'Capture Only Account Number'
    if (m1.find()) {
        result = m1.group(0)
    }
    
    'Get value from excel'
    def SavingAccNumber2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 1)

    /*Match from account number with excel store data*/
    Mobile.verifyMatch(result, SavingAccNumber2, false)
}

'Verify Nickname "Rockey"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Nickname'), 'Rockey')

'Verify Transfer Mode "BEFTN"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Transfer Mode'), 'RTGS')

'Verify showing to Account number with Excel Data Saving Account Number 01'
if (Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - To Account Lebel'), 
    0).TRUE) {
    def toAcc = Mobile.getText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - To Account Number'), 
        0)

    'Get value from excel'
    def SavingAccNumber2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 1)

    /*Match from account number with excel store data*/
    Mobile.verifyMatch(toAcc, toAccount, false)
}

'Verify Account Type "Account"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Account Type'), 'Account')

'Verify Bank Name "CITI BANK N A"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Bank Name'), 'CITI BANK N A')

'Verify District Name "DHAKA-NORTH"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - District Name'), 'DHAKA-NORTH')

'Verify Branch Name "DHANMONDI"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Branch Name'), 'DHANMONDI')

'Verify Transfer Amount field section'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Transfer Amount Lebel'), 
    0)

'Verify Transfer amount is "From Data SHeet"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Transfer Amount'), 
    OBT_Amount, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Service Charge Amount field Showing'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Service Charge Lebel'), 
    0)

'Verify Service Charge amount "0.00"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Service Charge'), '60.00')

String serviceCharge = Mobile.getText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Service Charge'), 
    0)

Float serviceChargeFloat = Float.parseFloat(serviceCharge)

'Verify Vat Field Showing'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - VAT Lebel'), 0)

'Verify Vat amount is "0.00"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Vat Amount'), '12.00')

String vatAmount = Mobile.getText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Vat Amount'), 
    0)

Float vatAmountFloat = Float.parseFloat(vatAmount)

'Verify Grand Total Field Showing'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Grand Total Lebel'), 
    0)

String grandTotal = Mobile.getText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Grand Total'), 
    0)

Float grandTotalFloat = Float.parseFloat(grandTotal)

Float grandTotalExpected = (OBT_Amount_float + serviceChargeFloat) + vatAmountFloat

'Verify Grand Total amount is "523.00"'
Mobile.verifyEqual(grandTotalFloat, grandTotalExpected)

'Verify Remarks Field Showing'
Mobile.verifyElementExist(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Remarks Lebel'), 0)

'Verify Remarks Text is "QA Test"'
Mobile.verifyElementText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Remarks'), 'QA Test')

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
Mobile.setText(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Enter OTP here'), OtpNumber, 
    0)

'Click Transfer Button'
Mobile.tap(findTestObject('OtherBankAccount/OtherBankAccount - OTP Screen/OTP Screen - Transfer Btn'), 0)

'Check Transfer Successfull Page Showing'
Mobile.waitForElementPresent(findTestObject('CityBankAccount/OwnAccount/TransferSuccessScreen/TransferSuccessScreen - Receipt'), 
    60, FailureHandling.CONTINUE_ON_FAILURE)

