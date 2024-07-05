package com.company.util;

import org.slf4j.Logger;

import java.util.List;

public class LoggerUtil {
    public static <T> void getLoggerInfo(Logger logger, String msg, T t) {
        logger.info(STR."\u001B[32m\{msg}{}\u001B[0m", t);
    }

    public static <T> void getLoggerInfo(Logger logger, String msg, List<T> t) {
        logger.info(STR."\u001B[32m\{msg}{}\u001B[0m", t);
    }

    public static void getLoggerInfo(Logger logger, String msg) {
        logger.info(STR."\u001B[33m\{msg}{}\u001B[0m");
    }
}
