package q2;

import java.util.ArrayList;
import java.util.Scanner;

public class post {
    private String p_id;
    private String u_id;
    private String p_body;
    ArrayList<com> coms=new ArrayList<>();

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getP_body() {
        return p_body;
    }

    public void setP_body(String p_body) {
        this.p_body = p_body;
    }
    public post addPost()
    {
        Scanner sc1=new Scanner(System.in);

        System.out.println("Enter post id");
        String p_id=sc1.nextLine();
        System.out.println("Enter user id");
        String u_id=sc1.nextLine();

        System.out.println("Enter post\n");
        String post=sc1.nextLine();
        this.p_body=post;
        this.p_id=p_id;
        this.u_id=u_id;
        com com=new com();
        com=com.addComment();
        coms.add(com);
        return this;


    }

}
