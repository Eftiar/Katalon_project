import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
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

'Tap on Mobile Recharge'
Mobile.tap(findTestObject('Payment Screen/PaymentScreen - Mobile Recharge'), 0)

if (Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg - TransferScreen'), 
    10, FailureHandling.OPTIONAL)) {
    'Tap on Beneficary Managment'
    Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg- Yes'), 
        0)

    Mobile.callTestCase(findTestCase('Android/Beneficiary/F1. Mobile Recharge/TC01_Mobile Recharge - Add Beneficiary'), 
        [('Nickname') : 'Borhan', ('AccNumber') : '01745677420'], FailureHandling.CONTINUE_ON_FAILURE)

    'Call test Case for Beneficiary Managment Security Screen'
    Mobile.callTestCase(findTestCase('Android/Beneficiary/TC01_CityTouch Security Verification'), [('PIN') : PIN], FailureHandling.CONTINUE_ON_FAILURE)
} else {
    'Tap to select Operator'
    Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge - Select Operator'), 60)

    'Check PopUp Open'
    Mobile.verifyElementExist(findTestObject('Payment Screen/A1.Mobile Recharge/Select Operator - Grameen Phone'), 0)

    'Select GrameenPhone From Operators'
    Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/Select Operator - Grameen Phone'), 0)

    'Select To Nickname'
    Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge - Select Nickname'), 0)

    'Select Nickname from PopUp'
    Mobile.tapAtPosition(520, 1177)

    'Connection Type Select Prepaid'
    Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge -Second Screen - Prepaid Radio Btn'), 0)

    'Tap on select account type'
    Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge -Second Screen - Select Account'), 0)

    'Select Account General'
    Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge -Second Screen- Select Account - GENERAL SB'), 
        0)

    'Get value from excel'
    String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

    SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '')
	
	println('From Account Available Balance from Excel = '+SavingAccBalance1WithoutComma)

    'Get Selected account Balance'
    def FrmAccBalance = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge -Second Screen - Avail. Balance Amount'), 
        0).replaceAll(',', '')

    'Verify get text with Excel book amount'
    Mobile.verifyMatch(FrmAccBalance, SavingAccBalance1WithoutComma, false)

    'Get Mobile Recharge Amount from Excel Data Sheet'
    String MR_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 6, 5)

    Float MR_AmountFloat = Float.parseFloat(MR_Amount)

    'User enter Mobile Recharge Amount in Recharge Amount input field'
    Mobile.sendKeys(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge -Second Screen - Input Amount'), MR_Amount)

//    def serviceCharge = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge - Second Screen - Total Service Charge'), 
//        0)
//
//    Float serviceChargeFloat = Float.parseFloat(serviceCharge)
//
//    'Verify Service charge showing accuratly'
//    Mobile.verifyMatch(serviceCharge, '8.00', false)
//
//    def vatAmount = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge - Second Screen - Vat Amount'), 
//        0)
//
//    Float vatAmountFloat = Float.parseFloat(vatAmount)
//
//    'Verify VAT showing accuratly'
//    Mobile.verifyMatch(vatAmount, '1.20', false)

    def grandTotal = Mobile.getText(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge - Second Screen - Grand Total Amount'), 
        0).replaceAll(',', '')
		

    Float grandTotalFloat = Float.parseFloat(grandTotal)

//    Float MR_Amount_WithCharges = MR_AmountFloat + serviceChargeFloat + vatAmountFloat
	

    'Verify Grand Total showing accuratly'
    Mobile.verifyEqual(grandTotalFloat, MR_AmountFloat)

    if (Mobile.verifyElementNotExist(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0, FailureHandling.OPTIONAL)) {
        'For Small Length Device'
        Mobile.scrollToText('Next')
    }
    
    'OTP Type Selection'
    if (GlobalVariable.OTP_Option_Email) {
        Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
    } else {
        println('OTP Type : SMS Enable')
    }
    
    'Verify Notes Section Present'
    Mobile.verifyElementExist(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge - Second Screen - Notes'), 
        0)

    'User tap on NEXT button'
    Mobile.tap(findTestObject('Payment Screen/A1.Mobile Recharge/Mobile Recharge - Second Screen -Next'), 0)

    'User Check Something went Wrong Message not Showing'
    Mobile.verifyElementNotExist(findTestObject('CityBankAccount/Fund Transfer - Something going wrongtry again later'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

