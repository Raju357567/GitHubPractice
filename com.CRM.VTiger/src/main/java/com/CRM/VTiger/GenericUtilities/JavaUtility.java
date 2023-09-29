package com.CRM.VTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is help us to generate random numbers
	 * 
	 * @return
	 */

	public int getRandom() {
		Random r = new Random();
		return r.nextInt(1000);
	}

	public String sysDateAndTime() {
		Date dt = new Date();
		String currentDate = dt.toString();
		return currentDate;
	}

	/**
	 * This method is help us to modify the date and time format.
	 **/
	public String modifiedDate() {
		Date dt = new Date();
		String[] cell = dt.toString().split(" ");
		String time = cell[3].replace(":", "-");
		String date = cell[2];
		String month = cell[1];
		String year = cell[5];
		String currentDate = time + " " + date + " " + month + " " + year;
		return currentDate;

	}

}
