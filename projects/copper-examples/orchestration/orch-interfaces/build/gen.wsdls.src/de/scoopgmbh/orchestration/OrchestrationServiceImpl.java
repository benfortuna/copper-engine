
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package de.scoopgmbh.orchestration;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2013-04-08T12:41:21.252+02:00
 * Generated source version: 2.6.0
 * 
 */

@javax.jws.WebService(
                      serviceName = "OrchestrationService",
                      portName = "OrchestrationServicePort",
                      targetNamespace = "http://orchestration.scoopgmbh.de/",
                      wsdlLocation = "classpath:wsdl/OrchestrationEngine.wsdl",
                      endpointInterface = "de.scoopgmbh.orchestration.OrchestrationService")
                      
public class OrchestrationServiceImpl implements OrchestrationService {

    private static final Logger LOG = Logger.getLogger(OrchestrationServiceImpl.class.getName());

    /* (non-Javadoc)
     * @see de.scoopgmbh.orchestration.OrchestrationService#resetMailbox(java.lang.String  msisdn ,)java.lang.String  secret )*
     */
    @Override
	public void resetMailbox(java.lang.String msisdn,java.lang.String secret) { 
        LOG.info("Executing operation resetMailbox");
        System.out.println(msisdn);
        System.out.println(secret);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}