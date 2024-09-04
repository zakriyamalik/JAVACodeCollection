import java.util.Scanner;

public class Book {
    private String title;
    private int totalPages;
    private Page[] pages;
    public Book(){
        this.title = "";
        this.totalPages = 0;
        this.pages = new Page[totalPages];

    }
    public Book(String title, int totalPages)
    {
        this.title = title;
        this.totalPages = 0;
        this.pages = new Page[totalPages];

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Page[] getPages() {
        return pages;
    }
    public void setPages(Page[] pages) {
        this.pages = pages;
    }
    public void addPages()
    {

        setTotalPages(++totalPages);
        Page[] newPages = new Page[totalPages];
        for (int i = 0; i < totalPages - 1; i++) {
            newPages[i] = this.pages[i];  // Copy existing pages to the new array
        }
        newPages[totalPages - 1] = new Page(totalPages);  // Create the new page
        pages = newPages;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter content for page " + totalPages + ": ");
        String content = sc.nextLine();
        pages[totalPages - 1].setContent(content);


    }

    public void pageInc()
    {
        for(int i = 0; i < totalPages; i++)
        {

            System.out.println(pages[i].getContent()+pages[i].getPageNumber());
        }
    }
    @Override
    public String toString() {
        return "Book [title=" + title + ", totalPages=" + totalPages + "]";
    }
    public static void main(String[] args) {
        Book book = new Book();


        int choice=0;
        do {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter (1) to add Page \nEnter (2) to leave\n");
            choice = sc.nextInt();
            if (choice == 1) {
                book.addPages();
                book.pageInc();
            }

        }while (choice != 2);


//        else if(choice == 2)
//        {
//            book.pageInc();
//
//            int size=0;
//            size=book.getTotalPages();
//            if(size>0)
//            {
//                for(int i=0;i<book.getTotalPages();i++)
//                {
//                    System.out.println(book.getPages()[i]);
//                }
//            }
//            else
//            {
//
//                System.out.println("No page found");
//            }


        }



//        book.addPages();
//        String result=book.toString();
//        System.out.println(result);





}

