package rsclassesa.seleniumframework.abstractcomponets;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsTestNG {
	static ExtentReports extent;
	
	public static ExtentReports extendReportData() {
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Appication Results");
	reporter.config().setDocumentTitle("Test Results");
	
	 extent=new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Tester", "Madhavi");
	 return extent;
	
	}

}
