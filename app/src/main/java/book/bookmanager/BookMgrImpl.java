package book.bookmanager;

import book.book.BookMgr;
import book.book.Book;
import book.magazine.Magazine;

import java.util.ArrayList;

public class BookMgrImpl implements BookMgr {
    private ArrayList<Book> bList;

    private static BookMgrImpl mgr = new BookMgrImpl();

    private BookMgrImpl() {
        bList = new ArrayList<>(); // 배열과 달리 사이즈 지정 안 해줘도 됨
    }

    public static BookMgrImpl getInstance() {
        return mgr;
    }

    // 1. 데이터 입력 기능
    public void addBook(Book nBook) {
        boolean find = true;
        for(Book b : bList) {
            if(b.getIsbn().equals(nBook.getIsbn())) {
                System.out.println("도서명 : "+nBook.getTitle()+", 이미 소장하고 있는 책입니다.");
                find = false;
                break;
            }
        }
        if(find == true) {
            bList.add(nBook);
            System.out.println("도서명 : " + nBook.getTitle()+", 성공적으로 추가되었습니다. ");
        }
    }

    // 2. 데이터 전체 검색 기능
    public ArrayList<Book> getAllBook(){
        return bList;
    }

    // 3. isbn으로 정보를 검색하는 기능
    public Book searchBookByIsbn(String isbn) {
        Book temp = new Book();
        for(Book b : bList) if(b.getIsbn().equals(isbn)) temp = b;
        return temp;
    }

    // 4. title로 정보를 검색하는 기능
    public ArrayList<Book> searchBookByTitle(String title){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : bList) if(b.getTitle().contains(title)) temp.add(b);
        return temp;
    }

    // 5. Book만 검색하는 기능
    public ArrayList<Book> onlySearchBook(){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : bList) {
            if(b instanceof Magazine) continue;
            else temp.add(b);
        }
        return temp;
    }

    // 6. Magazine만 검색하는 기능
    public ArrayList<Book> onlySearchMagazine(){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : bList) if(b instanceof Magazine) temp.add(b);
        return temp;
    }

    // 7. Magazine 중 올해 잡지만 검색하는 기능
    public ArrayList<Book> magazineOfThisYearInfo(int year){
        ArrayList<Book> temp = new ArrayList();
        for(Book b : bList) {
            if(b instanceof Magazine) {
                if(((Magazine) b).getYear() == year){
                    temp.add(b);
                }
            }
        }
        return temp;
    }

    // 8. 출판사로 검색하는 기능
    public ArrayList<Book> searchBookByPublisher(String publisher){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : bList) {
            if(b.getPublisher().equals(publisher)) temp.add(b);
        }
        return temp;
    }

    // 9. 가격으로 검색(인자로 주어진 가격보다 낮은 가격의 도서 검색)
    public ArrayList<Book> searchBookByPrice(int price){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : bList) {
            if(b.getPrice() < price) {
                temp.add(b);
            }
        }
        return temp;
    }

    // 10. 저장된 모든 도서의 금액의 합을 구하는 기능
    public int getTotalPrice() {
        int total = 0;
        for(Book b : bList) total += b.getPrice();
        return total;
    }

    // 11. 저장된 모든 도서의 금액 평균을 구하는 기능
    public int getAvgPrice() {
        return getTotalPrice() / bList.size();
    }
}
