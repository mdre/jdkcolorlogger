package com.mdre.jdkcolorlogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/** Color Console Handler for jdk: using ANSI sequences */
abstract class BaseColorConsoleHandler extends ConsoleHandler {
    private static final String COLOR_RESET   = "\u001b[0m";

    private static final String COLOR_SEVERE  = "\u001b[91m";
    private static final String COLOR_WARNING = "\u001b[93m";
    private static final String COLOR_INFO    = "\u001b[32m";
    private static final String COLOR_CONFIG  = "\u001b[94m";
    private static final String COLOR_FINE    = "\u001b[36m";
    private static final String COLOR_FINER   = "\u001b[35m";
    private static final String COLOR_FINEST  = "\u001b[90m";

    public static boolean init(String prop) {
        try {
            InputStream ins = BaseColorConsoleHandler.class.getResourceAsStream(prop); 
            java.util.logging.LogManager.getLogManager().readConfiguration(ins);
        } catch (@SuppressWarnings("unused") IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public static boolean init() {
        return BaseColorConsoleHandler.init("/jdkcolorlogger/logJdk.properties");
    }
     
    String logRecordToString(LogRecord record) {
        Formatter f = getFormatter();
        String msg = f.format(record);

        String prefix;
        Level level = record.getLevel();
        if (level == Level.SEVERE)
            prefix = COLOR_SEVERE;
        else if (level == Level.WARNING)
            prefix = COLOR_WARNING;
        else if (level == Level.INFO)
            prefix = COLOR_INFO;
        else if (level == Level.CONFIG)
            prefix = COLOR_CONFIG;
        else if (level == Level.FINE)
            prefix = COLOR_FINE;
        else if (level == Level.FINER)
            prefix = COLOR_FINER;
        else if (level == Level.FINEST)
            prefix = COLOR_FINEST;
        else
            // Unknown level, probably not possible, but if it happens it means it's bad :-)
            prefix = COLOR_SEVERE;

        return prefix + msg + COLOR_RESET;
    }
}
