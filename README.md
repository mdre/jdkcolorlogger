# JDK Color Logger

This code is based in the excelent code developed by Mihai Nita (https://github.com/mihnita/java-color-loggers).
This is only a subset with a convenient method to sutb it in Netbeans or other ides. It work out-of-the-box on Linux. 

## Example:
```Java
public class TestLog {
    private final static Logger LOGGER = Logger.getLogger("log-jdk");
    static {
        AnsiColorConsoleHandler.init();
        if (LOGGER.getLevel() == null) {
            LOGGER.setLevel(Level.ALL);
        }
    }

    public TestLog() {
        System.out.println(Arrays.toString(LOGGER.getHandlers()));
        
        String greenBold = "\u001B[32m";
        String reset = "\033[0m";
        System.out.println("before" + greenBold + " green " + reset + "after");
        
        LOGGER.log(Level.INFO, "info");
        LOGGER.log(Level.FINEST, "finest");
        LOGGER.log(Level.FINER, "finer");
        LOGGER.log(Level.CONFIG, "config");
        LOGGER.log(Level.SEVERE, "severe");
        LOGGER.log(Level.WARNING, "warning");
        
        System.out.println("//=====================================================");
        
        LOGGER.severe("severe");
        LOGGER.warning("warning");
        LOGGER.info("info");
        LOGGER.config("config");
        LOGGER.fine("fine");
        LOGGER.finer("finer");
        LOGGER.finest("finest");
    }
    
    
    public static void main(String[] args) {
        new TestLog();
    }
}

```