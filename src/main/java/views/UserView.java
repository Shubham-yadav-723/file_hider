package views;

import java.util.Scanner;

public class UserView {
    private String email;

    public UserView(String email) {
        this.email = email;
    }

    public void home(){
        do{
            System.out.println("welcome"+this.email);
            System.out.println("Press 1 to show hidden files");
            System.out.println("Press 2 to hide a new file");
            System.out.println("Press 0 to exit");
            Scanner sc=new Scanner(System.in);
            int ch=Integer.parseInt(sc.nextLine());
            switch (ch){
                case 1->{}
            }

        }
    }
}
