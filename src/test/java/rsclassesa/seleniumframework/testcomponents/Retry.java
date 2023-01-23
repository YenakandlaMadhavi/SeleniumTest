package rsclassesa.seleniumframework.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int count=0;
	int retrymax=2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retrymax) {
			count++;
			return true;
		}
		
		return false;
	}

}
