package com.adidas.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class AgeorGenderfilterTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "main.category.prodsearchpage")
	private QAFWebElement mainCategoryProdsearchpage;
	@FindBy(locator = "sub.category.searchpage")
	private QAFWebElement subCategorySearchpage;
	@FindBy(locator = "purpose.searchpage")
	private QAFWebElement purposeSearchpage;
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getMainCategoryProdsearchpage() {
		return mainCategoryProdsearchpage;
	}

	public QAFWebElement getSubCategorySearchpage() {
		return subCategorySearchpage;
	}
	public QAFWebElement getPurposeSearchpage() {
		return purposeSearchpage;
	}
	
	public void verifySearchPage()
	{
		Validator.verifyThat(((mainCategoryProdsearchpage.isDisplayed())&&(mainCategoryProdsearchpage.isPresent())), Matchers.equalTo(true));
	}
	@QAFTestStep(description = "searchproduct by gender as a {0}")
	public void searchProductByAgeGender(String prodBy)
	{
		mainCategoryProdsearchpage.click();
		QAFExtendedWebElement ele= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("sub.category.searchpage"), prodBy));
		ele.waitForPresent();
		ele.click();
	}
	
	
	
	
	@QAFTestStep(description = "searchproduct by purpose as a {0}")
	public void searchProductByPurpose(String purpose)
	{
		//getPurposeSearchpage().waitForVisible();
		 QAFExtendedWebElement ele = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("purpose.searchpage"), purpose));
		ele.waitForPresent();
		ele.click();
	}

}
