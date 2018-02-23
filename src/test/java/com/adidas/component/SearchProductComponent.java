package com.adidas.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SearchProductComponent extends QAFWebComponent {
	
	public SearchProductComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "prod.name")
	private QAFWebElement prodName;
	@FindBy(locator = "prod.price")
	private QAFWebElement prodPrice;
	

	

	

	public QAFWebElement getProdName() {
		return prodName;
	}

	public QAFWebElement getProdPrice() {
		return prodPrice;
	}

	
	

}
