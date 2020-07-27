package com.gupaoedu.example.sourceloader;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class JsonPropertySourceLoader implements PropertySourceLoader{
    @Override
    public String[] getFileExtensions() {
        return new String[]{"txt"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        //拿到文件地址
        //解析文件
        //保存PropertySource
//        return new GpDefineJsonProperySource();
        return null;
    }
}
