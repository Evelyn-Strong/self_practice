package com.practice.demo.util;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class YamlParserUtil {

    ClassLoader classLoader = getClass().getClassLoader();

    public static Map paserYaml(String filePath, String fileName) throws Exception {
        InputStream inputStream =ClassLoader.getSystemClassLoader().getResourceAsStream(filePath+fileName);
        //ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Yaml yaml =new Yaml();
        try{
            Map<String,Object> result = (Map<String,Object>) yaml.load(inputStream);
            return result;
        }catch(Exception e ) {
            if (e instanceof IOException) {
                System.out.println("Parser Yaml file failed!, please check file first");
            }

        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
