package level3.best_album;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // 4, 1, 3, 0
        System.out.println(Arrays.toString(solution.solution(genres, plays)));
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            return IntStream.range(0, genres.length)
                    .mapToObj(i -> new Song(i, plays[i], genres[i]))
                    .collect(Collectors.groupingBy(Song::getGenre))
                    .entrySet()
                    .stream()
                    .sorted((a, b) ->
                            b.getValue()
                            .stream()
                            .map(Song::getPlayCount)
                            .mapToInt(i -> i)
                            .sum() -
                            a.getValue()
                                    .stream()
                                    .map(Song::getPlayCount)
                                    .mapToInt(i -> i)
                                    .sum())
                    .flatMapToInt(e -> e.getValue()
                            .stream()
                            .sorted()
                            .mapToInt(Song::getNo)
                            .limit(2L))
                    .toArray();
        }
    }

    static class Song implements Comparable<Song> {
        private final int no;
        private final int playCount;
        private final String genre;

        public Song(int no, int playCount, String genre) {
            this.no = no;
            this.playCount = playCount;
            this.genre = genre;
        }

        public int getNo() {
            return no;
        }

        public int getPlayCount() {
            return playCount;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "no=" + no +
                    ", playCount=" + playCount +
                    ", genre='" + genre + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Song song) {
            if (this.playCount == song.getPlayCount()) {
                return this.no - song.getNo();
            }
            return song.getPlayCount() - this.getPlayCount();
        }
    }
}
