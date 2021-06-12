
package wsscheduler.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.tempuri.services_asmx.getresponsefile.CFileContent;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140319.1121
 * Generated source version: 2.2
 *
 */
@WebService(name = "ServiceSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({ org.tempuri.ObjectFactory.class, org.tempuri.services_asmx.getresponsefile.ObjectFactory.class })
public interface ServiceSoap {


    /**
     *
     * @param getFileResponse
     * @param memberCode
     * @return
     *     returns int
     */
    @WebMethod(operationName = "ReceiveDataStatic", action = "http://tempuri.org/ReceiveDataStatic")
    @WebResult(name = "ReceiveDataStaticResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ReceiveDataStatic", targetNamespace = "http://tempuri.org/",
                    className = "org.tempuri.ReceiveDataStatic")
    @ResponseWrapper(localName = "ReceiveDataStaticResponse", targetNamespace = "http://tempuri.org/",
                     className = "org.tempuri.ReceiveDataStaticResponse")
    public int receiveDataStatic(@WebParam(name = "memberCode", targetNamespace = "http://tempuri.org/")
                                 String memberCode,
                                 @WebParam(name = "getFileResponse",
                                           targetNamespace = "http://tempuri.org/Services.asmx/getResponseFile")
                                 CFileContent getFileResponse);

    /**
     *
     * @param getFileResponse
     * @param memberCode
     * @return
     *     returns int
     */
    @WebMethod(operationName = "ReceiveDataInvestor", action = "http://tempuri.org/ReceiveDataInvestor")
    @WebResult(name = "ReceiveDataInvestorResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ReceiveDataInvestor", targetNamespace = "http://tempuri.org/",
                    className = "org.tempuri.ReceiveDataInvestor")
    @ResponseWrapper(localName = "ReceiveDataInvestorResponse", targetNamespace = "http://tempuri.org/",
                     className = "org.tempuri.ReceiveDataInvestorResponse")
    public int receiveDataInvestor(@WebParam(name = "memberCode", targetNamespace = "http://tempuri.org/")
                                   String memberCode,
                                   @WebParam(name = "getFileResponse",
                                             targetNamespace = "http://tempuri.org/Services.asmx/getResponseFile")
                                   CFileContent getFileResponse);

    /**
     *
     * @param getFileResponse
     * @param memberCode
     * @return
     *     returns int
     */
    @WebMethod(operationName = "ValidatorDataInvestor", action = "http://tempuri.org/ValidatorDataInvestor")
    @WebResult(name = "ValidatorDataInvestorResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ValidatorDataInvestor", targetNamespace = "http://tempuri.org/",
                    className = "org.tempuri.ValidatorDataInvestor")
    @ResponseWrapper(localName = "ValidatorDataInvestorResponse", targetNamespace = "http://tempuri.org/",
                     className = "org.tempuri.ValidatorDataInvestorResponse")
    public int validatorDataInvestor(@WebParam(name = "memberCode", targetNamespace = "http://tempuri.org/")
                                     String memberCode,
                                     @WebParam(name = "getFileResponse",
                                               targetNamespace = "http://tempuri.org/Services.asmx/getResponseFile")
                                     CFileContent getFileResponse);

    /**
     *
     * @param memberCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CheckConnection", action = "http://tempuri.org/CheckConnection")
    @WebResult(name = "CheckConnectionResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "CheckConnection", targetNamespace = "http://tempuri.org/",
                    className = "org.tempuri.CheckConnection")
    @ResponseWrapper(localName = "CheckConnectionResponse", targetNamespace = "http://tempuri.org/",
                     className = "org.tempuri.CheckConnectionResponse")
    public String checkConnection(@WebParam(name = "memberCode", targetNamespace = "http://tempuri.org/")
                                  String memberCode);

}