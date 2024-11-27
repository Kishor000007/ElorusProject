package myListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import generic.basetest;

public class elorusListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String failedScriptName = result.getMethod().getMethodName();
		basetest.actionUtil.captureScreenShot(failedScriptName);
		
	}
}
