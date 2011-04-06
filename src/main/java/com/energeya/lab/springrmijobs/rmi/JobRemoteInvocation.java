/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs.rmi;

import java.lang.reflect.InvocationTargetException;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.support.RemoteInvocation;

import com.energeya.lab.springrmijobs.JobQueueHolder;
import com.energeya.lab.springrmijobs.UUIDJob;
import com.energeya.lab.springrmijobs.UUIDJobHolder;


/**
 * @author carone
 * @version $Id: $
 */
public class JobRemoteInvocation extends RemoteInvocation
{

    private static final long serialVersionUID = -5904182288627224269L;

    private final UUIDJob uuidJob;// RMI transported

    /**
     * 
     */
    public JobRemoteInvocation(MethodInvocation methodInvocation)
    {
        super(methodInvocation);
        uuidJob = UUIDJobHolder.initUUIDJob();
        System.out.println("CLIENT: " + uuidJob.getUUID());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object invoke(Object targetObject) throws NoSuchMethodException, IllegalAccessException,
        InvocationTargetException
    {
        UUIDJobHolder.setUUIDJob(uuidJob);
        System.out.println("SERVER: " + uuidJob.getUUID());
        JobQueueHolder.addJob();
        try
        {
            return super.invoke(targetObject);
        }
        finally
        {
            JobQueueHolder.removeJob();
        }
    }

}
