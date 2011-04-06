package com.energeya.lab.springrmijobs.rmi.client;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.energeya.lab.springrmijobs.UUIDJob;
import com.energeya.lab.springrmijobs.UUIDJobHolder;

/**
 * Generates random UUID for every RMI client invocation
 * 
 * JobRemoteInvocation costructor do the same duty.
 */
@Deprecated 
public class JobClientInvokeRmiInterface extends RmiProxyFactoryBean {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		UUIDJob uuidJob = UUIDJobHolder.initUUIDJob();
		System.out.println("CLIENT: " + uuidJob.getUUID());
		return super.invoke(invocation);
	}

}
