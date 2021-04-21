package reports;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Extendreports {
	 
	public static void main(String[] args) {
		
	
	 ExtentHtmlReporter htmlreporter;
	 ExtentReports reporter;
	 ExtentTest test;
	
    try {

  
htmlreporter = new ExtentHtmlReporter(
System.getProperty("user.dir") + "\\Reports" + "\\extentReports.html");
htmlreporter.config().setDocumentTitle("Myntraecommerce_Reports");
htmlreporter.config().setTheme(Theme.DARK);
htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
reporter = new ExtentReports();
reporter.attachReporter(htmlreporter);
test = reporter.createTest("TestReport");
// HostName
reporter.setSystemInfo("Host_Name", InetAddress.getLocalHost().getHostName());
// HostAdDress
reporter.setSystemInfo("Host_Address", InetAddress.getLocalHost().getHostAddress());
// UserName
reporter.setSystemInfo("Username", System.getProperty("user.name"));
} 
catch (UnknownHostException e) {
e.printStackTrace();
}
}
}

