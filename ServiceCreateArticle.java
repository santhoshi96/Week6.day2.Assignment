package week6.day2.Assignment.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import week6.day2.Assignment.Hooks.TestNgHooks;

public class ServiceCreateArticle extends TestNgHooks {
	public static String oldWindow;

	public ServiceCreateArticle getKN() {
		KnowledgeNumber = driver.findElement(By.id("sys_readonly.kb_knowledge.number")).getAttribute("value");
		System.out.println("Knowledge Number is:"+KnowledgeNumber);
		return this;
	}
	
	public ServiceCreateArticle clickKnowledge() {
		oldWindow = driver.getWindowHandle();
		driver.findElement(By.id("lookup.kb_knowledge.kb_knowledge_base")).click();
		return this;
	}
	
	public ServiceCreateArticle selectKnowledge() {
		Set<String> findKnowledge = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(findKnowledge);
		driver.switchTo().window(lstWindowHandles.get(1));
		driver.findElement(By.linkText("Knowledge")).click();
		return this;
	}
	
	public ServiceCreateArticle textshortDescription(String shortDes) {
		driver.switchTo().window(oldWindow);
		driver.switchTo().frame(0);
		driver.findElement(By.id("kb_knowledge.short_description")).sendKeys(shortDes);
		return this;
	}
	
	public ServiceHomePage clickKSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
		return new ServiceHomePage();
		
	}
	
}
