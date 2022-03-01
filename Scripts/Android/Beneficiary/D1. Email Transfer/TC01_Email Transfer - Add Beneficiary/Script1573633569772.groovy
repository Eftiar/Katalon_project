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

'User select Email Transfer'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Email Transfer - Popup Btn'), 0)

'User Tap Next Button'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Next - Btn'), 0)

'User Input Nickname Borhan'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Email Transfer/Email Transfer- Enter Beneficiary Name Here'), 
    Nickname, 0)

'User Input email address "borhan@bs-23.net"'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Email Transfer/Email Transfer - Enter Beneficiary Email Here'), 
    EmailId, 0)

'User Input Mobile Number "01745677420"'
Mobile.setText(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Email Transfer/Email Transfer - Enter Beneficiary Mobile Number'), 
    MobileNumber, 0)

'User Tap Next Button to add Beneficiary'
Mobile.tap(findTestObject('Beneficiary Management/Beneficiary/Add Beneficiary - Email Transfer/Email Transfer - Add Beneficiary Button'), 
    0)

