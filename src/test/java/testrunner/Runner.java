package testrunner;

//import org.junit.runner.RunWith;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/*import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;*/
/*import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;*/


//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;*/

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="C:\\Users\\Ganesh\\eclipse-workspace\\Amazontest\\src\\main\\java\\features\\Login1.feature",
        glue= {"testrunner"},
        //plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
        		//plugin = {"pretty", "C:\\Users\\Ganesh\\eclipse-workspace\\Amazontest\\target\\cucumber\\report.html"},
        	//	plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
                )
public class Runner {
	
	

}
