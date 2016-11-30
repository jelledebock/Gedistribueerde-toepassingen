package be.ugent.src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author JelleDeBock
 */
public class NewMessageHandler implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext messageContext) {
        try
        {
            SOAPMessage msg = messageContext.getMessage();
            String outProperty = SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY;
            
            boolean outgoing = (Boolean)messageContext.get(outProperty);
            
            SOAPMessage soap_msg = messageContext.getMessage();
            if (outgoing)
                msg.writeTo(new FileOutputStream("/Users/JelleDeBock/NetBeansProjects/glassfish_out"));
            else
                msg.writeTo(new FileOutputStream("/Users/JelleDeBock/NetBeansProjects/glassfish_in"));
        }
        catch(IOException e)
        {
           throw new RuntimeException(e) ;
        }
        catch(SOAPException e)
        {
           throw new RuntimeException(e);
        }
        return true;
    }
    
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
}
