package movie.service;

import movie.vo.Movie;

import java.util.Arrays;

public class MovieMgrImpl implements MovieMgr {
    private Movie[ ] movies = new Movie[100];
    private int index;
    private static MovieMgrImpl mgr = new MovieMgrImpl();
    private MovieMgrImpl() {}
    public static MovieMgrImpl getInstance() {
        return mgr;
    }
    //싱글톤...MovieMgr을 mgr이름으로 객체 생성...getInstance로 생성한 객체를 받아온다.

    //영화 정보 추가하기
    public void add(Movie m) {
        movies[index++] = m;
    }

    // 영화 정보 모두 검색하기
    public Movie[] search() {
        Movie[] ms = new Movie[index];
        for(int i = 0; i < index; i++) {
            if(movies[i] != null) {
                ms[i] = movies[i];
            }
        }
        return ms;
    }

    // 영화 제목으로 영화 찾기
    // equals()가 아닌 contains()로 키워드가 포함되면 검색에 걸림
    public Movie[] search(String title) {
        int i = 0; int count = 0;
        Movie[] ms = new Movie[index];
        for(Movie m : movies) {
            if(m == null) continue;
            else if(m.getTitle().contains(title)) {
                ms[i++] = m;
                count++;
            }
        }

        //null 값을 추리기 위해서 다시 for문을 동작시킴.
        Movie[] ms2 = new Movie[count];
        if(count > 0) System.arraycopy(ms, 0, ms2, 0, count);
        return ms2;
    }

    // 감독명으로 영화 찾기
    public Movie[] searchDirector(String name) {
        int size = 0;
        for(int i = 0; i < index; i++) {
            if(movies[i] == null) continue;
            else if(movies[i].getDirector().equals(name)) size++; //2
        }
        Movie[] ms = new Movie[size];
        for(int i = 0; i < index; i++) {
            if(movies[i].getDirector().equals(name)) {
                ms[--size] = movies[i];
                //뒤에서부터 하나씩 넣어주는 것. ms[1], ms[0]
            }
        }
        return ms;
    }

    // 장르로 영화 찾기
    public Movie[] searchGenre(String genre) {
        int count = 0; int i = 0;
        Movie[] ms = new Movie[index];
        for(Movie m : movies) {
            if(m == null) continue;
            else if(m.getGenre().equals(genre)) {
                ms[i++] = m;
                count++;
            }
        }
        Movie[] ms2 = new Movie[count];
        for(int j = 0; j < count; j++) {
            ms2[j] = ms[j];
        }
        return ms2;
    }

    // 이름으로 영화 정보 삭제하기
    public void delete(String title) {
        int count = 0;
        for(Movie m : movies) {
            if(m == null) continue;
            else if(m.getTitle().equals(title)) count++;
        }
        Movie[] ms = new Movie[index-count];
        int idx = 0;
        for(Movie m : movies) {
            if(m == null) continue;
            else if(m.getTitle().equals(title)) continue;
            else ms[idx++] = m;
        }
        System.out.println(Arrays.toString(ms));
    }

    // 배열의 길이
    public int getSize() {
        return index;
    }
}