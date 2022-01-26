package Views;

import Utils.ViewManager;

public class CreateAccountView extends View{

    public CreateAccountView(){
        viewName = "CreateAccountView";
        viewManager = ViewManager.getRenderer();
    }

    @Override
    public void renderView() {
        System.out.println("In the Create Account View");
        viewManager.quit();

    }
}
