package testNG_Scripts;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com> */

import static org.testng.Assert.assertFalse;

import java.io.FileNotFoundException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Screens;

public class about_TestNG {

	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	
	@BeforeMethod 
	public void preConditions() {
		pc = new PC_App_Initialize(new Screen());
		psr = new PC_App_Screens(new Screen());
		em = new ExcelManipulation();
		grid = new PC_App_PicGrid(new Screen());
		scr = new PC_App_Screens(new Screen());
		pc.appLaunch();
	}
	@Test
	/* Test Script - Verify user is navigated to About us screen when clicked on the About Us tab */
    public void PCApp_TestCase_006_A01() throws FileNotFoundException {
	    try {
			psr.aboutTab();
			em.writeDataToExcel("PCApplication_TestCases", 33, 2, "PASS");
		}catch(Exception e) {
			assertFalse(true);
			em.writeDataToExcel("PCApplication_TestCases", 33, 2, "FAIL");
			pc.appForceQuit();
			e.printStackTrace();
		}
	  }
	
	@Test
	/*Test Script - Verify user is able to navigate to Profile tab from About us tab*/
	public void PCApp_TestCase_006_A02() throws FileNotFoundException {
		try {
			psr.profileTab();
			em.writeDataToExcel("PCApplication_TestCases", 34, 2, "PASS");
		}catch (Exception e) {
			assertFalse(true);
			em.writeDataToExcel("PCApplication_TestCases", 34, 2, "FAIL");
			pc.appForceQuit();
			e.printStackTrace();
		}
	}
	
	@Test
	/*Test Script - Verify user is able to navigate to Port Settings tab from About us tab*/
	public void PCApp_TestCase_006_A03() throws FileNotFoundException {
		try {
			psr.aboutTab();
			psr.portSettingsTab();	
			em.writeDataToExcel("PCApplication_TestCases", 35, 2, "PASS");
		}catch(Exception e) {
			assertFalse(true);
			em.writeDataToExcel("PCApplication_TestCases", 35, 2, "FAIL");
			pc.appForceQuit();
			e.printStackTrace();
		}
	}
	
	@Test
	/* Test Script - Verify by default the Pic Grid is in disabled state when user navigates to About Us tab */
	public void PCApp_TestCase_006_A04() {
		try {
			scr.aboutTab();
			
			if(grid.imageGridState()==null) {
				System.out.println("Pic grid is not active");
				em.writeDataToExcel("PCApplication_TestCases", 36, 2, "PASS");
			}else {
				assertFalse(true);
				em.writeDataToExcel("PCApplication_TestCases", 36, 2, "FAIL");
				System.err.println("Pic grid is active");
				pc.appForceQuit();
			}
		}catch(Exception e) {
			assertFalse(true);
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void postConditions() throws FindFailed {
		pc.appQuit();
	}
}
