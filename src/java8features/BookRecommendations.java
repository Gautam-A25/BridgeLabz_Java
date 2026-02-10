package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class BookRecommendations {

    static class Book {
        String title;
        String author;
        String genre;
        double rating;

        Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
    }

    static class BookRecommendation {
        String title;
        double rating;

        BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }

        double getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return title + " (Rating: " + rating + ")";
        }
    }

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.6),
                new Book("1984", "George Orwell", "Dystopian", 4.7),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.5)
        );

        List<BookRecommendation> recommendations =
                books.stream()
                        .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                        .map(b -> new BookRecommendation(b.title, b.rating))
                        .sorted(Comparator.comparing(BookRecommendation::getRating).reversed())
                        .limit(10)
                        .collect(Collectors.toList());

        int pageSize = 5;
        int page = 1;

        System.out.println("Book Recommendations (Page " + page + "):");
        recommendations.stream()
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
    }
}
