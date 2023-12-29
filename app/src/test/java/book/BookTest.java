package book;

import book.book.Book;
import book.bookmanager.BookMgrImpl;
import book.magazine.Magazine;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {// 소장책 DB

        ArrayList<Book> bs = new ArrayList<>();

        bs.add(new Book("9788937485619", "잃어버린 시간을 찾아서", "마르셀 프루스트", "민음사", 8500.0, "『타임스』, 『르 몽드』 선정 20세기 최고의 책"));
        bs.add(new Book("9788954620512", "데미안", "헤르만 헤세", "민음사", 8500.0, "불안한 젊음에 바치는 영혼의 자서전"));
        bs.add(new Magazine("9788954620260", "어린이 과학동아", "편집부", "동아사이언스", 8500.0, "초등학생을 위해 한달에 두 번 발행하는 과학만화 잡지", 2020, 3));
        bs.add(new Book("9771975252008", "시간 가게", "이나영", "문학동네", 9900.0, "제 13회 문학동네 어린이 문학상 수상작"));
        bs.add(new Magazine("9771228402006", "씨네21", "편집부", "씨네21", 3800.0, "대한민국의 영화 전문 잡지", 2020, 4));
        bs.add(new Magazine("9771227130009", "뉴턴", "편집부", "아이뉴턴", 12000.0, "한중일에서 동시에 발행되고 있는 세계적인 과학 전문지", 2019, 11));
        bs.add(new Book("9788937460586", "싯다르타", "헤르만 헤세", "민음사", 6300.0, "헤세가 소설로 형상화한 부처의 생애"));
        bs.add(new Book("9788937460586", "싯다르타", "헤르만 헤세", "민음사", 6300.0, "헤세가 소설로 형상화한 부처의 생애"));

        printBooks(bs);
    }


    public static void printBooks(ArrayList<Book> bs) {// 출력 메소드

        BookMgrImpl service = BookMgrImpl.getInstance();

        // 메인 메소드의 배열에서 받아온 소장책 객체들을 service에 있는 ArrayList에 추가함
        for(Book b : bs) {
            System.out.println(b);
            service.addBook(b);
        }

        boolean menu = true; // 메뉴 스위치
        while(menu == true) { // 메뉴 스위치가 켜져있는 동안 무한반복
            System.out.println("===============================");
            System.out.println("S 전자 오픈 도서관 관리 페이지입니다.");
            System.out.println("1. 조회하기");
            System.out.println("2. 추가하기");
            System.out.println("3. 책 찾기");
            System.out.println("4. 전체책 가격 합계 및 평균 조회");
            System.out.println("===============================");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt(); // 메뉴 번호 입력

            // 1. 조회하기
            if(choice == 1) {
                System.out.println("===============================");
                System.out.println("어떤 방법으로 책을 조회하겠습니까?");
                System.out.println("1. 도서관 전체 소장책 조회하기");
                System.out.println("2. 일반도서만 조회하기(잡지 제외)");
                System.out.println("3. 잡지만 조회하기(일반도서 제외)");
                System.out.println("===============================");
                sc.nextLine();
                int search = sc.nextInt();
                if(search == 1) System.out.println(service.getAllBook());
                else if(search == 2) System.out.println(service.onlySearchBook());
                else if(search == 3) System.out.println(service.onlySearchMagazine());
            }

            // 2. 추가하기
            if(choice == 2) {
                System.out.println("ISBN을 입력하세요.");
                String isbn = sc.next();
                System.out.println("책 제목을 입력하세요."); sc.nextLine();
                String title = sc.nextLine();
                System.out.println("작가를 입력하세요.");
                String author = sc.nextLine();
                System.out.println("출판사를 입력하세요.");
                String publisher = sc.nextLine();
                System.out.println("가격을 입력하세요.");
                Double price = sc.nextDouble(); sc.nextLine();
                System.out.println("간단한 설명을 입력하세요.");
                String desc = sc.nextLine();
                System.out.println("일반도서이면 true, 잡지이면 false를 입력하세요.");
                Boolean bkOrMaga = sc.nextBoolean();
                if(bkOrMaga.equals(true)) {
                    service.addBook(new Book(isbn, title, author, publisher, price, desc));
                }
                else if(bkOrMaga.equals(false)) {
                    System.out.println("출간연도를 입력하세요.");
                    int year = sc.nextInt();
                    System.out.println("출간월을 입력하세요.");
                    int month = sc.nextInt();
                    service.addBook(new Magazine(isbn, title, author, publisher, price, desc, year, month));
                }
            }

            // 3. 책 찾기
            if(choice == 3) {
                System.out.println("===============================");
                System.out.println("어떤 방법으로 책을 찾겠습니까?");
                System.out.println("1. ISBN으로 책 찾기");
                System.out.println("2. 책 제목으로 책 찾기");
                System.out.println("3. 출간연도로 잡지 찾기");
                System.out.println("4. 출판사로 책 찾기");
                System.out.println("5. 특정 가격 밑으로 책 찾기");
                System.out.println("6. 이전으로");
                System.out.println("===============================");
                sc.nextLine();
                int search = sc.nextInt();

                if(search == 1) { // ISBN으로 책 찾기
                    System.out.println("ISBN을 입력하세요.");
                    String isbn = sc.next(); sc.nextLine();
                    System.out.println(service.searchBookByIsbn(isbn));
                }
                else if(search == 2) { // 책 제목으로 책 찾기
                    System.out.println("책 제목을 입력하세요.");  sc.nextLine();
                    String title = sc.nextLine();
                    System.out.println(service.searchBookByTitle(title));
                }
                else if(search == 3) { // 출간연도로 잡지 찾기
                    System.out.println("출간연도를 입력하세요.(올해 --> 2020)");
                    int year = sc.nextInt();
                    System.out.println(service.magazineOfThisYearInfo(year));
                }
                else if(search == 4) { // 4. 출판사로 책 찾기
                    System.out.println("출판사를 입력하세요.");
                    String publisher = sc.next();
                    System.out.println(service.searchBookByPublisher(publisher));
                }
                else if(search == 5) { // 5. 특정 가격 밑으로 책 찾기
                    System.out.println("가격을 입력하세요.");
                    int price = sc.nextInt(); sc.nextLine();
                    System.out.println(service.searchBookByPrice(price));
                }
                else if(search == 6) menu = true; // 6. 이전으로
                else System.out.println("잘못 입력하셨습니다.");
            }

            // 4. 전체책 가격 합계 및 평균 조회
            if(choice == 4) {
                System.out.println("전체책 가격 합계 : " + service.getTotalPrice());
                System.out.println("전체책 가격 평균 : " + service.getAvgPrice());
            }

        }

    }

}



