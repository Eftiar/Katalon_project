import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

String excelFile = 'Data Files\\File.xlsx'

String sheetNameOtp = 'OTP'

workbook = ExcelKeywords.getWorkbook(excelFile)

OTP = ExcelKeywords.getExcelSheet(workbook, sheetNameOtp)

Mobile.startExistingApplication('com.google.android.gm')

Mobile.delay(20)

Mobile.tap(findTestObject('Utls/OTPReadEmail/OTPEmail'), 0)

Pattern pattern = Pattern.compile('(\\d{4})' /*Reguler Expression for 4 Digit number from the message*/ )

emailBodyMsg = Mobile.getText(findTestObject('Object Repository/Utls/OTPReadEmail/EmailOTP_MsgBody'), 0)

Matcher m1 = pattern.matcher(emailBodyMsg)

String result = ''

'Capture OTP from Mobile'
if (m1.find()) {
    result = m1.group(0)
}

println('OTP Message from Email Application = =' + result)

ExcelKeywords.setValueToCellByIndex(OTP, 1, 0, result)

ExcelKeywords.saveWorkbook(excelFile, workbook)

