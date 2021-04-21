package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reports.Extendreports;

public class Customizedlistners extends Extendreports implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed and Details are.."+result.getName());
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed and Details are.."+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed and Details are.."+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed and Details are.."+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed and Details are.."+result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed and Details are.."+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test case is Failed and Details are.."+result.getName());
	}

}
