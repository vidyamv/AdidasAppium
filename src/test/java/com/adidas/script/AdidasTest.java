package com.adidas.script;

import org.testng.annotations.Test;

import com.adidas.pages.AdidasSearchProductlistTestPage;
import com.adidas.pages.AdidasaddtocartTestPage;
import com.adidas.pages.AdidashomeTestPage;

import com.adidas.pages.AgeorGenderfilterTestPage;
import com.adidas.pages.Searchproducts;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class AdidasTest extends WebDriverBaseTestPage<WebDriverTestPage>
{
	@Test
	public void testAdidas() throws InterruptedException {
		
		AdidashomeTestPage ap=new AdidashomeTestPage();
		Searchproducts sc=new Searchproducts();
		AdidasSearchProductlistTestPage aj=new  AdidasSearchProductlistTestPage();
		AdidasaddtocartTestPage ac=new AdidasaddtocartTestPage();
		ap.verifyHomePage();
		ap.getSearchiconAdidas().click();
		AgeorGenderfilterTestPage age= new AgeorGenderfilterTestPage();
		age.verifySearchPage();
		age.searchProductByAgeGender("MEN");
		age.searchProductByPurpose("Originals");
        sc.verfiyingSearchProducts();
		sc.selectProByIndex(1);
		Thread.sleep(5000);
		aj.getBtnAdidasbuy().click();
		aj.getIptxtAdidasSize().click();
		aj.getTxtAdidasSizeSelection();
		Thread.sleep(5000);
		ac.getOptionAddidasAddtocart().click();
		
		Thread.sleep(5000);
		/*//aj.getImgAdidasbomberjacket().click();
		aj.getBtnAdidasbuy().click();
		aj.getIptxtAdidasSize().click();
		aj.getTxtAdidasSizeSelection();
		ac.getOptionAddidasAddtocart();*/
		
		
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
