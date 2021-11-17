import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.Random;

public class webdriverdemo {
   public static void main(String[] args) {
   
	      WebDriver driver = new ChromeDriver();
      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
      
      //Launch website
      driver.navigate().to("https://www.calculator.net/percent-calculator.html");

      Random rand = new Random();
      
      
      //Maximize the browser
//      driver.manage().window().maximize();
      for(int i=0;i<10;i++) {

	      int num = rand.nextInt(10000);
	      int p= rand.nextInt(100)+1;
    	  
	      // Click on Math Calculators
	      driver.findElement(By.xpath("//*[@id=\"cpar1\"]")).click();
	      
	      // Click on Percent Calculators
	      driver.findElement(By.xpath("//*[@id=\"cpar2\"]")).click();
	      
	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys(Double.toString(p));
	      
	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys(Double.toString(num));
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr[2]/td/input[2]")).click();
	      
	      
	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();

	      System.out.print("Numero = ");
	      System.out.print(num);
	      System.out.print(" | Porcentaje = ");
	      System.out.print(p);		
	      System.out.print(" | Porcentaje = ");
	      System.out.println(p);		
	      
	      double f = Double.parseDouble(result);
	      		if(f != Double.valueOf(num)*Double.valueOf(p)/100.0) {
	      			System.out.print("Error");
	      			return;
	      		}
		  	      driver.findElement(By.xpath("//*[@id=\"cpar1\"]")).clear();
		  	      driver.findElement(By.xpath("//*[@id=\"cpar2\"]")).clear();
      }
      
      
      //Close the Browser.
      driver.close();
   }
}