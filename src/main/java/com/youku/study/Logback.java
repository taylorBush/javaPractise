package com.youku.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author taylor
 * @date 2018/11/14
 */
public class Logback {
    private final static Logger logger = LoggerFactory.getLogger(Logback.class);

    public static void main(String[] args) {
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");
    }
}
