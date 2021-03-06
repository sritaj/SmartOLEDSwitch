package about_testScripts;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Screens;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify by default the Pic Grid is in disabled state when user navigates to About Us tab */

public class PCApp_TestCase_006_A04 {

	public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Screens scr = new PC_App_Screens(new Screen());
		PC_App_PicGrid grid = new PC_App_PicGrid(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		
		try {
			scr.aboutTab();
			
			if(grid.imageGridState()==null) {
				System.out.println("Pic grid is not active");
				em.writeDataToExcel("PCApplication_TestCases", 41, 2, "PASS");
			}else {
				em.writeDataToExcel("PCApplication_TestCases", 41, 2, "FAIL");
				System.err.println("Pic grid is active");
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		pc.appQuit();
	}
}
