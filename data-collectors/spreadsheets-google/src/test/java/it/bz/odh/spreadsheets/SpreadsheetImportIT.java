package it.bz.odh.spreadsheets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
@WebAppConfiguration
public class SpreadsheetImportIT {
    
    @Autowired
    private Main main;

    @Test
    public void testSpreadsheetSync() {
        main.syncData();
    }
}
