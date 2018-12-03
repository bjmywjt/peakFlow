package com.jt;

import static org.junit.Assert.assertTrue;

import com.jt.utils.Profiles;
import org.junit.Test;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.QueryFilter;
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
@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles(value = Profiles.DEVELOPMENT)
public class AppTest extends AbstractTransactionalJUnit4SpringContextTests{

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
        List<Process> list = engine.process().getProcesss(new QueryFilter());
    }
}
