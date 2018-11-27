package com.kaisnm.crewler.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * 读取properties配置文件工具类
 * @author xingyu.lu
 */
public class ResourceBundleUtil {
	private final static Logger log = Logger.getLogger(ResourceBundleUtil.class);

    private static ResourceBundle system;
    static {
        try {
            system = ResourceBundle.getBundle("env");
        } catch (Exception e) {
            log.error("systemConfig.properties Not Found. some keys lost.");
        }
    }

    /**
     * 获取properties配置字段value
     * 
     * @param fileName
     * @param key
     * @return
     */
    public static String getPropertiesValue(String fileName, String key) {

        try {
            ResourceBundle prop = ResourceBundle.getBundle(fileName);
            return prop.getString(key);
        } catch (Exception e) {
            log.error("properties file Not Found. some keys lost.");
        }
        return null;
    }

    /**
     * systemConfig
     * 
     * @param key
     * @return
     */
    public static String getSystem(final String key) {
        String msg = null;
        try {
            msg = system.getString(key);
        } catch (Exception e) {
            log.error("Key['" + key + "'] Not Found in systemConfig.properties .");
        }
        return msg == null ? system.getString("default") : msg;
    }

    /**
     * 获取磁盘配置文件 key-value
     * 
     * @param filePath
     * @param key
     * @return
     */
    public static String getPropWithFilePath(String filePath, String key) {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            ResourceBundle rb = new PropertyResourceBundle(in);
            return rb.getString(key);
        } catch (IOException e) {
            log.error("properties file Not Found [filePath:" + filePath + "]");
            return null;
        }
    }
    
	public static void main(String[] args) {
		System.out.println(getSystem("crawler_base_url"));
		System.out.println(getSystem("crawler_details_interface"));
		System.out.println(getSystem("crawler_details_method_type"));
	}
}
