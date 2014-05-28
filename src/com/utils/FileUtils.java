package com.utils;

import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

public class FileUtils {

	public static String getPath(){
		String path = null;
		try {
			path = FileLocator.toFileURL(Platform.getBundle("autoCodeRcp").getEntry("")).getPath();
			path.substring(path.indexOf("/")+1,path.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
