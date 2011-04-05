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
