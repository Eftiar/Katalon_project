import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.geom.Arc2D.Double as Double
import java.text.NumberFormat as NumberFormat
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

// Excel Data Write
String excelFile = 'Data Files\\File.xlsx'

String sheetName = 'Account_Info'

workbook = ExcelKeywords.getWorkbook(excelFile)

sheet01 = ExcelKeywords.getExcelSheet(workbook, sheetName)

String MR_Ammount = ExcelKeywords.getCellValueByIndex(sheet01, 6, 5)

Float MR_Ammount_float = Float.parseFloat(MR_Ammount)

'Tap Account button to view account screen'
Mobile.tap(findTestObject('Footer/Footer - Accounts'), 0)

'Take screenshot for verification'
Mobile.takeScreenshot()

'Page Refreshing to get All Data'
Mobile.callTestCase(findTestCase('Android/Utls/TC02_SwipeToptoBottom'), [:])

Mobile.delay(2)

'Continues Page refresh until Saving Accounts Show'
while (Mobile.verifyElementNotExist(findTestObject('AccountsScreen/Section Title - Savings Account'), 10, FailureHandling.OPTIONAL)) {
	'Page Refreshing to get All Data'
	Mobile.callTestCase(findTestCase('Android/Utls/TC02_SwipeToptoBottom'), [:])
}

//Account Balance 01 into Excel
def ActualSavingAccBalance1 = Mobile.getText(findTestObject('AccountsScreen/Saving_Account_Available_Balance_01'), 0).replaceAll(
    ',', '')

Float Ac1_float = Float.parseFloat(ActualSavingAccBalance1)

String ExcelSavingAccBalance1 = ExcelKeywords.getCellValueByIndex(sheet01, 1, 2)

String Ex1_replace = ExcelSavingAccBalance1.replaceAll(',', '')

Float Ex1_float = Float.parseFloat(Ex1_replace)

Float Ex1_FloatTransfer = Ex1_float - MR_Ammount_float

'Verify Mobile Recharge Amount Deducted From This Account'
Mobile.verifyEqual(Ac1_float, Ex1_FloatTransfer)

//Account Balance 02 into Excel
def ActualSavingAccBalance2 = Mobile.getText(findTestObject('AccountsScreen/Saving_Account_Available_Balance_02'), 0).replaceAll(
    ',', '')

Float Ac2_float = Float.parseFloat(ActualSavingAccBalance2)

String ExcelSavingAccBalance2 = ExcelKeywords.getCellValueByIndex(sheet01, 2, 2)

String Ex2_replace = ExcelSavingAccBalance2.replaceAll(',', '')

Float Ex2_float = Float.parseFloat(Ex2_replace)

Float Ex2_floatTransfer = Ex2_float - 0.00

'Verify No Changes on this account'
Mobile.verifyEqual(Ac2_float, Ex2_floatTransfer)

