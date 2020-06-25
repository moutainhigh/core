package com.gupao.spi.use;

import com.gupao.spi.DataBaseDriver;

import java.util.ServiceLoader;

/**
 * spi机制，代码使用
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<DataBaseDriver> serviceLoader = ServiceLoader.load(DataBaseDriver.class);
        for (DataBaseDriver dbd : serviceLoader) {
            System.out.println(dbd.buildCOnnect("Test"));
        }
    }
}
