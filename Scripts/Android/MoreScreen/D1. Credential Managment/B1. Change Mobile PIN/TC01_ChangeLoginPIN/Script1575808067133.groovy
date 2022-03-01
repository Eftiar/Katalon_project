import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable
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

Mobile.comment('User Input OLP PIN')

'User Input 1st PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Old - Box - 01'), '1', 
    0)

'User Input 2nd PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Old - Box - 02'), '2', 
    0)

'User Input 3rd PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Old - Box - 03'), '3', 
    0)

'User Input 4th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Old - Box - 04'), '4', 
    0)

'User Input 5th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Old - Box - 05'), '5', 
    0)

'User Input 6th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Old - Box - 06'), '6', 
    0)

Mobile.comment('User Input New PIN')

'User Input 1st PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - New - Box - 01'), '9', 
    0)

'User Input 2nd PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - New - Box - 02'), '8', 
    0)

'User Input 3rd PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - New - Box - 03'), '7', 
    0)

'User Input 4th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - New - Box - 04'), '6', 
    0)

'User Input 5th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - New - Box - 05'), '5', 
    0)

'User Input 6th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - New - Box - 06'), '4', 
    0)

Mobile.comment('User Input Retype PIN')

'User Input 1st PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Retype - Box - 01'), 
    '9', 0)

'User Input 2nd PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Retype - Box - 02'), 
    '8', 0)

'User Input 3rd PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Retype - Box - 03'), 
    '7', 0)

'User Input 4th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Retype - Box - 04'), 
    '6', 0)

'User Input 5th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Retype - Box - 05'), 
    '5', 0)

'User Input 6th PIN'
Mobile.setText(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Retype - Box - 06'), 
    '4', 0)

if (Mobile.verifyElementNotExist(findTestObject('MoreScreen/D1. Credential Managment/A1. ChangeLoginPassword/Change Login Password - Next'), 
    0, FailureHandling.OPTIONAL)) {
    'For Small Length Device'
    Mobile.scrollToText('Next')
}

Mobile.tap(findTestObject('MoreScreen/D1. Credential Managment/B1. ChangeLoginPin/PIN Change - Next'), 0)

