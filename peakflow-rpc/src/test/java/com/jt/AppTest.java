package com.jt;

import static org.junit.Assert.assertTrue;

import com.jt.service.SnakerEngineFacets;
import com.jt.utils.Profiles;
import org.junit.Test;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

/**
 * Unit test for simple App.
 */

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml", "/applicationContext-snaker.xml" })
@ActiveProfiles(value = Profiles.DEVELOPMENT)
public class AppTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private SnakerEngineFacets snakerEngineFacets;
    @Autowired
    private SnakerEngine engine;


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testFirst(){
        List<String> names = snakerEngineFacets.getAllProcessNames();
        System.out.println(names.toString());
    }

    @Test
    public void testSencond(){
        List<HistoryTask> tasks = engine.query().getHistoryTasks(new QueryFilter());
        tasks.stream().forEach(historyTask -> {
            System.out.println(historyTask.toString());
        });
    }
}
