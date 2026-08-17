package com.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static String takeScreenshot(
			WebDriver driver,
			String fileName,
			String screenshotFolder) {

		String folderPath =
				System.getProperty("user.dir")
				+ "/"
				+ screenshotFolder;

		File folder = new File(folderPath);

		if (!folder.exists()) {

			folder.mkdirs();

		}

		String path =
				folderPath
				+ "/"
				+ fileName
				+ ".png";

		try {

			TakesScreenshot ts =
					(TakesScreenshot) driver;

			File source =
					ts.getScreenshotAs(OutputType.FILE);

			File destination =
					new File(path);

			FileUtils.copyFile(
					source,
					destination);

			System.out.println(
					"Screenshot saved : "
					+ path);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return path;
	}
}