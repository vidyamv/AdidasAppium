package com.adidas.pages;

import org.hamcrest.Matchers;

import com.adidas.bean.ProdBean;
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

public class AdidasSearchProductlistTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "img.adidasbomberjacket")
	private QAFWebElement imgAdidasbomberjacket;
	@FindBy(locator = "btn.adidasbuy")
	private QAFWebElement btnAdidasbuy;
	@FindBy(locator = "iptxt.adidasSize")
	private QAFWebElement iptxtAdidasSize;
	@FindBy(locator = "txt.adidasSizeSelection")
	private QAFWebElement txtAdidasSizeSelection;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getImgAdidasbomberjacket() {
		return imgAdidasbomberjacket;
	}

	public QAFWebElement getBtnAdidasbuy() {
		return btnAdidasbuy;
	}

	public QAFWebElement getIptxtAdidasSize() {
		return iptxtAdidasSize;
	}

	public QAFWebElement getTxtAdidasSizeSelection() {
		return txtAdidasSizeSelection;
	}
	
	
	
	@QAFTestStep(description = "user should see the selected product details")
	public void verifyProductDetails()
	{
		ProdBean bean = (ProdBean)ConfigurationManager.getBundle().getProperty("bean.info");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+bean.getProdName());
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+bean.getProdPrice());
		Validator.verifyThat(bean.getProdName(), Matchers.containsString("EQT BASKETBALL ADV SHOES"));
		Validator.verifyThat(bean.getProdPrice(), Matchers.containsString("$120.00"));
		
	
	}
/*	
public void selectTheSizeOfTheProduct(String size) {
		
		QAFExtendedWebElement ele = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("sizechart.addidas"), size));
		ele.waitForPresent();
		ele.click();
}*/
	
	@QAFTestStep(description = "click on buy button")
	public void clickOnBuyButton() {
		getBtnAdidasbuy().waitForPresent();
		getBtnAdidasbuy().click();
	}
     /*@QAFTestStep(description = "click on size selection icon")
	public void clickOnSizeSelectionIcon() {
		getIptxtAdidasSize().click();
	}*/
	@QAFTestStep(description = "select the size of the product as{0}")
	public void selectTheSizeOfTheProductAs(String size) {
		
		QAFExtendedWebElement ele = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("sizechart.addidas"), size));
		ele.waitForPresent();
		ele.click();
		//getTxtAdidasSizeSelection().click();
		
	}
	

}
