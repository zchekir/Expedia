package Zak;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

	@Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("The name of the testcase failed is :"+Result.getName());					
    }	
	
	
	@Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());					
    }		
	
}
