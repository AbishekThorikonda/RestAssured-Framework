package Utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		log.info("Test has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test is successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		log.info("Test has Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	

}
