package com.example.fw;

import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
   private static ApplicationManager singelton;
   private WebDriverHelper webDriverHelper;
   private HibernateHelper hibernateHelper;
   private Properties props;
   
   public String baseUrl; 
   
   public static ApplicationManager getInstance(Properties props) throws IOException {
		if (singelton ==null){
			singelton=new ApplicationManager();
		}
		return singelton;
	}
   
   
//   public ApplicationManager (Properties properties) {
//	 this.props = properties;
//	
//   }
 
	public void stop() {
		if (webDriverHelper != null) {
			webDriverHelper.stop(); 
		}		   
	}
	
	public WebDriverHelper getWebDriverHelper()  {
		if (webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper(this); 
		}	
	return webDriverHelper;
	}
	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this); 
		}
	return hibernateHelper;		
	}
	
	public String getProperty (String key){
		return props.getProperty(key);
	}
		
	public void setProperties (Properties props){
		 this.props = props;
	}
//	
//	public WebDriver getDriver() {
//		String browser = properties.getProperty("browser");
//		if (driver == null) {
//			 if ("firefox".equals(browser)){
//				 driver = new FirefoxDriver(); 
//			 } else if ("ie".equals(browser)){
//				 driver = new InternetExplorerDriver();  
//			 } else if ("chrome".equals(browser)){
//		        driver = new ChromeDriver();
//			 } else {
//			 throw new Error ("Unsupported browser:"+ browser);
//			 }
//			 baseUrl = properties.getProperty("baseUrl");
//			 //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			 driver.get(baseUrl);
//		}
//	return driver;
//	}

	
}

