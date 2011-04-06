/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobQueueHolder
{

    static private Map<String, Thread> jobs = new ConcurrentHashMap<String, Thread>();
    
    static private Logger log = LoggerFactory.getLogger(JobQueueHolder.class);
    
    static public void addJob(String uuid, Thread t)
    {
        log.info("Adding job: {}", uuid);
        jobs.put(uuid, t);
    }

    static public Boolean removeJob(String uuid)
    {
        log.info("Removing job: {}", uuid);
        return jobs.remove(uuid) != null;
    }

    static public Thread getJob(String uuid)
    {
        log.info("Getting job: {}", uuid);
        Thread t = jobs.get(uuid);
        if (t == null)
        {
            jobs.remove(uuid);
        }
        return t;
    }
    
    static public Integer countJobs()
    {
        return jobs.size();
    }

    public static void addJob()
    {
        addJob(UUIDJobHolder.initUUIDJob().getUUID(),Thread.currentThread());
    }

    public static void removeJob()
    {
        removeJob(UUIDJobHolder.getUUIDJob().getUUID());
    }

}
