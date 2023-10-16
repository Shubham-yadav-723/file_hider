package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Welcome {
    public void welcomeScreen(){
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the application");
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to Sign up");
        System.out.println("Press 0 to exit");

        int choice=0;
        try{
            choice =Integer.parseInt(bf.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (choice){
            case 1 -> login();
            case 2 -> signUp();
            case 0-> System.exit(0);
        }

    }

    private void signUp() {
    }

    private void login() {

    }
}
