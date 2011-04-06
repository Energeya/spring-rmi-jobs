package com.energeya.lab.springrmijobs.services;

/**
 * 
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
	 * @return
	 */
    Integer countJobs();

	/**
	 * Send kill signal through remoteinvocation gateway.
	 * 
	 * @param job
	 */
    void killJob(String job);
    
}
