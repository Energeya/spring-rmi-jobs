package com.energeya.lab.springrmijobs;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.energeya.lab.springrmijobs.services.FakeServerManager;
import com.energeya.lab.springrmijobs.services.JobQueueManager;

@ContextConfiguration(locations = { "/spring-tests.xml" })
public class Client extends AbstractJUnit4SpringContextTests
{
	FakeServerManager fakeManager;
    private JobQueueManager jobQueueManager;

    @Test
    public void test1() throws Exception
    {
        Runnable r = new Runnable() {

            @Override
            public void run()
            {
				fakeManager.getCode();
            }
            
        };
        Thread t = new Thread(r);
        t.start();
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
		this.fakeManager = (FakeServerManager) applicationContext.getBean("serverRMI");
        this.jobQueueManager = (JobQueueManager) applicationContext.getBean("jobQueueManagerRMI");
    }

}
