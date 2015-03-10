package sbna;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class OutputData {
	WebDriver driver = new FirefoxDriver();
	FileInputStream fi = new FileInputStream("D:\\Selinium\\Untitled 2.xls");
	Workbook W = Workbook.getWorkbook(fi);
	Sheet s;
	s = W.getSheet(0);
	   
	   String Username = s.getCell(0,1).getContents();
	   String password= s.getCell(1, 1).getContents();
	   String newpassword=s.getCell(2,1).getContents();


 public void Login() throws InterruptedException, BiffException, IOException
	 {
	 		
		

		   for(int row = 1;row < s.getRows();row++)
		   {
		       //String Username = s.getCell(0,row).getContents();
		       System.out.println(Username);
		       driver.get("http://10.5.103.181:8080/login");
		       driver.findElement(By.id("userName")).sendKeys(Username);

		      // String password= s.getCell(1, row).getContents();
		       System.out.println("Password "+password);

		       driver.findElement(By.id("password")).sendKeys(password);

		       driver.findElement(By.name("Log In")).click(); 
		       Thread.sleep(5000);
		       
		   }
		}
 
 public void logout()
 {
	driver.findElement(By.cssSelector("a.sprite-img.stng-btn")).click(); 
 }
 
 public void Chagepassword()
 {
	driver.findElement(By.cssSelector("a.sprite-img.prfl-btn")).click();
	driver.findElement(By.id("old-password")).sendKeys(password);
	driver.findElement(By.id("new-password")).sendKeys(newpassword);
	driver.findElement(By.id("re-new-password")).sendKeys(newpassword);
	driver.findElement(By.name("recover")).click();
	 
	 
	 
	 
 }
 public static void main(String[] args) throws BiffException, InterruptedException, IOException {
		OutputData dt = new OutputData();
		//Login to the application
		dt.Login();
		 
		//Change Password
		 
		 
		 
		//Logout
		dt.logout();
	}
}
