/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
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
