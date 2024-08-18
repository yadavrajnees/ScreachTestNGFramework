package org.cressanda.IFM.Login.OR;

import org.cressanda.IFM.WebUtils.Uti;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
@Getter
public class LoginOR {

	public LoginOR(Uti util) {
		PageFactory.initElements(util.getDriver(), this);
	}
	
	@FindBy(xpath="//input[@id='user_name']")
	private WebElement userNameTxt;
	
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement userPasswordTxt;
	
	@FindBy(xpath="//input[@id='Login']")
	private WebElement loginBT;
}
