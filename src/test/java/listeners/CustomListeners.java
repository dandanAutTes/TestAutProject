package listeners;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import interactions.elements.Pages.BasicSetup;
import interactions.elements.Pages.Utils;
import mail.MonitoringMail;
import mail.SendReport;
import mail.SendReport1;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class CustomListeners extends BasicSetup implements ITestListener,ISuiteListener {

	static String fileName = "Extend_SalesForce";
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter(".\\target\\surefire-reports\\html\\"+ fileName);
	ExtentTest test;
	public 	String messageBody;


	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

		try {
			spark.loadXMLConfig(".\\src\\test\\java\\listeners\\Spark.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		extent.attachReporter(spark);
		log.info("OnStart");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	
		
	}

	public void onTestFailure(ITestResult arg0) {
		

		try {

			Utils.takeScreenshot1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FAILURE");

		test.log(Status.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.fail("Picture from failure",  MediaEntityBuilder.createScreenCaptureFromPath(Utils.screenshotName).build());
		test.fail("FAIL");
		extent.flush();
		log.error("OnFailure");
	}

	public void onTestSkipped(ITestResult arg0) {

		System.out.println("SKIP");
		test.log(Status.SKIP,"Skipped the test " + arg0.getMethod().getMethodName());
		test.skip("SKIP");
		extent.flush();
		log.info("OnSkipped");
	}


	public void onTestStart(ITestResult arg0) {


		test = extent.createTest(arg0.getName().toUpperCase());
		System.out.println("START test");
		log.info("onTestStart");
		
	}

	public void onTestSuccess(ITestResult arg0) {


		test.log(Status.PASS,"Test is pass " + arg0.getMethod().getMethodName());
		test.pass("PASS");
		extent.flush();
		log.info("onTestSuccess");
	}

	public void onFinish(ISuite arg0) {

		extent.flush();
		System.out.println("DONE");
		log.info("onFinish");

		SendReport report = new SendReport();

		try {
		report.triggerMail("Extend_SalesForce.html", "//target//surefire-reports//html//Extend_SalesForce.html");
		} catch (AddressException e) {

			e.printStackTrace();
		} catch (MessagingException | IOException e) {

			e.printStackTrace();
		}
	}



}

