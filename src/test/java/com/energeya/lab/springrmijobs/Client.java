package com.energeya.lab.springrmijobs;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;


public class Client
{

    Server server;

    private JobQueueManager jobQueueManager;

    private ApplicationContext clientCtx;

    private ApplicationContext serverCtx;

    @Test
    public void test1() throws Exception
    {
        Runnable r = new Runnable()
        {

            @Override
            public void run()
            {
                server.getCode();
            }

        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        Thread.sleep(5000);
        System.out.println("CLIENT: jobs running on the server " + jobQueueManager.countJobs());
        Thread.sleep(5000);
        System.out.println("CLIENT: jobs running on the server " + jobQueueManager.countJobs());
        Thread.sleep(5000);
    }

    /**
     * Get the RMI version of the manager
     */
    @Before
    public void setupTest()
    {
        serverCtx = new ClassPathXmlApplicationContext("classpath:spring-services.xml");
        clientCtx = new ClassPathXmlApplicationContext("classpath:spring-client.xml");
        this.server = (Server) clientCtx.getBean("serverRMI");
        this.jobQueueManager = (JobQueueManager) clientCtx.getBean("jobQueueManagerRMI");
    }

}
