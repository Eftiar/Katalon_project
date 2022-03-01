import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

def msg = Mobile.getText(findTestObject('EmailTransfer/Email Transfer - Success Message'), 0).replaceAll("[0-9]", "").trim()

Mobile.verifyMatch(msg, EXmsg, false)

Mobile.tap(findTestObject('EmailTransfer/Email Transfer - Complete Btn'), 0)
