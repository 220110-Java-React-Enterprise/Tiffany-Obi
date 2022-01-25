package Views;

import Views.View;
import Utils.ViewManager;

public class MainView extends View {

    public MainView(){
        viewName = "MainView";
        viewManager = ViewManager.getRenderer();
    }

    @Override
    public void renderView() {

        System.out.println("======= M A I N   V I E W =======");
        System.out.println("");

    }
}
