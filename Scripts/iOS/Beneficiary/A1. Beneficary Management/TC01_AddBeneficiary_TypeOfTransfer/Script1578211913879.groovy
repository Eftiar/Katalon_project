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

'Verify User is on add Beneciary Screen'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary Title - Header'), 0)

'User Tap Select Transfer Type Dropdown Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Select Transfer Type - Popup Btn'), 0)

'User Check Select Beneficiary Type Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Select Beneficiary Type - Popup Lebel'), 
    0)

'User select Transfer Within City Bank'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Transfer Within City Bank - Popup Btn'), 0)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

