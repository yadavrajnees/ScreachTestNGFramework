package org.cressanda.IFM.Login.Page;

import org.cressanda.IFM.Login.OR.LoginOR;
import org.cressanda.IFM.WebUtils.Uti;

public class LoginPage extends LoginOR{

	private Uti wt;
	public LoginPage(Uti util) {
		super(util);
		this.wt=util;
	}
	
	public void doLogin() {
		wt.sendKeys(getUserNameTxt(), wt.getPropertyData("UserName"));
		wt.sendKeys(getUserPasswordTxt(), wt.getPropertyData("UserPassword"));
		wt.click(getLoginBT());
	}
}
