package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// This will gives All the details of data // Reusable componenets
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx"; // gives the current project location //System.getProperty("user.dir")
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1"); 
		int colcount=xl.getCellCount("Sheet1", 1); // sheet anme and row no
		
		String apidata[][]=new String [rownum][colcount];  // 2d array
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0; j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata; // data from excel sheet stored in string type 2d array
	}
	
	
	// This will gives only User Names of the users
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx"; // gives the current project location //System.getProperty("user.dir")
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		
		return apidata;
	}
	
}
