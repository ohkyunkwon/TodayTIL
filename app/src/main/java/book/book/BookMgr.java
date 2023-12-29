package book.book;

import java.util.ArrayList;

/*
 * BookManager 인터페이스는 다양한 Book 객체들을 핸들링하는 템플릿 기능을 가지고 있다.
 */
public interface BookMgr {
    // 내가 마음대로 만들지 않고 배포된 템플릿을 가지고 커스터마이즈 한다.
    // 팀 작업할 때 회의해서 method identify를 결정. 같이 협업할 때
    // 인터페이스는 가장 강력한 표준화된 규약
    // 인터페이스 하나 주면 리턴 타입 뭘로 하고 이런 얘기 안해도 됨.

    void addBook(Book nBook);
    ArrayList<Book> getAllBook();
    Book searchBookByIsbn(String isbn);
    ArrayList<Book> searchBookByTitle(String title);
    ArrayList<Book> onlySearchBook();
    ArrayList<Book> onlySearchMagazine();
    ArrayList<Book> magazineOfThisYearInfo(int year);
    ArrayList<Book> searchBookByPublisher(String publisher);
    ArrayList<Book> searchBookByPrice(int price);
    int getTotalPrice();
    int getAvgPrice();

}
