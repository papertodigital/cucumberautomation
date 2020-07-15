package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfigiurator {

	String filePath;
	public Properties prop;
	File propertiesFile;
	
	public String getProperty(String property)
	{
		try {
		propertiesFile=new File(System.getProperty("user.dir")+filePath);
		if(propertiesFile.exists())
		{
		InputStream fis=new FileInputStream(propertiesFile);
		prop=new Properties();
		prop.load(fis);
		}else
		{
			System.out.println("Config file "+propertiesFile.getAbsolutePath()+" File Not found");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(property);
	}
	
	public PropertyConfigiurator(String filePath)
	{
		this.filePath=filePath;
	}
}
