import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;


public class JSONManipulate {

	public static void main(String[] args) {
	
	try {
	
		JSONObject jsonObject =  parseJSONFile("file.json");		
	
		System.out.println(getData(jsonObject,"John", 30, "Delhi", "46th lane"));
		
		
	} catch (JSONException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);
    }

	private static String getData(JSONObject jsonObject, String name, int age, String street, String line) throws JSONException {
	    
	    JSONObject address = (JSONObject) jsonObject.get("address");
	    jsonObject.put("name", name);
	    jsonObject.put("age", age);
	    address.put("street", street);
	    address.put("line", line);
	    return jsonObject.toString();
	}
}
