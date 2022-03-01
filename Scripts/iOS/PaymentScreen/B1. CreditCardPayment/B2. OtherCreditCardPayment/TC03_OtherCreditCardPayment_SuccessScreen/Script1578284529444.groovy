import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

'Wait to load Page'
while (Mobile.verifyElementExist(findTestObject('Utls/Page Load - Loading'), 10, FailureHandling.OPTIONAL)) {
	Mobile.delay(5)
}

'Verify User on Success Page'
Mobile.verifyElementExist(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CC Payment - Success Screen - Reference Number Lebel'), 
    0)

'Take screenshot for detail check'
Mobile.takeScreenshot()

'Tap to Return Home Page'
Mobile.tap(findTestObject('Payment Screen/B1. Credit Card Payment/A1. OwnCreditCard/CC Payment - Success Screen- Return To Home'), 
    0)
