package com.github.testprj.config;

import com.googlecode.openbox.config.ConfigLoader;

public class ConfigIndex {

	private static final String INDEX = "config";
	private static final ConfigLoader CL = ConfigLoader.newInstance(INDEX+"/index.properties");
	public static final String CONFIG_LOCATION =INDEX+"/"+CL.getConfigItem(INDEX)+"/";
	
	public static final String CONFIG_PATH = getConfigPath("config.properties");
	
	public static String getConfigPath(String configFileName){
		String key = INDEX+"."+configFileName;
		String configPath = CL.getConfigItem(key);
		if(null == configPath){
			configPath = CONFIG_LOCATION+configFileName;
			CL.setConfigItem(key, configPath);
		}
		return configPath;
	}
}
