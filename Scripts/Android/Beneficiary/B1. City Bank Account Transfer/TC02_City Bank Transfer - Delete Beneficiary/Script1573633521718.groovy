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

'Tap on Delete Beneficiary Button'
Mobile.tap(findTestObject('Beneficiary Management/Delete Beneficiary - Btn'), 0)

'Verify User is on delete Beneciary Screen'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Delete Beneficiary - Within City Bank/Delete Beneficiary - Header'), 
    0)

'User Tap Select Transfer Type Dropdown Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Select Transfer Type - Popup Btn'), 0)

'User Check Select Beneficiary Type Showing'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Select Beneficiary Type - Popup Lebel'), 
    0)

'User select Within City Bank Transfer'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Transfer Within City Bank - Popup Btn'), 0)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

'Verify User is on add Beneciary Screen'
Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Delete Beneficiary - Within City Bank/Delete Beneficiary - Within City Bank - Header'), 
    0)

if (Mobile.verifyElementExist(findTestObject('Beneficiary Management/Beneficiary/Delete Beneficiary - Within City Bank/Delete Beneficiary - Nickname'), 
    0, FailureHandling.OPTIONAL)) {
    'Click Select Nickname to Choose Option'
    Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Delete Beneficiary - Within City Bank/Delete Beneficiary - Select Nickname PopUp'), 
        0)

    Mobile.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    'Selct 1st Name from the list with X, Y Coordinates'
    Mobile.tapAtPosition(GlobalVariable.position_X, GlobalVariable.position_Y)

    'Manual Check Option Selected'
    Mobile.takeScreenshot()
}

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Delete Beneficiary - Within City Bank/Delete Beneficiary - Next Button'), 
    0)

Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Delete Beneficiary - Within City Bank/Delete Beneficiary - Delete Button'), 
    0)

