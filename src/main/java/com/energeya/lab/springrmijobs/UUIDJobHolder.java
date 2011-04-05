package com.energeya.lab.springrmijobs;

import java.util.UUID;

public class UUIDJobHolder
{

    private static ThreadLocal<UUIDJob> localUUID = new ThreadLocal<UUIDJob>();
    
    private UUIDJobHolder()
    {
		// forcing no public contructor
    }
    
    public static void setUUIDJob(UUIDJob uuidJob)
    {
        localUUID.set(uuidJob);
    }
    
    public static UUIDJob getUUIDJob()
    {
        return localUUID.get();
    }
    
	/**
	 * Generate a new random UUID with current ThreadLocal
	 * 
	 * @return generated uuid identifier
	 */
	public static String enqueueNewUUIDJob() {
		String uuid = UUID.randomUUID().toString();
		UUIDJob job = new UUIDJob(uuid);
		setUUIDJob(job);
		return uuid;
	}

}
