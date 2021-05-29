package week6.day2.Assignment.Testrun;

import org.testng.annotations.Test;

import week6.day2.Assignment.Hooks.TestNgHooks;
import week6.day2.Assignment.Pages.ServiceLoginPage;

public class CreateArticle extends TestNgHooks{

	@Test
	public void creatingArticle(){
		new ServiceLoginPage()
		.typeUserName("Admin")
		.typePassword("India@123")
		.clickLoginButton()
		.clickFilter()
		.clickK()
		.typeFilter("Knowledge")
		.clickCreateNew()
		.getKN()
		.clickKnowledge()
		.selectKnowledge()
		.textshortDescription("Testing")
		.clickKSubmit();
	}
}
