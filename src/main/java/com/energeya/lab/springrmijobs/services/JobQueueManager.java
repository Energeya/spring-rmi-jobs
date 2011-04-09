/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs.services;

/**
 * 
 */
public interface JobQueueManager
{

    /**
     * Save thread and UUID information
     * 
     * @param uuid
     *            unique identifier for the given thread
     * @param t
     *            thread hosting remoteinvocation gateway
     */
    void addJob(String uuid, Thread t);

    /**
     * Remove information about given UUID
     * 
     * @param uuid
     *            unique identifier
     * @return false on error
     */
    Boolean removeJob(String uuid);

    /**
     * Counts saved UUID information
     * 
     * @return The number of registered jobs
     */
    Integer countJobs();

    /**
     * Send kill signal through remoteinvocation gateway.
     * 
     * @param job
     */
    void killJob(String job);

}
