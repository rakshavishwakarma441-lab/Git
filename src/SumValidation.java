import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	

	@Test
	public void sumOfCourses()
	{
		
		
	int sum=0;
	JsonPath js=new JsonPath(Payload.CoursePrice());
	int count=js.getInt("courses.size()");
     for(int i=0;i<count;i++)
     {
    	 int Price=js.getInt("courses["+i+"].price");
    	 int Copies=js.getInt("courses["+i+"].copies");
    	 int amount= Price * Copies;
    	 System.out.println(amount);
    	 sum= sum+amount;
    	 
     }
	
	System.out.println("Sum of all course prices");
	System.out.println(sum);
	
	int purchaseamount= js.getInt("dashboard.purchaseAmount");
	Assert.assertEquals(purchaseamount, sum);

}
}
