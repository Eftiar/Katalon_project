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
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable as GlobalVariable

'User tap logout button.'
Mobile.tap(findTestObject('LogOutScreen/Logout Button'), 0)

'Check logout Popup Open in app.'
Mobile.verifyElementExist(findTestObject('LogOutScreen/Yes Button'), 0)

'User tap yes button on logout Popup.'
Mobile.tap(findTestObject('LogOutScreen/Yes Button'), 0)

'Check User successfully logout from app.'
Mobile.verifyElementExist(findTestObject('LoginWithPIN/Enter Your PIN Number (Text)'), 0)

