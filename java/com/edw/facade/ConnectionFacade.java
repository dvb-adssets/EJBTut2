package com.edw.facade;

import javax.ejb.Stateless;

/**
 *
 * @author Dennis von Bargen
 */
@Stateless
public class ConnectionFacade implements ConnectionFacadeRemote {

    public String sayHello(String string) {
        System.out.println("I'm at " + this.getClass().getName() + " method sayHello().");
        return "hello " + string;
    }

    public int sayAge(int age) {
        System.out.println("I'm at " + this.getClass().getName() + " method sayAge().");
        return age * 2;
    }
}
