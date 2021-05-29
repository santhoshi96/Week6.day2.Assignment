package week6.day2.Assignment.Testrun;

import org.testng.annotations.Test;

import week6.day2.Assignment.Hooks.TestNgHooks;
import week6.day2.Assignment.Pages.ServiceLoginPage;

public class UpdateChatQueue extends TestNgHooks{

	@Test
	public void updatingqueue() {
		new ServiceLoginPage()
		.typeUserName("Admin")
		.typePassword("India@123")
		.clickLoginButton()
		.clickFilter()
		.typeFilter("My Work")
		.clickMyWork()
		.selecChatqueue ()
		.clickChatQueue()
		.getChatIN()
		.updateState()
		.updatePriority()
		.clickOnUpdate()
		.selectNumber()
		.verifyChatQueueupdated();
	}
}
