import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files\\File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Verify Mobile Transcript Screen Showing'
Mobile.verifyElementExist(findTestObject('Payment Screen/A1.Mobile Recharge/C1. MobileRechargeTranscript/Mobile Recharge Transcript - Header'), 
    0)

'Verify Nickname showing "borhan"'
Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/C1. MobileRechargeTranscript/Mobile Recharge Transcript - Nickname'), 
    'Borhan')

//'Verify Service Charge Showing 8.00'
//Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/C1. MobileRechargeTranscript/Mobile Recharge Transcript - Service Charge'), 
//    '8.00  BDT ')
//
//'Verify Vat Amount Showing 1.20'
//Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/C1. MobileRechargeTranscript/Mobile Recharge Transcript - VAT Amount'), 
//    '1.20  BDT ')

//'Verify Total Amount Showing 50.00'
//Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/C1. MobileRechargeTranscript/Mobile Recharge Transcript - Total Amount'), 
//    '50.00  BDT ')

//'Verify Grand Total Amount Showing "59.20"'
//Mobile.verifyElementText(findTestObject('Payment Screen/A1.Mobile Recharge/C1. MobileRechargeTranscript/Mobile Recharge Transcript - Grand Total'), 
//    '59.20  BDT ')

'Return to Transfer Screen Showing'
Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/C1. MobileRechargeTranscript/Mobile Recharge Transcript - Payment Home Button'), 
    0)

