package mvnpckg2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import mvnpckg1.Testversactions;
import org.testng.annotations.Test;

public class Testversetest {
    @Test
    public void testversactions() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://test-verse-blond.vercel.app/dashboard");
        Testversactions testversactions = new Testversactions(page);
        testversactions.AdminLogin();
        testversactions.dashboard();
        testversactions.module();
        testversactions.Bugtracker();
//        testversactions.Manualtesting();
//        testversactions.AutomationHub();
//        testversactions.DeveloperHub();
//        testversactions.Community();
//        testversactions.Chat();
//        testversactions.NotesLeaderboard();
//        testversactions.Users();
//        testversactions.Attendance();
//        testversactions.Createnewtester();
//        testversactions.testeraccept();
//        testversactions.Tester();
//        testversactions.adminsentmessage();
//        testversactions.testercheckmessage();
//        testversactions.testercheckall();
//        testversactions.createnewdeveloper();
//        testversactions.developeraccept();
//        testversactions.developer();
//        testversactions.developersendmessage();
//        testversactions.marcosendmessage();


    }
}
