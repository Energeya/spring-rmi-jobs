/*
 * Copyright (c) Energeya.  All rights reserved. http://www.energeya.com
 */
package com.energeya.lab.springrmijobs;

import java.lang.reflect.InvocationTargetException;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.support.RemoteInvocation;


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
