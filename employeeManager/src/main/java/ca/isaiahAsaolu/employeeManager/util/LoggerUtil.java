package ca.isaiahAsaolu.employeeManager.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil
{
    private static final Logger log = LoggerFactory.getLogger(LoggerUtil.class);
    public static void formatLog(Class<?> cls, String message){
        log.info("{} class -- {}", cls.getSimpleName(), message);
    }
}
