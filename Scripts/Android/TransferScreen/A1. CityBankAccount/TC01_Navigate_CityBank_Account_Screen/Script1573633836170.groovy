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

'User tap city bank account button from transfer screen'
Mobile.tap(findTestObject('CityBankAccount/City Bank Account Button'), 0)

'Verify user successfully Navigate to Fund Transfer Screen'
Mobile.verifyElementText(findTestObject('CityBankAccount/Fund Transfer Header Text'), 'Fund Transfer')

'Check Own Account Radio Button Visible'
Mobile.verifyElementExist(findTestObject('CityBankAccount/OWN ACCOUNT BUTTON'), 0)

'Check City Account Radio Button Visible'
Mobile.verifyElementExist(findTestObject('CityBankAccount/CITY ACCOUNT BUTTON'), 0)

