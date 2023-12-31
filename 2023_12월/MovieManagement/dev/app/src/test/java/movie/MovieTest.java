package movie;

import movie.service.MovieMgrImpl;
import movie.vo.Movie;

import java.util.Arrays;
import java.util.Scanner;

public class MovieTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<<영화 관리 프로그램>>");
        //getInstance()로 MovieMgr 객체 받아옴..
        MovieMgrImpl mvManager = MovieMgrImpl.getInstance();

        boolean flag = true;
        while(flag) {
            System.out.println("1. 영화 정보 입력");
            System.out.println("2. 영화 정보 전체 검색");
            System.out.println("3. 영화명 검색");
            System.out.println("4. 영화 감독별 검색");
            System.out.println("5. 영화 장르별 검색");
            System.out.println("6. 영화 정보 삭제");
            System.out.println("0. 종료");

            int selectNum = sc.nextInt();
            switch(selectNum) {
                case 1:
                    System.out.print("영화 명을 입력해주세요 : ");
                    String mvName = sc.next();
                    System.out.print("감독 명을 입력해주세요 : ");
                    String mvDir = sc.next();
                    System.out.print("등급을 입력해주세요 : ");
                    int mvGr = sc.nextInt();
                    System.out.print("장르를 입력해주세요 : ");
                    String mvGre = sc.next();
                    System.out.print("요약을 입력해주세요 : ");
                    String mvSumm = sc.next();
                    mvManager.add(new Movie(mvName, mvDir, mvGr, mvGre, mvSumm));
                    System.out.println("성공적으로 추가되었습니다.");
                    break;
                case 2:
                    System.out.println(Arrays.toString(mvManager.search()));
                    break;
                case 3:
                    System.out.println("찾고자하는 제목을 입력하세요 : ");
                    mvName = sc.next();
                    System.out.println(Arrays.toString(mvManager.search(mvName)));
                    break;
                case 4:
                    System.out.println("찾고자하는 감독을 입력하세요 : ");
                    mvName = sc.next();
                    System.out.println(Arrays.toString(mvManager.searchDirector(mvName)));
                    break;
                case 5:
                    System.out.print("찾고자하는 장르를 입력하세요 : ");
                    sc.nextLine();
                    mvGre = sc.next();
                    System.out.println(Arrays.toString(mvManager.searchGenre(mvGre)));
                    break;
                case 6:
                    System.out.print("삭제하고자하는 제목을 입력하세요 : ");
                    mvName = sc.next();
                    mvManager.delete(mvName);
                    System.out.println("삭제완료");
                    break;
                case 0:
                    flag=false;
                    break;
            }
        }
    }

}