package com.adidas.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class AdidashomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "icon.adidas")
	private QAFWebElement iconAdidas;
	@FindBy(locator = "searchicon.adidas")
	private QAFWebElement searchiconAdidas;
	@FindBy(locator = "profileicon.adidas")
	private QAFWebElement profileiconAdidas;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getIconAdidas() {
		return iconAdidas;
	}

	public QAFWebElement getSearchiconAdidas() {
		return searchiconAdidas;
	}

	public QAFWebElement getProfileiconAdidas() {
		return profileiconAdidas;
	}
	@QAFTestStep(description = "User is on homepage")
	public void verifyHomePage()
	{
		searchiconAdidas.waitForPresent();
		Validator.verifyThat((searchiconAdidas.isDisplayed()&&searchiconAdidas.isEnabled()), Matchers.equalTo(true));
	}
	@QAFTestStep(description = "click on search icon")
	public void clickSearchIcon()
	{
		
		searchiconAdidas.click();
	}

}
