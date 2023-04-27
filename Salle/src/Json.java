import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Json {
	protected ArrayList<Plat> CLesEntrees;
	
	
public Json(ArrayList e) {
	this.CLesEntrees = e;
}

public void genererJson() {
	JSONObject jsonObj = new JSONObject();
	JSONArray Array = new JSONArray();
	
	for(Plat p : CLesEntrees) {
		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("id", p.getId());
		jsonObj2.put("qtt", p.getQtt());
		Array.add(jsonObj2);
}
	jsonObj.put("Startres", Array);	

	FileWriter file;
	try {
		file = new FileWriter("D:\\users\\Thérèse\\Downloads\\nom"+".jason");
		file.write(jsonObj.toJSONString());
		file.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		

}}