package Views;

import Utils.ViewManager;
import Views.View;

public class WelcomeView extends View {

    public WelcomeView(){
    viewName = "WelcomeView";
    viewManager = ViewManager.getRenderer();
    }


    @Override
    public void renderView() {
        System.out.println("===== WELCOME TO FIRST NATIONAL REVATURE BANK =====");
        System.out.println("=== Are you a new or existing customer ===");
        System.out.println(" Select from the following\n" +
                "1. New Custumer \n" +
                "2. Existing Customer \n" +
                "==========================================");
        String readLine = viewManager.getScanner().nextLine();


        switch (readLine){
            case "1":
                viewManager.navigate("RegistrationView");
                break;
            case "2":
                viewManager.navigate("LoginView");
                break;

            default:
                System.out.println("Sorry invalid input!");
                break;
        }
    }
}
