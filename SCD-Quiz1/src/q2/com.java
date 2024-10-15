package q2;

import java.util.Scanner;

public class com {
    private String p_id;
    private String u_id;
    private String c_body;

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

    public String getC_body() {
        return c_body;
    }

    public void setC_body(String c_body) {
        this.c_body = c_body;
    }
    public com addComment()
    {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter post id");
        String p_id=sc1.nextLine();
        System.out.println("Enter user id");
        String u_id=sc1.nextLine();

        System.out.println("Enter comment\n");
        String comment=sc1.nextLine();
        this.c_body=comment;
        this.p_id=p_id;
        this.u_id=u_id;
        return this;
    }
}
