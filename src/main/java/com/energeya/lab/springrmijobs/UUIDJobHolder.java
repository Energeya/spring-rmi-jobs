package com.energeya.lab.springrmijobs;

public class UUIDJobHolder
{

    private static ThreadLocal<UUIDJob> localUUID = new ThreadLocal<UUIDJob>();
    
    private UUIDJobHolder()
    {
        //
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
