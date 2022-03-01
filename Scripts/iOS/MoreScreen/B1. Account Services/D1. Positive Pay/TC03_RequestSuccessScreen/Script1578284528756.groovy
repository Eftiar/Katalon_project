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

'Wait to load Page'
while (Mobile.verifyElementExist(findTestObject('Utls/Page Load - Loading'), 10, FailureHandling.OPTIONAL)) {
    Mobile.delay(5)
}

'Get Success Message'
def successMsg = Mobile.getText(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Success Screen - Req. Success Message'), 
    0).replaceAll('[0-9]', '').trim()

Mobile.verifyEqual(successMsg, ExpectedMsg)

Mobile.tap(findTestObject('MoreScreen/B1. AccountServices/A4. PositivePay/Sucess Screen - Account Services Home'), 0)