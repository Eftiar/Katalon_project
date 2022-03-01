import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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

'User tap on the "Other Bank Account" button of "Transfers" screen.'
Mobile.tap(findTestObject('Transfers Screen/Other Bank Account'), 0)

if (Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg - TransferScreen'), 
    10, FailureHandling.OPTIONAL)) {
    'Tap on Beneficary Managment'
    Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Within City Bank/EmptyBeneficiaryMsg- Yes'), 
        0)

    Mobile.callTestCase(findTestCase('Android/Beneficiary/C1. Other Bank Account Transfer/TC01_Other Bank Transfer - Add Beneficiary'), 
        [('Nickname') : 'Rockey', ('AccNumber') : '24134154101', ('AccName') : 'MD. Moniruzzaman', ('Currency_type') : 'BDT'
            , ('AccType') : 'SAVING BANK A/C', ('MobileNumber') : '01745677520', ('EmailId') : 'sani_jahan@bs-23.net'], 
        FailureHandling.CONTINUE_ON_FAILURE)

    Mobile.callTestCase(findTestCase('Android/Beneficiary/TC01_CityTouch Security Verification'), [('PIN') : '1234'], FailureHandling.CONTINUE_ON_FAILURE)
} else {
    Mobile.tap(findTestObject('OtherBankAccount/From Account - Select Account - Popup'), 0)

    Mobile.tap(findTestObject('OtherBankAccount/From Account - Select Account - HIGH VALUE SAVINGS AC'), 0)

    Mobile.tap(findTestObject('OtherBankAccount/AccSelecetion - Select Nickname'), 0)

    'Selct 1st Name from the list with X, Y Coordinates'
    Mobile.tapAtPosition(520, 1177)

    'Get Own Account Transfer Amount from Excel Data Sheet'
    String OBT_Amount = ExcelKeywords.getCellValueByIndex(sheet01, 3, 5)

    Float OBT_AmountFloat = Float.parseFloat(OBT_Amount)

    'User enter Transfer amount in Transfer amount input field'
    Mobile.sendKeys(findTestObject('OtherBankAccount/Transfer Amount - Input'), OBT_Amount)

    Mobile.tap(findTestObject('OtherBankAccount/Transfer Mode - RTGS (Instant Transfer)'), 0)

    if (Mobile.verifyElementNotExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Other Bank/Next - Btn'), 
        0, FailureHandling.OPTIONAL)) {
        'For Small Length Device'
        Mobile.scrollToText('Back')
    }
    
    Mobile.setText(findTestObject('OtherBankAccount/Remarks Input Field'), 'QA Test', 0)
	
	'OTP Type Selection'
	if (GlobalVariable.OTP_Option_Email) {
		Mobile.tap(GlobalVariable.OTP_Type_Email, 0)
	}else{
		println('OTP Type : SMS Enable')
	}

    Mobile.tap(findTestObject('OtherBankAccount/Next - Btn'), 0)
}

