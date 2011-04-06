/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs.services.impl;

import com.energeya.lab.springrmijobs.UUIDJob;
import com.energeya.lab.springrmijobs.UUIDJobHolder;
import com.energeya.lab.springrmijobs.services.FakeServerManager;

public class FakeServerManagerImpl implements FakeServerManager
{

    @Override
    public String getCode()
    {
        UUIDJob uuidJob = UUIDJobHolder.getUUIDJob();
        try
        {
            Thread.sleep(9000L);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        if (uuidJob == null)
        {
            return "No UUID job";
        }
        return uuidJob.toString();
    }
    
}
