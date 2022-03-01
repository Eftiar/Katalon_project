import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

// Excel Data Write
String excelFile = 'Data Files/File.xlsx'

String sheetName = 'Account_Info'

workbook = ExcelKeywords.getWorkbook(excelFile)

sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

'Continues Page Refresh until Saving Accounts Show'
while (Mobile.verifyElementNotExist(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard- SAVINGS ACCOUNT Title'), 
    10, FailureHandling.OPTIONAL)) {
    'Page Refreshing to get All Data'
    Mobile.callTestCase(findTestCase('Android/Utls/TC02_SwipeToptoBottom'), [:])
}

//Account Name 01 into Excel
String SavingAccName1 = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Savings Account - Account 01 - Name'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 1, 0, SavingAccName1)

//Account Number 01 Saving into Excel
def SavingAccNumber1 = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Savings Account - Account 01 - Number'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 1, 1, SavingAccNumber1)

//Account Balance 01 Saving into Excel
def SavingAccBalance1 = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Savings Account - Account 01 - Balance'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 1, 2, SavingAccBalance1)

//Account Name 02 Saving into Excel
String SavingAccName2 = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Savings Account - Account 02 - Name'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 2, 0, SavingAccName2)

//Account Number 02 Saving into Excel
def SavingAccNumber2 = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Savings Account - Account 02 - Number'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 2, 1, SavingAccNumber2)

//Account Balance 02 Saving into Excel
def SavingAccBalance2 = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Savings Account - Account 02 - Balance'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 2, 2, SavingAccBalance2)

//Credit Card 01 Info Saving into Excel
String CreditCardName = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Credit Card - Account 01 - Name'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 3, 0, CreditCardName)

//Credit Card 01 Info Saving into Excel
def CreditCardNumber = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Credit Card - Account 01 - Number'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 3, 1, CreditCardNumber)

//Credit Card 01 Info Saving into Excel
def CreditCardBalance = Mobile.getText(findTestObject('X_iOS/1B. AccountsScreen/1A. Dashboard/Accounts Dashboard - Credit Card - Account 01 - Balance'), 
    0)

ExcelKeywords.setValueToCellByIndex(sheet01, 3, 2, CreditCardBalance)

//Credit Card 02 Info Saving into Excel
//String CreditCardName2 = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Name_02'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 4, 0, CreditCardName2)
//Credit Card 02 Info Saving into Excel
//def CreditCardNumber2 = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Number_02'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 4, 1, CreditCardNumber2)
//Credit Card 02 Info Saving into Excel
//def CreditCardBalance2 = Mobile.getText(findTestObject('AccountsScreen/Credit_Card_Available_Balance_02'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 4, 2, CreditCardBalance2)
/*
'Scroll to Bottom of the screen'
Mobile.scrollToText('8621815151004')

//'Scroll to Bottom of the screen'
//Mobile.scrollToText('8621815151005')

//DPS 01 Info Saving into Excel
String dpsname1 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 5, 0, dpsname1)

//DPS 01 Info Saving into Excel
def dpsNumber1 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 5, 1, dpsNumber1)

//DPS 01 Info Saving into Excel
def dpsBalance1 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_01'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 5, 2, dpsBalance1)

//DPS 02 Info Saving into Excel
String dpsname2 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_02'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 6, 0, dpsname2)

//DPS 02 Info Saving into Excel
def dpsNumber2 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_02'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 6, 1, dpsNumber2)

//DPS 02 Info Saving into Excel
def dpsBalance2 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_02'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 6, 2, dpsBalance2)

//DPS 03 Info Saving into Excel
String dpsname3 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_03'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 7, 0, dpsname3)

//DPS 03 Info Saving into Excel
def dpsNumber3 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_03'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 7, 1, dpsNumber3)

//DPS 03 Info Saving into Excel
def dpsBalance3 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_03'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 7, 2, dpsBalance3)

//DPS 04 Info Saving into Excel
String dpsname4 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_04'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 8, 0, dpsname4)

//DPS 04 Info Saving into Excel
def dpsNumber4 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_04'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 8, 1, dpsNumber4)

//DPS 04 Info Saving into Excel
def dpsBalance4 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_04'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 8, 2, dpsBalance4)

//DPS 05 Info Saving into Excel
String dpsname5 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_05'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 9, 0, dpsname5)

//DPS 05 Info Saving into Excel
def dpsNumber5 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_05'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 9, 1, dpsNumber5)

//DPS 05 Info Saving into Excel
def dpsBalance5 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_05'), 0)

ExcelKeywords.setValueToCellByIndex(sheet01, 9, 2, dpsBalance5)*/
////DPS 01 Info Saving into Excel
//String dpsname1 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_01'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 5, 0, dpsname1)
//
////DPS 01 Info Saving into Excel
//def dpsNumber1 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_01'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 5, 1, dpsNumber1)
//
////DPS 01 Info Saving into Excel
//def dpsBalance1 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_01'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 5, 2, dpsBalance1)
//
////DPS 02 Info Saving into Excel
//String dpsname2 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_02'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 6, 0, dpsname2)
//
////DPS 02 Info Saving into Excel
//def dpsNumber2 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_02'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 6, 1, dpsNumber2)
//
////DPS 02 Info Saving into Excel
//def dpsBalance2 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_02'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 6, 2, dpsBalance2)
//
////DPS 03 Info Saving into Excel
//String dpsname3 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_03'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 7, 0, dpsname3)
//
////DPS 03 Info Saving into Excel
//def dpsNumber3 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_03'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 7, 1, dpsNumber3)
//
////DPS 03 Info Saving into Excel
//def dpsBalance3 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_03'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 7, 2, dpsBalance3)
//
////DPS 04 Info Saving into Excel
//String dpsname4 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_04'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 8, 0, dpsname4)
//
////DPS 04 Info Saving into Excel
//def dpsNumber4 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_04'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 8, 1, dpsNumber4)
//
////DPS 04 Info Saving into Excel
//def dpsBalance4 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_04'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 8, 2, dpsBalance4)
//
////DPS 05 Info Saving into Excel
//String dpsname5 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Name_05'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 9, 0, dpsname5)
//
////DPS 05 Info Saving into Excel
//def dpsNumber5 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Account_Number_05'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 9, 1, dpsNumber5)
//
////DPS 05 Info Saving into Excel
//def dpsBalance5 = Mobile.getText(findTestObject('AccountsScreen/General_DPS_Available_Balance_05'), 0)
//
//ExcelKeywords.setValueToCellByIndex(sheet01, 9, 2, dpsBalance5)

//Save the excel
ExcelKeywords.saveWorkbook(excelFile, workbook)

