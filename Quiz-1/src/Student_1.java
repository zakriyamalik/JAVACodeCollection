public class Student_1 {
    private int id;
   private String name;
   private int age;
   public Student_1()
   {
       id=0;
       name="";
       age=0;
   }
   public Student_1(int id,String name, int age)
   {
       setId(id);
       setName(name);
       setAge(age);

   }
   public void setId(int id)
   {
       this.id=id;
   }
   public void setName(String name)
   {
       this.name=name;
   }
   public void setAge(int age)
   {
       this.age=age;
   }
   public int getId()
   {
       return id;
   }
   public String getName()
   {
       return name;
   }
   public int getAge()
   {
       return age;
   }
}
