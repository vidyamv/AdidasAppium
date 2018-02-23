package com.adidas.pages;

import org.hamcrest.Matchers;

import com.adidas.bean.ProdBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class AdidasaddtocartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "icon.addidas.addtocart")
	private QAFWebElement iconAddidasAddtocart;
	@FindBy(locator = "option.addidas.addtocart")
	private QAFWebElement optionAddidasAddtocart;
	@FindBy(locator = "txt.addidas.addtocartitems")
	private QAFWebElement txtAddidasAddtocartitems;
	@FindBy(locator = "icon.add.to.cart.container")
	private QAFWebElement iconAddToCartContainer;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getIconAddidasAddtocart() {
		return iconAddidasAddtocart;
	}

	public QAFWebElement getOptionAddidasAddtocart() {
		return optionAddidasAddtocart;
	}

	public QAFWebElement getTxtAddidasAddtocartitems() {
		return txtAddidasAddtocartitems;
		
	}
	public QAFWebElement getIconAddToCartContainer() {
		return iconAddToCartContainer;
	}
	@QAFTestStep(description = "click on Add to cart bag")
	public void clickOnAddToCartBag() {
		if (getOptionAddidasAddtocart().isEnabled())
			getOptionAddidasAddtocart().click();
	}

	@QAFTestStep(description = "click on add to cart icon")
	public void clickOnAddToCartIcon() {
		getIconAddidasAddtocart().click();
	}
	@QAFTestStep(description = "verify that searchprod is added to cart")
	public void verifyThatSearchprodIsAddedToCart() {
		getIconAddToCartContainer().click();

		ProdBean bean =(ProdBean) ConfigurationManager.getBundle().getProperty("bean.info");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + bean.getProdName());
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + bean.getProdPrice());
		Validator.verifyThat(bean.getProdName(),
				Matchers.containsString("EQT BASKETBALL ADV SHOES"));
		Validator.verifyThat(bean.getProdPrice(), Matchers.containsString("$120.00"));
	}

	

}
