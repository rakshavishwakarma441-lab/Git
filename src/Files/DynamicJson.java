package Files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJson {
	
	@Test(dataProvider="BookData")
	public void addBook(String isbn, String isle)
	{
	RestAssured.baseURI="http://216.10.245.166";
	String response=given().log().all().header("Content-Type","application/json").body(Payload.AddBook(isbn,isle))
	.when().post("Library/Addbook.php")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js=ResuableMethods.rawtoJason(response);
	String id=js.get("ID");
	System.out.println(id);
	
	}
	
    @DataProvider(name="BookData")
	
	public Object[][] getData()
	
	{
		return new Object[][] {{"Pra","12"},{"Rak","34"},{"Shiv","56"}};
		
	}

//Delete book code has to write	
 
}
	
