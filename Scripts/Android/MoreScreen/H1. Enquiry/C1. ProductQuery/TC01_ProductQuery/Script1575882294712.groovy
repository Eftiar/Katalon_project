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

'Verify Product Query Screen Showing'
Mobile.verifyElementExist(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Header'), 0)

'Tap to open Select Title from dropdown'
Mobile.tap(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Select Title'), 0)

'Tap to select "Mr." Select Title'
Mobile.tap(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Select Title - Mr.'), 0)

'User Input Full Name'
Mobile.setText(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Full Name Input'), FullName, 0)

'User Input Contact Address\r\n'
Mobile.setText(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Contact Address'), contactAddress, 
    0)

'User Input Email Address'
Mobile.setText(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Email Address'), emailAddress, 0)

'User Input Mobile Number'
Mobile.setText(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Mobile Number'), mobileNumber, 0)

'Tap to open dropdown from Account Type Select'
Mobile.tap(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Select Account Type'), 0)

'Tap to select DPS Account type'
Mobile.tap(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Select Account Type - DPS'), 0)

'Tap to open dropdown for branches'
Mobile.tap(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Select Branch'), 0)

'Tap to select branch Am'
Mobile.tap(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Select Branch - AMBARKHANA'), 0)

'Set Remarks'
Mobile.setText(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Remarks Input'), remarks, 0)

'tap to Next Button'
Mobile.tap(findTestObject('MoreScreen/H1. Enquiry/C1. Product Query/Product Query - Next'), 0)

