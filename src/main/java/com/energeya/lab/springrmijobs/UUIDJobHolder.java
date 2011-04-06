/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs;


public class UUIDJobHolder
{

    private static ThreadLocal<UUIDJob> localUUID = new ThreadLocal<UUIDJob>();
    
    private UUIDJobHolder()
    {
		// forcing no public contructor
    }
    
    public static UUIDJob initUUIDJob()
    {
        if (localUUID.get() == null)
        {
            localUUID.set(new UUIDJob());
            System.out.println("NEW UUID: "+localUUID.get().getUUID());
        }
        return localUUID.get();
    }    
    
    public static void setUUIDJob(UUIDJob uuidJob)
    {
        localUUID.set(uuidJob);
    }
    
    public static UUIDJob getUUIDJob()
    {
        return localUUID.get();
    }
    
}
