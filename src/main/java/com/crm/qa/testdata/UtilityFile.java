package com.crm.qa.testdata;
//@author : Ankit Lohia
import java.util.ArrayList;

public class UtilityFile {

	static Xls_Reader_Naveen reader;
	
	public static ArrayList<Object[]> getdatafromExcel() {
		 
		
		ArrayList<Object[]> mydata= new ArrayList<Object[]>(); //Created an arraylist object to fetch and store values from excel file.
		try {
			reader = new Xls_Reader_Naveen("D:\\temp\\TestData.xlsx"); //Try/Catach block so if tomorrow sheet is unavialble.
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		   
		       int rowcount= reader.getRowCount("CRM"); //getrowcount of this sheet
		       
		       for(int i=2 ; i<=rowcount; i++) {
		    	String Firstname=  reader.getCellData("CRM", "fname", i);
		    	String Lastname=  reader.getCellData("CRM", "lastname", i);
		    	String Address  = reader.getCellData("CRM", "add", i);
		       String Email  =   reader.getCellData("CRM", "email", i);
		     
		     
		     //Add these above in object array
		       Object[] obj = {Firstname,Lastname, Address, Email };
		     
		     //now add in mydata
		       mydata.add(obj);
		     
		     
		       }
		    
		
		return mydata;

	}

}
