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

'Tap on City Account button'
Mobile.tap(findTestObject('CityBankAccount/CITY ACCOUNT BUTTON'), 0)

if (Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg - TransferScreen'), 
    10, FailureHandling.OPTIONAL)) {
    'Tap on Beneficary Managment'
    Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg- Yes'), 
        0)

    'Add Beneficiary for City Bank Transfer'
    Mobile.callTestCase(findTestCase('Android/Beneficiary/B1. City Bank Account Transfer/TC01_City Bank Transfer - Add Beneficiary'), 
        [('Nickname') : Nickname, ('AccNumber') : AccNumber, ('AccHolderName') : AccHolderName, ('Currency_type') : Currency_Type
            , ('AccType') : AccType, ('MobileNumber') : MobileNumber, ('EmailId') : EmailId], FailureHandling.CONTINUE_ON_FAILURE)

    'Call test Case for Beneficiary Managment Security Screen'
    Mobile.callTestCase(findTestCase('Android/Beneficiary/TC01_CityTouch Security Verification'), [('PIN') : PIN], FailureHandling.CONTINUE_ON_FAILURE)
} else {
    'Tap on from account popup selection'
    Mobile.tap(findTestObject('CityBankAccount/OwnAccount/AccSelection - From Account'), 60)

    'Check PopUp Open'
    Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/SELECT ACCOUNT - From - PopUp'), 0)

    'Select high value acc.'
    Mobile.tap(findTestObject('CityBankAccount/OwnAccount/SelectAcc- From - HighValue'), 0)

    'Get value from excel'
    String SavingAccBalance2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 2)

    'Remove all " , " from String'
    SavingAccBalance2WithoutComma = SavingAccBalance2.replaceAll(',', '')

    'Get Selected account Balance'
    def FromAccBalance = Mobile.getText(findTestObject('CityBankAccount/CityAccount/AccSelection - FromAcc - AvailBalAmn'), 
        0)

    'Verify get text with Excel book amount'
    Mobile.verifyMatch(FromAccBalance, SavingAccBalance2WithoutComma, false)

    'Select To Nickname'
    Mobile.tap(findTestObject('CityBankAccount/CityAccount/AccSelectioon - Select Nickname'), 0)

    'Check Popup open'
    Mobile.verifyElementExist(findTestObject('CityBankAccount/CityAccount/PopUp Header - SELECT NICKNAME'), 0)

    'Select Nickname from PopUp'
    Mobile.tap(findTestObject('CityBankAccount/CityAccount/Nickname - 1st_Option'), 0)

    'Get Own Account Transfer Amount from Excel Data Sheet'
    String CAT_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 2, 5)

    'Convert String into Float Number'
    Float CAT_AmountFloat = Float.parseFloat(CAT_Amount)

    'User enter Transfer amount in Transfer amount input field'
    Mobile.sendKeys(findTestObject('CityBankAccount/OwnAccount/Transfer Amount - Input'), CAT_Amount)

    'User Service charge field exist'
    Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/Service Charge FiledLebel'), 0)

    def serviceCharge = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/Service Charge Amount'), 0)

    Float serviceChargeFloat = Float.parseFloat(serviceCharge)

    'Verify Service charge showing accuratly'
    Mobile.verifyMatch(serviceCharge, '20.00', false)

    def vatAmount = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/VAT Amount'), 0)

    Float vatAmountFloat = Float.parseFloat(vatAmount)

    'Verify VAT showing accuratly'
    Mobile.verifyMatch(vatAmount, '3.00', false)

    def grandTotal = Mobile.getText(findTestObject('CityBankAccount/OwnAccount/Grand Total Amount'), 0).replaceAll(',', 
        '')

    Float grandTotalFloat = Float.parseFloat(grandTotal)

    Float Cat_Amount_WithCharges = (CAT_AmountFloat + serviceChargeFloat) + vatAmountFloat

    'Verify Grand Total showing accuratly'
    Mobile.verifyEqual(grandTotalFloat, Cat_Amount_WithCharges)

    if (Mobile.verifyElementNotExist(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0, FailureHandling.OPTIONAL)) {
        'For Small Length Device'
        Mobile.scrollToText('Next')
    }
    
    Mobile.setText(findTestObject('CityBankAccount/OwnAccount/Remarks - Input'), 'QA Test', 0)

    'OTP Type Selection'
    if (GlobalVariable.OTP_Option_Email) {
        Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
    } else {
        println('OTP Type : SMS Enable')
    }
    
    'Verify Notes Section Present'
    Mobile.verifyElementExist(findTestObject('CityBankAccount/OwnAccount/Notes Lebel'), 0)

    'User tap on NEXT button'
    Mobile.tap(findTestObject('CityBankAccount/OwnAccount/Transfer - Next'), 0)

    'User Check Something went Wrong Message not Showing'
    Mobile.verifyElementNotExist(findTestObject('CityBankAccount/Fund Transfer - Something going wrongtry again later'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

