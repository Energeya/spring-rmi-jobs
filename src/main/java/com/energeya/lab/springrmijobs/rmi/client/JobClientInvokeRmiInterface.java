package com.energeya.lab.springrmijobs.rmi.client;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.energeya.lab.springrmijobs.UUIDJobHolder;

/**
 * Generates random UUID for every RMI client invocation
 * 
 */
public class JobClientInvokeRmiInterface extends RmiProxyFactoryBean {

	/**
	 * A new UUID will be created for every method invocation
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		String uuid = UUIDJobHolder.enqueueNewUUIDJob();
		System.out.println("CLIENT: " + uuid);

		return super.invoke(invocation);
	}

}
