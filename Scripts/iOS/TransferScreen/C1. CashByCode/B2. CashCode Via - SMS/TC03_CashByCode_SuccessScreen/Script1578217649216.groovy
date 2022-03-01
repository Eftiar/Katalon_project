import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords


def msg = Mobile.getText(findTestObject('CashByCode/Cash by Code - Success Message'), 0).trim()

Mobile.verifyEqual(msg, EXmsg)

Mobile.tap(findTestObject('CashByCode/Cash by Code - Success Screen - Home'), 0)