import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js=new JsonPath(Payload.CoursePrice());
		
        //Print no of courses returned by API		
		int count=js.getInt("courses.size()");
		System.out.println(count);

		//Print purchase amount
        int PurchaseAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println(PurchaseAmount);
        
        //Print Title of the first course
        String FirstCourse=js.get("courses[0].title");
        System.out.println(FirstCourse);
        
        //Print all course titles and their respective Prices
        for(int i=0;i<count;i++)
        {	
        System.out.println(js.get("courses["+i+"].title").toString());
        System.out.println(js.get("courses["+i+"].price").toString());      
        }
        
        //Print no of copies sold by RPA course
        for(int i=0;i<count;i++)
        {
        	String Titlename=js.get("courses["+i+"].title");
        	if(Titlename.equalsIgnoreCase("RPA"));
            System.out.println("No of copies sold by RPA");
        	System.out.println(js.get("courses["+i+"].copies").toString());
        	break;
        }
        
        
        
	}

}
