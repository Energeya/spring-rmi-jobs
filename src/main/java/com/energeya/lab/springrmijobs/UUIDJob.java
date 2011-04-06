/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs;

import java.io.Serializable;
import java.util.UUID;

/**
 * Unique identifier for every client invocation
 * 
 */
public class UUIDJob implements Serializable
{

    private static final long serialVersionUID = -720821895258070781L;

    private String UUIDJob;

    public UUIDJob()
    {
        UUIDJob = UUID.randomUUID().toString();
    }

    public String getUUID()
    {
        return UUIDJob;
    }
    
}
