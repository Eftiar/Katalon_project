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
String FD_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 7, 5)

Float FD_Amount_float = Float.parseFloat(FD_Amount)

'Get value from excel'
String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '').trim()

'Verify Account Number'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Acc Number'), AccNumber, 
    FailureHandling.CONTINUE_ON_FAILURE)

'Verify Account Number'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Acc Name'), AccTitle, 
    FailureHandling.CONTINUE_ON_FAILURE)

findTestObject('Object Repository/MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Avail. Balance')

'Get Available Balance from device'
String AvailAbleBalance = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Avail. Balance'), 
    0).replaceAll(',', '').trim()

'Verify Available Balance "From Data Sheet"'
Mobile.verifyEqual(AvailAbleBalance, SavingAccBalance1WithoutComma)

'Verify Type of account'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Type Of Account'), 
    TypeOfAccount)

'Verify Tenure Type'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Tenure Type'), TenureType)

'Verify Tenure Period'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Tenure Period'), TenurePeriod)

'Verify Auto Renewal Type No'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Auto Renewal Enable'), 
    AutoRenewalType)

'Get Amount from device'
String amountD = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Amount'), 0)

'Verify Available Balance "From Data Sheet"'
Mobile.verifyEqual(amountD, FD_Amount)

'Verify Interest Rate'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Interest Rate'), InterestRate)

'Verify Interest Rate'
Mobile.verifyElementText(findTestObject('MoreScreen/B1. AccountServices/A1. FixedDeposit/OTP Screen - Deposit Advise Collection Branch'), 
    DepositCollectionBranch)

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

