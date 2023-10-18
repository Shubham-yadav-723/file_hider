package views;

import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOtpService;
import service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

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
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter your email");
        String email=sc.nextLine();
        String genOTP= GenerateOTP.getOTP();
        System.out.println(genOTP);
        SendOtpService.sendOTP(email,genOTP);
        System.out.println("Enter the otp: ");
        String otp=sc.nextLine();
        if(otp.equals(genOTP)){
            User user= new User(name,email);
            int response= UserService.saveUser(user);
            switch (response){
                case 1-> System.out.println("User Registered");
                case 0-> System.out.println("email already exist");
            }
        }else {
            System.out.println("Incorrect otp");
        }


    }

    private void login() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email= sc.nextLine();
        try {
            if(UserDAO.isExist(email)){
                String genOTP= GenerateOTP.getOTP();
                SendOtpService.sendOTP(email,genOTP);
                System.out.println("Enter the otp: ");
                String otp=sc.nextLine();
                if(otp.equals(genOTP)){
                    new UserView(email).home();

                }else {
                    System.out.println("Incorrect otp");
                }

            }
            else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
