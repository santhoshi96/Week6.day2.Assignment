package week6.day2.Assignment.Testrun;

import org.testng.annotations.Test;

import week6.day2.Assignment.Hooks.TestNgHooks;
import week6.day2.Assignment.Pages.ServiceLoginPage;

public class CreateChatQueue extends TestNgHooks {
	
	@Test
	public void creatingChatQueue() throws InterruptedException
	{
		new ServiceLoginPage()
		.typeUserName("Admin")
		.typePassword("India@123")
		.clickLoginButton()
		.clickFilter()
		.typeFilter("My Work")
		.clickMyWork()
		.clickNew()
		.clickChatQuery()
		.getChatIN()
		.typeShortDescription("Hello")
		.typeDescription("Test")
		.clickSubmit()
		.clickTaskSearch()
		.verifyChatQueryCreated();

}
}
