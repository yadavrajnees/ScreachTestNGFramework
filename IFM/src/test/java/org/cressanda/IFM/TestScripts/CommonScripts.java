package org.cressanda.IFM.TestScripts;

import org.testng.annotations.Test;


public class CommonScripts {

	@Test(priority = 1,groups = {"Smoke"})
	public void commonScript() {
		System.out.println("Test");
	}
}
