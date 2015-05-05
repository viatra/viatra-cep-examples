package org.eclipse.viatra.cep.examples.sosym.interfaces;

import org.apache.log4j.Logger;

import com.google.common.base.Preconditions;

public class LoggerWrapper {

    private static LoggerWrapper instance;
    private static Logger logger;

    public static LoggerWrapper getInstance() {
        Preconditions.checkArgument(logger != null);
        return instance;
    }

    public static LoggerWrapper initialize(Logger logger) {
        if (instance == null) {
            LoggerWrapper.logger = logger;
        }
        return instance;
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void dispose() {
        logger = null;
        instance = null;
    }

}
