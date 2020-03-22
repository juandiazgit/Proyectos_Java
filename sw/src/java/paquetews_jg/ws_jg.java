/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetews_jg;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ordenador
 */
@WebService(serviceName = "ws_jg")
public class ws_jg {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sumar")
    public Integer sumar(@WebParam(name = "numero1") int numero1, @WebParam(name = "numero2") int numero2) {
        //TODO write your implementation code here:
        return numero1+numero2;
    }
}
