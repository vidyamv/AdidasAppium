package com.adidas.pages;

import java.util.List;

import org.testng.Reporter;

import com.adidas.bean.ProdBean;
import com.adidas.component.SearchProductComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.thoughtworks.selenium.webdriven.commands.GetSelectOptions;

public class Searchproducts extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(locator = "prod.lists")
	private List<SearchProductComponent> prodLists;
	@FindBy(locator = "prod.name")
	private QAFWebElement prodName;
	@FindBy(locator = "prod.price")
	private  QAFWebElement prodPrice;
	
	public List<SearchProductComponent> getProdLists() {
		return prodLists;
	}
	
	public void verfiyingSearchProducts() {
	
		/*for(SearchProductComponent comp: getProdLists()) {
			System.out.println(comp.getProdName().getText());
			System.out.println(comp.getProdPrice().getText());
		}*/

	        
	}
	
	
	public void selectProByIndex(int index)
	{
		ProdBean bean= new ProdBean();
		bean.setProdName(getProdLists().get(index).getProdName().getText());
		bean.setProdPrice(getProdLists().get(index).getProdPrice().getText());
		ConfigurationManager.getBundle().setProperty("bean.info", bean);
		getProdLists().get(index).click();
	}
	
	
	@QAFTestStep(description = "select the {0} from productlist")
	public void selectTheProductFromProductlist(String index) {
		 int i=Integer.parseInt(index);
		getProdLists().get(i).getProdName().waitForPresent();
		ProdBean bean= new ProdBean();
		bean.setProdName(getProdLists().get(i).getProdName().getText());
		bean.setProdPrice(getProdLists().get(i).getProdPrice().getText());
		ConfigurationManager.getBundle().setProperty("bean.info", bean);
		getProdLists().get(i).getProdName().click();
	}

	}
	


