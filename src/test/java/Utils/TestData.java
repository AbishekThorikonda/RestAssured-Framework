package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
	
	public static String GetRandomName()
	{
		String name=RandomStringUtils.randomAlphabetic(1);
		return("Abishek"+name);
	}
	
	public static String GetRandomJob()
	{
		String job = RandomStringUtils.randomAlphabetic(4);
		return("job"+job);
	}

}
