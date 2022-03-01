import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys
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

'Verify User is on add Beneciary Screen'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary Title - Header'), 0)

'User Tap Select Transfer Type Dropdown Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Select Transfer Type - Popup Btn'), 0)

'User Check Select Beneficiary Type Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Select Beneficiary Type - Popup Lebel'), 
    0)

'User select Transfer to bKash'
Mobile.tapAtPosition(GlobalVariable.bKashPosition_X, GlobalVariable.bKashPosition_Y)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

'User Verify Add Beneficiary - Transfer bKash Screen Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - bKash Transfer/Add Beneficiary(bKash Transfer) - Transfer to bKash - Header'), 
    0)

'Tap Random to call Account Service'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - bKash Transfer/Add Beneficiary(bKash Transfer) - bKash Account'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

'Input Account Number 2182603667001'
Mobile.sendKeys(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - bKash Transfer/Add Beneficiary(bKash Transfer) - bKash Account'), 
    AccNumber)

'User Input Nickname Borhan'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - bKash Transfer/Add Beneficiary(bKash Transfer) - Nickname(Please enter here)'), 
    Nickname, 0)

'Next Button Tap'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - bKash Transfer/Add Beneficiary(bKash Transfer) - Next Btn'), 
    5)

Mobile.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

'Second Screen Next Button Tap'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - bKash Transfer/Add Beneficiary(bKash Transfer) - Next 2nd Button'), 
    5)

