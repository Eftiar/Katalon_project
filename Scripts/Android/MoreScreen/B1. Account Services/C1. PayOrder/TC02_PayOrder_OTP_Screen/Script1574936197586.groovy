import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import org.junit.After as After
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
String PO_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 9, 5)

Float PO_Amount_float = Float.parseFloat(PO_Amount)

'Get value from excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '').trim()

'Verify Warning Message'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Warning Message'), WarningMsg, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Verify Account Number'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Account Number'), AccNumber, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Get Available Balance from device'
String AvailAbleBalance = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Available Balance'), 
    0).replaceAll(',', '').trim()

'Verify Available Balance "From Data Sheet"'
Mobile.verifyEqual(AvailAbleBalance, SavingAccBalance1WithoutComma)

'Verify Type of account'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Delivery Location'), DeliveryLocation)

'Verify Pay Order Collection Branch "AMBARKHANA"'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Pay Order Collection Branch'), 
    PayOrderCollectionBranch)

'Get Amount from device'
String amountD = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Amount'), 0).replaceAll(',', '').trim()

'Verify Available Balance "From Data Sheet"'
Mobile.verifyEqual(amountD, PO_Amount)

'Verify Beneficiary Name'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Beneficiary Name'), BeneficiaryName)

'Verify Service Charge'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Service Charge'), ServiceCharge)

String serviceCharge = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Service Charge'), 0)

Float serviceChargeFloat = Float.parseFloat(serviceCharge)

'Verify Vat Amount'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Vat Amount'), VAT)

String vatAmount = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Vat Amount'), 0)

Float vatAmountFloat = Float.parseFloat(vatAmount)

String grandTotal = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A3. PayOrder/OTP Screen - Grand Total'), 0).replaceAll(',', '').trim()

Float grandTotalFloat = Float.parseFloat(grandTotal)

Float grandTotalExpected = (PO_Amount_float + serviceChargeFloat) + vatAmountFloat

'Verify Grand Total Amount'
Mobile.verifyEqual(grandTotalFloat, grandTotalExpected)

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
Mobile.setText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Enter OTP here'), OtpNumber, 
    0)

'Take Screenshot For Maturity Date'
Mobile.takeScreenshot()

'Click Transfer Button'
Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Submit Btn'), 0)

