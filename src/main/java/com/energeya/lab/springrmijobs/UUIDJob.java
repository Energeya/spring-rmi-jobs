package com.energeya.lab.springrmijobs;

import java.io.Serializable;

/**
 * Unique identifier for every client invocation
 * 
 */
public class UUIDJob implements Serializable
{
    private static final long serialVersionUID = -720821895258070781L;
    private String UUIDJob;
    
	/**
	 * New istance with the given UUID
	 * 
	 * @param uUIDJob
	 *            random unique UUID
	 */
	public UUIDJob(String uUIDJob) {
		super();
		UUIDJob = uUIDJob;
	}

	private UUIDJob() {
		// forcing no public no-args constructor
	}

	/**
	 * @return current UUID
	 */
    public String getUUID()
    {
        return UUIDJob;
    }


}
