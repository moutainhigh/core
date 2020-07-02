package com.gupaoedu.example.condition.conditionalonclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/2 13:34
 * @Version:1.0
 */
public class Billy {
    private static Logger LOGGER = LoggerFactory.getLogger(Billy.class);
    public String fight() {
        LOGGER.info("billy：吾乃新日暮里的王，三界哲学的主宰。");
        return "fight success";
    }
}
