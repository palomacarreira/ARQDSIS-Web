package Model;

import java.util.ResourceBundle;

public class Idioma {
	private static ResourceBundle bundle;
	
	public static ResourceBundle getBundle()
	{
		return bundle;
	}
	
	public static void setBundle(ResourceBundle b)
	{
		bundle = b;
	}
}
