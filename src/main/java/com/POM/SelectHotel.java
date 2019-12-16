package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClassV2;

public class SelectHotel extends BaseClassV2 {

	public SelectHotel(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getTableData() {
		return tableData;
	}

	public WebElement getTableHeader() {
		return tableHeader;
	}

	public WebElement getSelectData() {
		return selectData;
	}

	public WebElement getCancel() {
		return cancel;
	}

	@FindBy(xpath="//table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td")
	private WebElement tableData;
	
	@FindBy(xpath="//table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td")
	private WebElement tableHeader;
	
	@FindBy(xpath="//input[@id=\"radiobutton_0\"]")
	private WebElement selectData;
	
	@FindBy(id="cancel")
	private WebElement cancel;
	
}
