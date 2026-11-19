package Files;

import io.restassured.path.json.JsonPath;

public class ResuableMethods {

	public static JsonPath rawtoJason(String response) {
		JsonPath js1=new JsonPath(response);
		return js1;
		// TODO Auto-generated method stub

	}

}
