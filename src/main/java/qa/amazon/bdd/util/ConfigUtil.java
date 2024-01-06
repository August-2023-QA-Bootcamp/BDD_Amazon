package qa.amazon.bdd.util;

import java.io.IOException;
import java.util.Properties;

import qa.amazon.bdd.constant.FileName;
import qa.amazon.bdd.constant.Key;

public class ConfigUtil {

	private Properties properties;
	
	public ConfigUtil(FileName fileName) 
			//throws FileNotFoundException 
	{
//		if(fileName == null) {
//			throw new FileNotFoundException();
//		}
		initProperties(fileName.getFileNameValue());
	}
	
	private void initProperties(String file) 
	{
		if(properties == null) {
			properties = new Properties();
		}
		//properties.load(new FileReader("src/main/resources/config.properties"));
		try 
		{
			properties.load(getClass().getClassLoader().getResourceAsStream(file));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getPropertyValue(Key key) 
	{
		return properties.getProperty(key.getKeyValue());
	}
}
