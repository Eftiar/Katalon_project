import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import org.stringtemplate.v4.compiler.STParser.ifstat_return as ifstat_return
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable

// Excel Data Write
String excelFile = 'Data Files\\File.xlsx'

String sheetNameOtp = 'OTP'

workbook = ExcelKeywords.getWorkbook(excelFile)

OTP = ExcelKeywords.getExcelSheet(workbook, sheetNameOtp)

Mobile.startExistingApplication(GlobalVariable.MessageAppID)

if (Mobile.verifyElementExist(findTestObject('LoginScreen/OTP_FROM_MESSAGE_APP/Message Title- CITY BANK'), 10, FailureHandling.OPTIONAL)) {
	
    Mobile.tap(findTestObject('LoginScreen/OTP_FROM_MESSAGE_APP/Message Title- CITY BANK'), 0)
}

String result = ''

if (GlobalVariable.MessageAppID == 'com.oneplus.mms') {
	'Get Message from OnePlus Device v10'
	String messageBody = Mobile.getText(findTestObject('LoginScreen/OTP_FROM_MESSAGE_APP/MESSAGE - OTP LAST MESSAGE BODY - OnePlus'),
		0)
	
	Pattern pattern = Pattern.compile('(\\d{4})' /*Reguler Expression for 4 Digit number from the message*/ )
	
	Matcher m1 = pattern.matcher(messageBody)
	
	'Capture OTP from Mobile'
	if (m1.find()) {
		result = m1.group(0)
	}
	
}else {
	'Get Message from Android Device'
	String messageBody = Mobile.getText(findTestObject('LoginScreen/OTP_FROM_MESSAGE_APP/MESSAGE - OTP LAST MESSAGE BODY - AllDevice'),
		0)
	
	Pattern pattern = Pattern.compile('(\\d{4})' /*Reguler Expression for 4 Digit number from the message*/ )
	
	Matcher m1 = pattern.matcher(messageBody)
	
	'Capture OTP from Mobile'
	if (m1.find()) {
		result = m1.group(0)
	}

}



ExcelKeywords.setValueToCellByIndex(OTP, 1, 0, result)

ExcelKeywords.saveWorkbook(excelFile, workbook)

