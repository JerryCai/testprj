package com.github.testprj.config;

import com.googlecode.openbox.config.ConfigIndex;
import com.googlecode.openbox.config.ConfigLoader;


public class ConfigImpl implements Config {

	private static final ConfigLoader CL = ConfigLoader
			.newInstance(ConfigIndex.CONFIG_PATH);

	private static final ConfigImpl instance = new ConfigImpl();

	private ConfigImpl() {

	}

	public static ConfigImpl getInstance() {
		return instance;
	}


}
