/*******************************************************************************
 * Copyright (c) 2011 Energeya LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *******************************************************************************/
package com.energeya.lab.springrmijobs;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.energeya.lab.springrmijobs.services.FakeServerManager;
import com.energeya.lab.springrmijobs.services.JobQueueManager;


public class Client
{

    private FakeServerManager fakeManager;

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
                fakeManager.getCode();
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
        this.fakeManager = (FakeServerManager) clientCtx.getBean("serverRMI");
        this.jobQueueManager = (JobQueueManager) clientCtx.getBean("jobQueueManagerRMI");
    }

}
