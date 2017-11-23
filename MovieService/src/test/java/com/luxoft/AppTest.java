package com.luxoft;

import org.junit.Test;

import com.luxoft.controller.HomeController;
import static org.junit.Assert.assertEquals;

/**
 * Test Class
 *
 * @author Jitender Kumar
 */

public class AppTest {

	@Test
    public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
        assertEquals( result, "Application deployed successfuly!!" );
	}
}
