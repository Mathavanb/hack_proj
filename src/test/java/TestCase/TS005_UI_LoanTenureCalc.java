package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.UIpage;

public class TS005_UI_LoanTenureCalc extends DriverSetup {

	private boolean testPassed = true;

	@Test(priority =1 ,groups = {"smoke"})
	public void validate_EMICalPage() throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		UIpage Ui = new UIpage(driver);
 
	    logger.info("TS003_Navigating to the EMI Calculator page.");
	    Ui.navigatorForEMICalc();  // Navigate to EMI Calculator page
	    logger.info("TS003_Navigated to the EMI Calculator page.");
	    
	    String pageTitle = driver.getTitle();
	    
	    if(pageTitle.equals(p.getProperty("EMICalculatorPage"))) {
	    	logger.info("Smoke Test Successfully Verified - EMI Calculator Page");
	    }
	    else {
	    	logger.error("Smoke Test Failed - EMI Calculator Page");
	    	Assert.fail();
	    }
	    
	}

	@Test(priority = 2, groups = {"regression"})
	public void user_validate_Loan_Tenure_Calculator_functionality() {
	    try {
	    	logger.info("UI_LoanTenure_Calculation");
		    UIpage UI = new UIpage(driver);
		    logger.info("01.Navigating to the Loan Tenure Calculator page.");
		    UI.navigatorForLoanTenureCalc();
		    logger.info("02.Navigated to the Loan Tenure Calculator page.");

		    logger.info("03.Validating displayed elements of Loan Tenure Calculator.");
		    SoftAssert softAssert = new SoftAssert();
		    softAssert.assertTrue(UI.getLoanAmtTextBox().isDisplayed(), "Loan Amount Text Box is not visible");
		    softAssert.assertTrue(UI.getLoanAmtSlider().isDisplayed(), "Loan Amount Slider is not visible");
		    softAssert.assertTrue(UI.getEMITextBox().isDisplayed(), "EMI Text Box is not visible");
		    softAssert.assertTrue(UI.getEMISlider().isDisplayed(), "EMI Slider is not visible");
		    softAssert.assertTrue(UI.getIntRateTextBox().isDisplayed(), "Interest Rate Text Box is not visible");
		    softAssert.assertTrue(UI.getIntRateSlider().isDisplayed(), "Interest Rate Slider is not visible");
		    softAssert.assertTrue(UI.getFeesAndChargesTextBox().isDisplayed(), "Fees And Charges Text Box is not visible");
		    softAssert.assertTrue(UI.getFeesAndChargesSlider().isDisplayed(), "Fees And Charges Slider is not visible");
		    logger.info("04.All elements are displayed successfully in Loan Tenure Calculator page.");

		    logger.info("05.Validating enabled elements of Loan Tenure Calculator.");
		    softAssert.assertTrue(UI.getLoanAmtTextBox().isEnabled(), "Loan Amount Text Box is not enabled");
		    softAssert.assertTrue(UI.getLoanAmtSlider().isEnabled(), "Loan Amount Slider is not enabled");
		    softAssert.assertTrue(UI.getEMITextBox().isEnabled(), "EMI Text Box is not enabled");
		    softAssert.assertTrue(UI.getEMISlider().isEnabled(), "EMI Slider is not enabled");
		    softAssert.assertTrue(UI.getIntRateTextBox().isEnabled(), "Interest Rate Text Box is not enabled");
		    softAssert.assertTrue(UI.getIntRateSlider().isEnabled(), "Interest Rate Slider is not enabled");
		    softAssert.assertTrue(UI.getFeesAndChargesTextBox().isEnabled(), "Fees And Charges Text Box is not enabled");
		    softAssert.assertTrue(UI.getFeesAndChargesSlider().isEnabled(), "Fees And Charges Slider is not enabled");
		    logger.info("06.All elements are enabled successfully in Loan Tenure Calculator page.");

		    logger.info("07.Testing scale change for Loan Amount in Loan Tenure Calculator page.");
		    UI.moveLoanAmtSlider(0);
		    UI.moveLoanAmtSlider(130);
		    softAssert.assertEquals(UI.getLoanAmtTextBoxValue(), "60,00,000", "Scale change for Loan Amount did not match.");
		    logger.info("08.Scale change for Loan Amount validated successfully.");

		    logger.info("09.Testing scale change for Interest Rate in Loan Tenure Calculator page.");
		    UI.moveIntRateSlider(0);
		    UI.moveIntRateSlider(112);
		    softAssert.assertEquals(UI.getIntRateTextBoxValue(), "15", "Scale change for Interest Rate did not match.");
		    logger.info("10.Scale change for Interest Rate validated successfully in Loan Tenure Calculator page.");

		    logger.info("11.Testing scale change for Fees and Charges in Loan Tenure Calculator page.");
		    UI.moveFeesAndChargesSlider(0);
		    UI.moveFeesAndChargesSlider(97);
		    softAssert.assertEquals(UI.getFeesAndChargesTextBoxValue(), "28,500", "Scale change for Fees and Charges did not match.");
		    logger.info("12.Scale change for Fees and Charges validated successfully in Loan Tenure Calculator page.");

		    softAssert.assertAll();
		    logger.info("13.Loan Tenure UI check validation is successful.");
		}catch (AssertionError e) {
	        logger.error("TS005_Loan Tenure UI check validation failed: " + e.getMessage());
	        throw e;  // Re-throw the exception to ensure the test fails
	    }
	    }
 }
