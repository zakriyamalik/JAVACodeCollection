package q2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User {
    public String u_id;
    public String u_name;
    public String u_email;
    public String u_pass;
    ArrayList<post> posts=new ArrayList<>();
   // ArrayList<com> coms=new ArrayList<>();
    ArrayList<User> users=new ArrayList<>();

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }
    void addUser()
    {
        Scanner sc1=new Scanner(System.in);

        System.out.println("Enter id");
        String id=sc1.nextLine();
        System.out.println("Enter name");
        String name=sc1.nextLine();
        System.out.println("Enter email");
        String email=sc1.nextLine();
        System.out.println("Enter password");
        String password=sc1.nextLine();

        User u=new User();
        u.u_id=id;
        u.u_email=email;
        u.u_name=name;
        u.u_pass=password;

        post p=new post();
        p=p.addPost();

        u.posts.add(p);
        users.add(u);

    }
    void showUsers() {
        System.out.println("----- User List -----\n");

        for (User u : users) {
            System.out.println("User ID      : " + u.u_id);
            System.out.println("User Name    : " + u.u_name);
            System.out.println("User Email   : " + u.u_email);
            System.out.println("User Password: " + u.u_pass);
            System.out.println("----------------------");

            if (u.posts.isEmpty()) {
                System.out.println("No posts available for this user.\n");
            } else {
                System.out.println("Posts:");
                for (post p : u.posts) {
                    System.out.println("  Post ID    : " + p.getP_id());
                    System.out.println("  Post Body  : " + p.getP_body());
                    System.out.println("  ----------------------");

                    if (p.coms.isEmpty()) {
                        System.out.println("  No comments on this post.\n");
                    } else {
                        System.out.println("  Comments:");
                        for (int i = 0; i < p.coms.size(); i++) {
                            System.out.println("    Comment ID    : " + p.coms.get(i).getP_id());
                            System.out.println("    Comment Body  : " + p.coms.get(i).getC_body());
                            System.out.println("    ------------------");
                        }
                    }
                }
            }
            System.out.println("=========================================\n");
        }

        System.out.println("----- End of User List -----");
    }
}
