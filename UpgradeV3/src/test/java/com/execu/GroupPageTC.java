package com.execu;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.pack.BaseClass1;


public class GroupPageTC extends BaseClass1{
	
	@Test()
	public void createGroupWithCancelandAlertNo() throws InterruptedException {
		try {
			dashBoard.groupLeftSide();
			//createGroup.createGroupTab();
			createGroup.groupName("Content Added");
			createGroup.groupDescription("No more Value");
			createGroup.cancelButton();
			createGroup.confirmNoButton();

		} finally {
			dashBoard.groupLeftSide();
		}
	}

	@Test()
	public void createGroupWithCancelandAlertYes() throws InterruptedException {
		try {
		//	createGroup.createGroupTab();
			createGroup.groupName("No Group");
			createGroup.groupDescription("Checking");
			createGroup.cancelButton();
			createGroup.confirmYesButton();

		} finally {
			dashBoard.groupLeftSide();
		}
	}
	
	

}
