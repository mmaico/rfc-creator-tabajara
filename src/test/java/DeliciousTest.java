
import org.junit.Test;

import uol.rfc.common.ChromeTestCase;
import uol.rfc.test.RfcHome;


public class DeliciousTest extends ChromeTestCase {
	
	  
	@Test
	public void testLoginSucess() {
		new RfcHome().navigateToHome().clickServiceCenterLink()
		.doLogin()
		.showViewWorkQueues()
		.showCmQueue()
		.listRfcCategories()
		.normalUolCs()
    		.plannedStartAndEndDates()
    		.changeCategoryToMinor()
    		.reasonBusinessRequirement()
		.switchToGeneralTap()
		    .changeEnvironmentProductionPortal()
		    .projectNameChange()
		    .isNotNecessaryDBA()
		 .done();
	}
	

}
