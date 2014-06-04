package com.edw.facade;

import javax.ejb.Remote;

/**
 *
 * @author Dennis von bargen
 */
@Remote
public interface ConnectionFacadeRemote {
    
    String sayHello(String string);
    int sayAge(int age);
}
