package Utils;

import Views.View;

import java.util.Scanner;


public class ViewManager {

    private static ViewManager viewManager;
    private boolean running;
    public Scanner scanner;

    CustomArrayList<View> viewList;
    View nextView;

    private ViewManager(){
        running = true;
        scanner = new Scanner(System.in);
        viewList = new CustomArrayList<>();
    }

    public static ViewManager getRenderer(){
        if (viewManager == null){
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void registerView(View view){
        viewList.add(view);
    }

    public void navigate(String destination){
        for(View view: viewList){
            if(view.getViewName().equals(destination)){
                nextView = view;
            }
        }
    }

    public void renderView(){
        nextView.renderView();
    }


    public Scanner getScanner(){
        return scanner;
    }

    public boolean quit(){
        return running = false;
    }

    public boolean isRunning(){
        return running;
    }



}
