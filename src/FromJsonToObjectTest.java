import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author user
 */
public class FromJsonToObjectTest
{

	/**
	 * @param args
	 *            the command line arguments
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args)
			throws MalformedURLException, IOException
	{
		// TODO code application logic here
		new FromJsonToObjectTest();
	}

	public FromJsonToObjectTest() 
			throws MalformedURLException, IOException
	{
		String r = readToString("ip.txt");

		// Parse JSON directly (into JsonElement)
		JsonParser parser = new JsonParser();
		System.out.println(parser.parse(r));
		JsonObject obj = (JsonObject) parser.parse(r);
//		JsonElement ip = obj.get("ip");
//		System.out.println( (obj.get("ip") + ":" + obj.get("port")).replace("\"", "")); // Prints "10001"
		
		ResourceUri uri = new Gson().fromJson(obj, ResourceUri.class);
		
		AddressBean address;
		String url = uri.toString();//"http://10.0.0.4:8080/addressbook/rest/addresses/getAddresses";
		System.out.println("url=" + url + "\n");
		InputStreamReader jsonReader = new InputStreamReader( new URL(url).openStream() );
		List<AddressBean> addresses = new Gson().fromJson(jsonReader, new TypeToken<List<AddressBean>>(){}.getType());
		
		jsonReader.close();
		
		// String strJson =
		// "[{\"addressid\":\"8\",\"firstname\":\"Sue\",\"lastname\":\"Black\",\"street\":\"1000 Michigan Ave.\",\"city\":\"Chicago\",\"state\":\"IL\",\"zip\":\"60605\"},{\"addressid\":\"7\",\"firstname\":\"James\",\"lastname\":\"Blue\",\"street\":\"1000 Harbor Ave.\",\"city\":\"Seattle\",\"state\":\"WA\",\"zip\":\"98116\"},{\"addressid\":\"3\",\"firstname\":\"Mike\",\"lastname\":\"Brown\",\"street\":\"3600 Delmar Blvd.\",\"city\":\"St. Louis\",\"state\":\"MO\",\"zip\":\"63108\"},{\"addressid\":\"6\",\"firstname\":\"Meg\",\"lastname\":\"Gold\",\"street\":\"1200 Stout St.\",\"city\":\"Denver\",\"state\":\"CO\",\"zip\":\"80204\"},{\"addressid\":\"5\",\"firstname\":\"John\",\"lastname\":\"Gray\",\"street\":\"500 South St.\",\"city\":\"Philadelphia\",\"state\":\"PA\",\"zip\":\"19147\"},{\"addressid\":\"1\",\"firstname\":\"Bob\",\"lastname\":\"Green\",\"street\":\"5 Bay St.\",\"city\":\"San Francisco\",\"state\":\"CA\",\"zip\":\"94133\"},{\"addressid\":\"4\",\"firstname\":\"Mary\",\"lastname\":\"Green\",\"street\":\"300 Massachusetts Ave.\",\"city\":\"Boston\",\"state\":\"MA\",\"zip\":\"02115\"},{\"addressid\":\"2\",\"firstname\":\"Liz\",\"lastname\":\"White\",\"street\":\"100 5th Ave.\",\"city\":\"New York\",\"state\":\"NY\",\"zip\":\"10011\"}]";
		// List<AddressBean> addresses = new Gson().fromJson(strJson, new
		// TypeToken<List<AddressBean>>(){}.getType());

		for (int i = 0; i < addresses.size(); i++) {
			address = addresses.get(i);
			System.out.println(i + ":\n" + address
					+ "\n---------------------------");
		}
	}
	
	public static String readToString(String path)
	{
        File f = new File(path);
        try{
            String r = FileUtils.readFileToString(f, "UTF-8");
            return r;
        }
        catch (IOException e){
             e.printStackTrace();
             return null;
        }
    }
}
