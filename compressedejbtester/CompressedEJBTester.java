package compressedejbtester;

import com.edw.facade.ConnectionFacadeRemote;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Dennis von Bargen
 */
public class CompressedEJBTester {

    private Logger logger = Logger.getLogger(CompressedEJBTester.class);
    
    private void connect() {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, 
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            
            // glassfish default port value will be 3700,
            // but im using tcpviewer to redirect my 50005 port to 3700
            //props.setProperty("org.omg.CORBA.ORBInitialPort", "50005");
            
            InitialContext ctx = new InitialContext(props);
            ConnectionFacadeRemote connectionFacadeRemote = 
                    (ConnectionFacadeRemote) ctx.lookup("com.edw.facade.ConnectionFacadeRemote");
            logger.debug(connectionFacadeRemote.sayHello("edwin "));
            logger.debug("my age is " + connectionFacadeRemote.sayAge(12) + " years");
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
    
    public static void main(String[] args) {
        CompressedEJBTester x = new CompressedEJBTester();
        x.connect();
    }
}
