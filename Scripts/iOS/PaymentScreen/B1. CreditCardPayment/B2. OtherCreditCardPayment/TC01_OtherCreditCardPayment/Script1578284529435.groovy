import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

//Excel Data Read Intiliaze
'Excel file path declaration'
String excelFile = 'Data Files\\File.xlsx'

'Define Sheet name'
String sheetName = 'Account_Info'

'Workbook Define'
workbook = ExcelKeywords.getWorkbook(excelFile)

'Sheet name define'
sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Tap on City Account button'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/CreditCardPayment - OTHER CREDIT CARD PAYMENT TAB'), 0)

if (Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg - TransferScreen'), 
    10, FailureHandling.OPTIONAL)) {
    'Tap on Beneficary Managment'
    Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg- Yes'), 
        0)

    'Add Beneficiary for credit card payment'
    Mobile.callTestCase(findTestCase('Android/Beneficiary/G1. Other Credit Card Payment/TC01_Credit_Card_Payment - Add Beneficiary'), 
        [('Nickname') : 'Asad', ('AccNumber') : '376948120725458', ('AccHolderName') : 'MD ASADUL HAQUE', ('CardType') : 'primary'
            , ('CardStatus') : 'Open', ('MobileNumber') : '01745677520', ('EmailId') : 'borhan7420@gmail.com'], FailureHandling.CONTINUE_ON_FAILURE)

    'Call test Case for Beneficiary Managment Security Screen'
    Mobile.callTestCase(findTestCase('Android/Beneficiary/TC01_CityTouch Security Verification'), [('PIN') : PIN], FailureHandling.CONTINUE_ON_FAILURE)

    'Navigate to Credit Card Payment'
    WebUI.callTestCase(findTestCase('Android/PaymentScreen/B1. CreditCardPayment/TC01_Navigate_CreditCardPayment'), [:], 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    'Tap to select Nickname from beneficiary Item'
    Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Select Nickname'), 
        60)

    'Select First Nickname from the list'
    Mobile.tapAtPosition(520, 1178)

    'Tap to select account'
    Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Select From Account'), 
        0)

    'Tap to select 1st card from the dropdown list'
    Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Select From Account - 1st Card'), 
        0)

    'Get value from excel'
    String SavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

    String SavingAccBalance1WithoutComma = SavingAccBalance1.replaceAll(',', '')

    'Get Selected account Balance'
    def AvailableBalance = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Available Balance'), 
        0)

    'Verify get text with Excel book amount'
    Mobile.verifyMatch(AvailableBalance, SavingAccBalance1WithoutComma, false)

    'Get Own Account Transfer Amount from Excel Data Sheet'
    String CC_payment_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 12, 5)

    Float CC_Payment_AmountFloat = Float.parseFloat(CC_payment_Amount)

    'User enter Transfer amount in Transfer amount input field'
    Mobile.sendKeys(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Payment Amount Input'), 
        CC_payment_Amount)

    'User Service charge field exist'
    Mobile.verifyElementExist(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Service Charge'), 
        0)

    def serviceCharge = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Service Charge'), 
        0)

    Float serviceChargeFloat = Float.parseFloat(serviceCharge)

    'Verify Service charge showing accuratly'
    Mobile.verifyMatch(serviceCharge, '0.00', false)

    def grandTotal = Mobile.getText(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Grand Total'), 
        0).replaceAll(',', '')

    Float grandTotalFloat = Float.parseFloat(grandTotal)

    Float CC_Amount_WithCharges = CC_Payment_AmountFloat + serviceChargeFloat

    'Verify Grand Total showing accuratly'
    Mobile.verifyEqual(grandTotalFloat, CC_Amount_WithCharges)

    if (Mobile.verifyElementNotExist(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0, FailureHandling.OPTIONAL)) {
        'For Small Length Device'
        Mobile.scrollToText('Next')
    }
    
    Mobile.setText(findTestObject('Payment Screen/B1. Credit Card Payment/B1. OtherCreditCardPayment/Credit Card Payment - Payment Naration'), 
        'QA Test', 0)

    'OTP Type Selection'
    if (GlobalVariable.OTP_Option_Email) {
        Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
    } else {
        println('OTP Type : SMS Enable')
    }
    
    'User tap on NEXT button'
    Mobile.tap(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0)
}

