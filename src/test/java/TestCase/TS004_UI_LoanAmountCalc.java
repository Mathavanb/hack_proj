package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.UIpage;

public class TS004_UI_LoanAmountCalc extends DriverSetup {
    

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

	@Test(priority =2 ,groups = {"regression"})
	public void user_validate_Loan_Amount_Calculator_functionality() {
	    try {
	    	SoftAssert softAssert = new SoftAssert();
		    UIpage UI = new UIpage(driver);

		    logger.info("TS004_Navigating to the Loan Amount Calculator page.");
		    UI.navigatorForLoanAmountCalc();
		    logger.info("TS004_Navigated to the Loan Amount Calculator page.");

		    logger.info("TS004_Validating that all text boxes and sliders are displayed in Loan Amount Calculator Page.");
		    softAssert.assertTrue(UI.getEMITextBox().isDisplayed(), "EMI Text Box is not visible");
		    softAssert.assertTrue(UI.getIntRateTextBox().isDisplayed(), "Interest Rate Text Box is not visible");
		    softAssert.assertTrue(UI.getLoanTenureTextBox().isDisplayed(), "Loan Tenure Text Box is not visible");
		    softAssert.assertTrue(UI.getFeesAndChargesTextBox().isDisplayed(), "Fees And Charges Text Box is not visible");
		    softAssert.assertTrue(UI.getEMISlider().isDisplayed(), "EMI Slider is not visible");
		    softAssert.assertTrue(UI.getIntRateSlider().isDisplayed(), "Interest Rate Slider is not visible");
		    softAssert.assertTrue(UI.getLoanTenureSlider().isDisplayed(), "Loan Tenure Slider is not visible");
		    softAssert.assertTrue(UI.getFeesAndChargesSlider().isDisplayed(), "Fees And Charges Slider is not visible");
		    logger.info("TS004_All text boxes and sliders are displayed successfully in Loan Amount Calculator Page.");

		    logger.info("TS004_Validating that all text boxes and sliders are enabled in Loan Amount Calculator Page.");
		    softAssert.assertTrue(UI.getEMITextBox().isEnabled(), "EMI Text Box is not enabled");
		    softAssert.assertTrue(UI.getIntRateTextBox().isEnabled(), "Interest Rate Text Box is not enabled");
		    softAssert.assertTrue(UI.getLoanTenureTextBox().isEnabled(), "Loan Tenure Text Box is not enabled");
		    softAssert.assertTrue(UI.getFeesAndChargesTextBox().isEnabled(), "Fees And Charges Text Box is not enabled");
		    softAssert.assertTrue(UI.getEMISlider().isEnabled(), "EMI Slider is not enabled");
		    softAssert.assertTrue(UI.getIntRateSlider().isEnabled(), "Interest Rate Slider is not enabled");
		    softAssert.assertTrue(UI.getLoanTenureSlider().isEnabled(), "Loan Tenure Slider is not enabled");
		    softAssert.assertTrue(UI.getFeesAndChargesSlider().isEnabled(), "Fees And Charges Slider is not enabled");
		    logger.info("TS004_All text boxes and sliders are enabled successfully in Loan Amount Calculator Page.");

		    logger.info("TS004_Testing scale change for Interest Rate in Loan Amount Calculator Page.");
		    UI.moveIntRateSlider(0);  // Move slider to the initial position
		    UI.moveIntRateSlider(112);  // Move slider to a new value
		    softAssert.assertEquals(UI.getIntRateTextBoxValue(), "15", "Scale change for Interest Rate did not match.");

		    logger.info("TS004_Testing scale change for Loan Tenure in Loan Amount Calculator Page.");
		    UI.moveLoanTenureSlider(0);  // Move slider to the initial position
		    UI.moveLoanTenureSlider(105);  // Move slider to a new value
		    softAssert.assertEquals(UI.getLoanTenureTextBoxValue(), "11", "Scale change for Loan Tenure did not match.");

		    logger.info("TS004_Validating Year and Month option in Loan Amount Calculator Page.");
		    UI.clickYear();  // Click on the "Year" option
		    String yearVal = UI.getLoanTenureTextBoxValue();  // Get value in years
		    int yearValInInt = Integer.parseInt(yearVal);  // Convert the value to integer
		    UI.clickMonth();  // Click on the "Month" option
		    String monthVal = UI.getLoanTenureTextBoxValue();  // Get value in months
		    softAssert.assertEquals(monthVal, Integer.toString(yearValInInt * 12), "Year and Month option did not match.");

		    logger.info("TS004_Testing scale change for Fees and Charges in Loan Amount Calculator Page.");
		    UI.moveFeesAndChargesSlider(0);  // Move slider to the initial position
		    UI.moveFeesAndChargesSlider(97);  // Move slider to a new value
		    softAssert.assertEquals(UI.getFeesAndChargesTextBoxValue(), "28,500", "Scale change for Fees and Charges did not match.");

		    softAssert.assertAll();
		    logger.info("TS004_Loan Amount Calculator UI check validation completed.");
		}catch (AssertionError e) {
	        logger.error("TS004_Loan Amount Calculator UI check validation failed: " + e.getMessage());
	        throw e;  // Re-throw the exception to ensure the test fails
	    }
	  }

}
