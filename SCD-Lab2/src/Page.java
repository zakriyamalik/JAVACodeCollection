public class Page {
    private int pageNumber;
    private String content;

    public Page(int pageNumber)
    {
        this.pageNumber = pageNumber;

    }
    public Page(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;

    }
    public int getPageNumber() {
        return pageNumber;

    }
    public String getContent() {
        return content;

    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;

    }
    public void setContent(String content) {
        this.content = content;
    }
    public void print() {
        System.out.println("Content is :");
        for(int i=0;i<this.getPageNumber();i++)
        {
            System.out.println(this.content+this.pageNumber);
        }
    }

    public static void main(String[] args) {
//        Page page = new Page("Page1", "Content1");
//        System.out.println(page.getPageNumber());
//        System.out.println(page.getContent());

    }
}
