package ty.crm.genricutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplimation implements ITestListener {

	@Override // beforetest
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override // afterm
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			new WebDriverUtility().screenShot(BaseClass.sdriver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override // am
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override // am
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override // bt
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
