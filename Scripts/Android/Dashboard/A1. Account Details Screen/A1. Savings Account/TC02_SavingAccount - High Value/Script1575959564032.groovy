import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Continues Page refresh until Saving Accounts Show'
while (Mobile.verifyElementNotExist(findTestObject('AccountsScreen/Section Title - Savings Account'), 10, FailureHandling.OPTIONAL)) {
    'Page Refreshing to get All Data'
    Mobile.callTestCase(findTestCase('Android/Utls/TC02_SwipeToptoBottom'), [:])
}

'User tap general sb account from account Screen'
Mobile.tap(findTestObject('Dashboard/A1. AccountDetails/SavingsAccount - HIGH VALUE'), 0)

'Continues Page refresh until Saving Accounts Show'
while (Mobile.verifyElementExist(findTestObject('Dashboard/A1. AccountDetails/AccountDetails _ Loading'), 10, FailureHandling.OPTIONAL)) {
	'Page Refreshing to get All Data'
	Mobile.delay(3)
}

'User verify text present'
Mobile.takeScreenshot()

Mobile.pressBack()