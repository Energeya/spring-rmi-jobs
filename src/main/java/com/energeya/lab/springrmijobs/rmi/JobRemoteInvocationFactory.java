/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs.rmi;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationFactory;



/**
 * @author carone
 * @version $Id: $
 */
public class JobRemoteInvocationFactory implements RemoteInvocationFactory
{

    /**
     * {@inheritDoc}
     */
    @Override
    public RemoteInvocation createRemoteInvocation(MethodInvocation methodInvocation)
    {
        JobRemoteInvocation tlc = new JobRemoteInvocation(methodInvocation);
        return tlc;
    }

}
