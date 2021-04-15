import com.mdre.jdkcolorlogger.AnsiColorConsoleHandler;
import java.util.logging.Level;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ColorJdkTest {
    private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log-jdk");

    static {
        System.out.println("===============================");
        System.out.println("====== Color logger - jdk =====");
        System.out.println("===============================");
    }

    @Before
    public void setUp() {
        AnsiColorConsoleHandler.init();
    }
    
    @Test
    public void colorLoggingJdkTest() {
        logger.setLevel(Level.ALL);
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        logger.log(Level.WARNING, "warning with exception", new NullPointerException("Just testing"));

        System.out.println();
    }
}
