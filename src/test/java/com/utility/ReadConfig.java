package com.utility;

import java.io.FileInputStream;
import java.util.Base64;
import java.util.Properties;

public class ReadConfig {

	Properties pro = new Properties();

	public ReadConfig() {

		try {

			FileInputStream file =
					new FileInputStream("./Configuration/config.properties");

			pro.load(file);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

	public String getUrl() {

		return pro.getProperty("url");

	}

	public String getBrowser() {

		return pro.getProperty("browser");

	}

	public String getPassword() {

		String encodedPassword =
				pro.getProperty("password");

		byte[] decodedBytes =
				Base64.getDecoder().decode(encodedPassword);

		return new String(decodedBytes);

	}

	public String getInvalidPassword() {

		return pro.getProperty("invalidPassword");

	}

	public boolean isScreenshotEnabled() {

		return Boolean.parseBoolean(
				pro.getProperty("screenshot"));

	}

	public String getScreenshotPath() {

		return pro.getProperty("screenshotPath");

	}

}