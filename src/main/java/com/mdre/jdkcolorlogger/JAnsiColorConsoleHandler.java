package com.mdre.jdkcolorlogger;

import java.util.logging.LogRecord;
import org.fusesource.jansi.AnsiConsole;

@SuppressWarnings("javadoc")
public class JAnsiColorConsoleHandler extends BaseColorConsoleHandler {
    
    @Override
    public void publish(LogRecord record) {
        AnsiConsole.err().print(logRecordToString(record));
        AnsiConsole.err().flush();
    }
}