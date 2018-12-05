package com.jt;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.Maps;
import com.jt.service.SnakerEngineFacets;
import com.jt.utils.Profiles;
import org.junit.Test;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.Process;
import org.snaker.engine.helper.StreamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;
import java.util.Map;

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

    @Test
    @Rollback(false)
    public void testAll(){
//        engine.process().deploy(StreamHelper.getStreamFromClasspath(""));
//        engine.process().undeploy("03594189e5f04c5f923ba276d35a1185");
        Map<String, Object> paraMap = Maps.newHashMap();
        paraMap.put("desc","快速整改");
        paraMap.put("deadline", 30);
        engine.startInstanceById("f378448e4adf4ccd99688bbc659281b4","wangjiangtao",paraMap);
    }
}
