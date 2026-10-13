package mvnpckg1;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Testversactions {
    private Page page;

    public Testversactions(Page page) {
        this.page = page;

    }

    public void AdminLogin() {
        page.getByPlaceholder("you@example.com")
                .fill("admin@testverse.com");
        System.out.println("Successfully entered valid admin mail ID");

        page.getByPlaceholder("Enter your password")
                .fill("admin123");
        System.out.println("Successfully entered valid password");

        page.locator("//*[@id=\"root\"]/div/div[11]/div[2]/div[2]/div[2]/div/div[6]/div/form/button")
                .click();
        System.out.println("Successfully clicked login button");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active Today list")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active Today list")).click();
        System.out.println("Successfully check active persons");


    }

    public void dashboard() {
        System.out.println("Now testing Dashboard");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active Today list")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active Today list")).click();
        System.out.println("Successfully check online list");
        page.locator("//*[@id=\"root\"]/div/div[2]/header/div[2]/button[1]").click();
        System.out.println("Successfully Click Add Task");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[1]/button").click();
        System.out.println("Successfully Click Create Task");
        page.getByPlaceholder("Enter task title").fill("Add a logo");
        System.out.println("Successfully Enter task title");
        page.getByPlaceholder("Task description").fill("Add logo min size 5MB");
        System.out.println("Successfully Enter task description");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[5]/div/form/div[3]/div[1]/select").selectOption("Medium");
        System.out.println("Successfully Select Medium");
        page.getByPlaceholder("Module name").fill("File Upload");
        System.out.println("Successfully enter Module name");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[5]/div/form/div[4]/select").selectOption(new SelectOption().setLabel("Irfxn (TESTER)"));
        System.out.println("Successfully Select Irfxn");
        page.locator("input[type='date']").fill("2026-10-15");
        System.out.println("Successfully Enter date");
        page.getByPlaceholder("Additional instructions").fill("Change fastly without affect existing functionalities");
        System.out.println("Successfully Enter Additional instructions");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[5]/div/form/button").click();
        System.out.println("Successfully Click Add Task");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active Today list")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active Today list")).click();
        System.out.println("Successfully search  Task name");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[1]/div[2]/div")
                .dragTo(page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[2]"));
        System.out.println("Successfully drag Todo to planning");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[2]")
                .dragTo(page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[3]"));
        System.out.println("Succesfully drag planning to Inprogress");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[3]/div[2]/div")
                .dragTo(page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[4]"));
        System.out.println("Successfully drag Inprogress to Review");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[4]")
                .dragTo(page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[5]"));
        System.out.println("Successfully drag Review to Done");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[5]/div[2]/div/div[2]/button[2]").click();
        page.reload();
        System.out.println("Successfully delete task");


    }

    public void module() {
        System.out.println("Now testing module");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Modules")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Module")).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Module Name \\*$"))).getByRole(AriaRole.TEXTBOX).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Module Name \\*$"))).getByRole(AriaRole.TEXTBOX).fill("Screenshot");
        page.locator("textarea").click();
        page.locator("textarea").fill("Take screenshot using playwright in intelij");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("e.g., Web, Mobile, API")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("e.g., Web, Mobile, API")).fill("Web");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("React, TypeScript, Spring Boot")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("React, TypeScript, Spring Boot")).fill("React");
        page.getByRole(AriaRole.SPINBUTTON).click();
        page.getByRole(AriaRole.SPINBUTTON).click();
        page.getByRole(AriaRole.SPINBUTTON).click();
        page.getByRole(AriaRole.SPINBUTTON).press("ArrowLeft");
        page.getByRole(AriaRole.SPINBUTTON).fill("50");
        page.getByRole(AriaRole.SPINBUTTON).click();
        page.onceDialog(dialog -> {
            System.out.println(String.format("Dialog message: %s", dialog.message()));
            dialog.dismiss();
        });
        page.locator("form").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Create Module")).click();
        System.out.println("successfully create module");

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search modules...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search modules...")).fill("screen");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search modules...")).press("Enter");
        System.out.println("successfully search module name");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div/div[1]/div[2]/button[3]/svg/path[2]").click();
        System.out.println("successfully delete module");
    }

    public void Bugtracker() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bug Tracker")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Report Bug")).first().click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter bug title")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter bug title")).fill("Screenshot image was not uploaded");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Describe the bug")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Describe the bug")).fill("When report the bug , failed to attatch the image in screenshot option");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^SeverityMinorMajorCriticalBlocker$"))).getByRole(AriaRole.COMBOBOX).selectOption("Minor");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Step 1: ... Step 2:")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Step 1: ... Step 2:")).fill("1\n2\n3");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What should happen")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What should happen")).fill("succesfully attatched the image");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What actually happened")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What actually happened")).fill("image was not accepted");
        page.locator("form div").filter(new Locator.FilterOptions().setHasText("Assign Developer (Optional)")).getByRole(AriaRole.COMBOBOX).selectOption("6");
        page.onceDialog(dialog -> {
            System.out.println(String.format("Dialog message: %s", dialog.message()));
            dialog.dismiss();
        });
        page.locator("form").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Report Bug")).click();
        System.out.println("successfully report bug");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search bugs...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search bugs...")).fill("screenshot");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search bugs...")).press("Enter");
        System.out.println("successfully search bugs");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[1]/div[2]/div")
                .dragTo(page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[2]"));
        System.out.println("successfully move open to in progress");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[2]/div[2]/div")
                .dragTo(page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[3]"));
        System.out.println("successfully move in progress to Resolved");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[3]/div[2]/div")
                .dragTo(page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[4]"));
        System.out.println("successfully move Resolved to closed");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[4]/div[4]/div[2]/div/div[2]/button[2]").click();
        System.out.println("successfully delete bug");
    }

    public void Manualtesting() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manual Testing")).click();
        System.out.println("Successfully clicked Manual Testing button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload Spreadsheet")).click();
        System.out.println("Successfully clicked Upload Spreadsheet button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Google Sheets Import")).click();
        System.out.println("Successfully clicked Google Sheets Import button");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("https://docs.google.com/")).click();

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("https://docs.google.com/"))
                .fill("https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit?gid=0#gid=0");
        System.out.println("Successfully Enter the URL");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fetch Google Sheet")).click();
        System.out.println("Successfully clicked Fetch Google Sheet button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm & Upload")).click();
        System.out.println("Successfully Uploaded Spreadsheet");
    }

    public void AutomationHub() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("AutomationHub")).click();
        System.out.println("Successfully clicked AutomationHub button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New Automation Project")).click();
        System.out.println("Successfully clicked New Automation Project button");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("e.g. Playwright Java")).fill("Playwright Automation");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What test suites and packages")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What test suites and packages")).fill("Login Module Only");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Project")).click();
        System.out.println("Successfully clicked Create Project button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("IDE Connections 4 IDEs")).click();
        System.out.println("Successfully clicked IDE Connections 4 button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Access Requests")).click();
        System.out.println("Successfully clicked Access Requests button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Execution Scripts")).click();
        System.out.println("Successfully clicked Execution Scripts button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New Script")).click();
        System.out.println("Successfully clicked New Scripts button");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("e.g. User Authentication Flow")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("e.g. User Authentication Flow")).fill("User Authentication");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Description$"))).getByRole(AriaRole.TEXTBOX).click();
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Description$"))).getByRole(AriaRole.TEXTBOX).fill("NA");
        page.getByPlaceholder("Project ID").click();
        page.getByPlaceholder("Project ID").fill("001");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("// Enter automation test")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("// Enter automation test")).fill("??NA");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Script")).click();
        System.out.println("Successfully clicked Create Script button");
    }

    public void DeveloperHub() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Developer Hub")).click();
        System.out.println("Successfully clicked Developer Hub button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connected Repositories")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Shared Resources &")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Repos").setExact(true)).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Docs")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("API Specs")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Architecture").setExact(true)).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Setup Guides")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Notes").setExact(true)).click();
    }

    public void Community() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Community")).click();
        System.out.println("Successfully clicked Community button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Post")).click();
        System.out.println("Successfully clicked Create Post button");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Post title")).click();

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Post title")).fill("URGENT MEETING ");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What's on your mind?")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What's on your mind?")).fill("All employees should present at 10.00 in Conference hall");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("testing, automation, bug, etc.")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("testing, automation, bug, etc.")).fill("ALL");
        page.locator("form").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Create Post")).click();
        System.out.println("Successfully  Create community Post ");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Create New Post$"))).getByRole(AriaRole.BUTTON).click();
    }

    public void Chat() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat")).click();
        System.out.println("Successfully clicked Chat button");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Filter people...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Filter people...")).fill("ir");
        System.out.println("Successfully clicked search people");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[2]/div[1]/div[4]/button").click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Irfxn...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Irfxn...")).fill("halooo");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
        System.out.println("Successfully clicked Send chat button");
    }

    public void NotesLeaderboard() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Notes & Resources")).click();
        System.out.println("successfully clicked Notes & Resources button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("⭐ Bookmarked Items")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Selenium")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Playwright")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("API Testing")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Leaderboard")).click();
        System.out.println("Successfully clicked Leaderboard button");
    }

    public void Users() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Users")).click();
        System.out.println("Successfully clicked Users button");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[2]/button[2]").click();
        System.out.println("successfully clicked All Users ");
    }

    public void Attendance() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Attendance")).click();
        System.out.println("Successfully clicked Attendance List");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div[2]/div/button[2]").click();
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div[2]/div/button[3]").click();
        System.out.println("Successfully work");
        page.getByRole(AriaRole.COMBOBOX).selectOption("ADMIN");
        page.getByRole(AriaRole.COMBOBOX).selectOption("MENTOR");
        page.getByRole(AriaRole.COMBOBOX).selectOption("TESTER");
        page.getByRole(AriaRole.COMBOBOX).selectOption("DEVELOPER");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[1]/div[2]/button[4]").click();
        System.out.println("Refresh th attendance list");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Previous Day")).click();
        System.out.println("Successfully clicked Previous Day attendence");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div[2]/div/button[1]").click();
        System.out.println("Successfully check all present");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div[2]/div/button[2]").click();
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div[2]/div/button[3]").click();
        page.getByRole(AriaRole.COMBOBOX).selectOption("ALL");
        page.getByRole(AriaRole.COMBOBOX).selectOption("ADMIN");
        page.getByRole(AriaRole.COMBOBOX).selectOption("MENTOR");
        page.getByRole(AriaRole.COMBOBOX).selectOption("TESTER");
        page.getByRole(AriaRole.COMBOBOX).selectOption("DEVELOPER");
        System.out.println("Successfully check All Attendance");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dashboard")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Refresh")).click();
        System.out.println("Successfully clicked Refresh Dashboard button");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).nth(1).click();
        System.out.println("Successfully clicked Logout button");
    }
    public void Createnewtester() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create account")).click();
        System.out.println("successfully clicked Create account button");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("John Doe")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("John Doe")).fill("Marco");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("you@example.com")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("you@example.com")).fill("marco@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min 6 characters")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min 6 characters")).fill("marco123");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Password$"))).getByLabel("Show password").click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm your password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm your password")).fill("marco123");
        page.getByRole(AriaRole.COMBOBOX).selectOption("TESTER");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send Join Request →")).click();
        System.out.println("successfully clicked Send Join Request button");
    }
    public void testeraccept() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("admin@testverse.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in →")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Attention indicator")).click();
        System.out.println("Successfully clicked Attention indicator button");
        page.locator("//*[@id=\"root\"]/div/div[2]/header/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/p[4]").click();
        System.out.println("successfully clicked review registration button");

        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Marco"))).isVisible();

        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div/div/div[2]/button[1]").click();
        System.out.println("successfully clicked Approve button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).nth(1).click();
    }
    public void Tester(){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("marco@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("marco123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in →")).click();
        System.out.println("successfully Enter marco tester");

        page.locator("//*[@id=\"root\"]/div/div[2]/header/div[2]/button[2]").click();
        System.out.println("successfully Completed Admin Module");

    }
    public void adminsentmessage(){
        page.getByPlaceholder("you@example.com")
                .fill("admin@testverse.com");
        System.out.println("Succesfully enter mail id");

        page.getByPlaceholder("Enter your password")
                .fill("admin123");
        System.out.println("Successfully entered valid password");

        page.locator("//*[@id=\"root\"]/div/div[11]/div[2]/div[2]/div[2]/div/div[6]/div/form/button")
                .click();
        System.out.println("Successfully clicked login button");
        System.out.println("successfully enter admin to send message to tester");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat")).click();
        System.out.println("Successfully clicked Chat button");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Filter people...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Filter people...")).fill("mar");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("M Marco Tester")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Marco...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Marco...")).fill("Hey ");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
        System.out.println("successfully send message to tester");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).nth(1).click();
        System.out.println("successfully clicked Logout button");

    }
    public void testercheckmessage(){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("marco@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("marco123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in →")).click();
        System.out.println("successfully login tester to Recieve message");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Notifications")).click();
        page.getByText("New Message").first().click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Admin User...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Admin User...")).fill("halooo");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
        System.out.println("successfully send replay message to admin");

    }
    public void testercheckall(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Dashboard")).click();
        System.out.println("successfully clicked Dashboard button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tasks")).click();
        System.out.println("successfully clicked Tasks button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Modules")).click();
        System.out.println("successfully clicked Modules button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bug Tracker")).click();
        System.out.println("successfully clicked Bug Trackers button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manual Testing")).click();
        System.out.println("successfully clicked Manual Testing button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("AutomationHub")).click();
        System.out.println("successfully clicked AutomationHub button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Community")).click();
        System.out.println("successfully clicked Community button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat Attention indicator")).click();
        System.out.println("successfully clicked Chat Attention indicator button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Notes & Resources")).click();
        System.out.println("successfully clicked Notes & Resources button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Leaderboard")).click();
        System.out.println("successfully clicked Leaderboard button");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("My Team")).click();
        System.out.println("successfully clicked My Team button");

    }
    public void createnewdeveloper() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create account")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("John Doe")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("John Doe")).fill("Alan");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("you@example.com")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("you@example.com")).fill("alanalan@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min 6 characters")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Min 6 characters")).fill("alan123");
        page.getByText("Confirm Password").click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm your password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Confirm your password")).fill("alan123");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Password$"))).getByLabel("Show password").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show password")).click();
        page.getByRole(AriaRole.COMBOBOX).selectOption("DEVELOPER");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send Join Request →")).click();
        System.out.println("succesfully create and send  new developer request");
    }
    public void developeraccept(){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("admin@testverse.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in →")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Attention indicator")).click();

        page.locator("//*[@id=\"root\"]/div/div[2]/header/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/p[4]").click();
        System.out.println("successfully view new developer request");
        System.out.println("admin see the request");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[3]/div/div/div[2]/button[1]").click();
        System.out.println("admin successfully approved the developer request");
    }
    public void developer(){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("alanalan@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("alan123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in →")).click();
        System.out.println("successfully enter new developer");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Active Today list")).click();
        System.out.println("successfully see active users");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Tasks")).click();
        System.out.println("successfully clicked Tasks ");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Modules")).dblclick();
        System.out.println("successfully clicked Modules");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bug Tracker")).click();
        System.out.println("successfully clicked Bug Tracker");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manual Testing")).click();
        System.out.println("successfully clicked Manual Testing");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Developer Hub")).click();
        System.out.println("successfully clicked Developer Hub");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Community")).click();
        System.out.println("successfully clicked Community");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Notes & Resources")).click();
        System.out.println("successfully clicked Notes & Resources");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Leaderboard")).click();
        System.out.println("successfully clicked Leaderboard");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("My Team")).click();
        System.out.println("successfully clicked My Team");

    }
    public void developersendmessage(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chat Attention indicator")).click();
        System.out.println("successfully clicked Chat Attention indicator");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Filter people...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Filter people...")).fill("mar");
        System.out.println("successfully clicked Filter people...");
        page.locator("//*[@id=\"root\"]/div/div[2]/main/div/div[2]/div[1]/div[4]/button/div[1]/div").click();
        System.out.println("successfully clicked M Marco Tester");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Marco...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Marco...")).fill("helooo");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
        System.out.println("successfully clicked Send message");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).nth(1).click();
        System.out.println("successfully clicked Logout");
    }
    public void marcosendmessage(){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Address")).fill("marco@gmail.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("marco123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Show password")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in →")).click();
        System.out.println("successfully clicked Sign in marco");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Notifications")).click();
        System.out.println("successfully clicked Notifications");
        page.locator(".lucide.lucide-message-square.text-\\[\\#0062E0\\]").first().click();
        System.out.println("successfully clicked recent message and see");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Alan...")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Alan...")).fill("haiiii");
        System.out.println("successfully enter Message Alan...");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
        System.out.println("successfully clicked Send replay message");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logout")).nth(1).click();
        System.out.println("successfully clicked Logout");

    }
}




