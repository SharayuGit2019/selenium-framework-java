package com.selenium_framework.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import sun.security.action.GetLongAction;

@Listeners(FrameworkListeners.class)
public class AbstractSelenium 
{
	/*@BeforeTest
	public void callCreateWebDriverInstanceMethod()
	{
		WebDriverFactory.createWebDriverInstance();
	}*/
	


	@DataProvider(name="LoginData",parallel=true) //r2 
	public String [][] getData() //r1  2d array ret
	{
		System.out.println("I am in Plain login data");
		String myData[][] = { { "admin", "admin" }, { "Maithili Ashok Raut", "sraut12345" }, { "Amit", "Amit" } };
		return myData;

	}
	
	@DataProvider(name = "ExcelData", parallel=true)
	public String[][] getExcelData(Method m) throws Exception 
	{ 
		                                                         
        System.out.println("*****************Running method name is - "+m.getName());
		Class<?> cls =m.getDeclaringClass();
		return ExcelReader.getExcelTableArray(getFilePath(cls),	m.getName());

	}

	@DataProvider(name = "CSVData")
	public String[][] getCSVData() {
		File file = new File("C:\\Users\\Maithili\\Desktop\\LoginData.txt");
		String[][] myData = new String[3][2];

		try {
			FileReader fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);
			String line = "";

			int i = 0;
			while ((line = br.readLine()) != null) {
				myData[i] = line.split(",");
				i = i + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myData;
	}
	
	private static String getFilePath(Class<?> cls){
		System.out.println("******** getFilePath for class "+cls.getName());
		String strSourceClassName = cls.getResource(cls.getSimpleName()+".class").getPath();
		System.out.println("*************** resource path is "+strSourceClassName);
		try 
		{
			strSourceClassName = URLDecoder.decode(strSourceClassName,"UTF-8");
		} 
		    catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		StringBuffer strFilePath = new StringBuffer();
		strFilePath.append(strSourceClassName.subSequence(1, strSourceClassName.indexOf("com")));
		strFilePath.append(cls.getName().replace(".","/"));
		strFilePath.append(".xlsx");
		System.out.println("Class path is - "+strFilePath);
		return strSourceClassName.replace(".class", ".xlsx");
	}

}
