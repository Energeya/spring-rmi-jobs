/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs.services.impl;

import com.energeya.lab.springrmijobs.JobQueueHolder;
import com.energeya.lab.springrmijobs.services.JobQueueManager;

/**
 * {@inheritDoc}
 */
public class JobQueueManagerImpl implements JobQueueManager
{
    
	/**
	 * {@inheritDoc}
	 */
    @Override
    public void addJob(String uuid, Thread t)
    {
        JobQueueHolder.addJob(uuid, t);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public Boolean removeJob(String uuid)
    {
        return JobQueueHolder.removeJob(uuid);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public Integer countJobs()
    {
        return JobQueueHolder.countJobs();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void killJob(String job)
    {
        Thread t = JobQueueHolder.getJob(job);
        if (t != null && !t.isInterrupted())
        {
            t.interrupt();
        }
    }

}
