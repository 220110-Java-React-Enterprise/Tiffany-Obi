package Views;

import Views.View;
import Utils.ViewManager;

public class LoginView extends View {

    public LoginView(){
        viewName = "Views.LoginView";
        viewManager = ViewManager.getRenderer();
    }

    @Override
    public void renderView() {
        System.out.println("");

    }
}
