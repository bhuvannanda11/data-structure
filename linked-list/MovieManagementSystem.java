import java.util.*;
// Movie class representing a movie node in the doubly linked list
class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    Movie next;
    Movie prev;

    // Constructor to initialize the movie details
    public Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// MovieDoublyLinkedList class to manage movie records using doubly linked list
class MovieDoublyLinkedList {
    Movie head;
    Movie tail;

    // Constructor to initialize the doubly linked list
    public MovieDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a movie at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end of the list
    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position in the list
    public void addMovieAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        Movie temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newMovie.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newMovie;
        }
        temp.next = newMovie;
        newMovie.prev = temp;
    }

    // Remove a movie record by Movie Title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next; // update head if the movie is at the beginning
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev; // update tail if the movie is at the end
                }

                System.out.println("Movie removed: " + title);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie with title " + title + " not found.");
    }

    // Search for a movie record by Director
    public void searchMoviesByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Found Movie: " + temp.title + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found by director " + director);
        }
    }

    // Search for movies based on Rating
    public void searchMoviesByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Found Movie: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found with rating " + rating);
        }
    }

    // Update a movie's rating based on Movie Title
    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Updated movie " + title + " with new rating: " + newRating);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie with title " + title + " not found.");
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        if (head == null) {
            System.out.println("No movie records available.");
            return;
        }

        Movie temp = head;
        System.out.println("Movies (Forward Order):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        if (tail == null) {
            System.out.println("No movie records available.");
            return;
        }

        Movie temp = tail;
        System.out.println("Movies (Reverse Order):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

// Main class to test the implementation
public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        // Add movies to the list
        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addMovieAtPosition(2, "The Prestige", "Christopher Nolan", 2006, 8.5);

        // Display movies forward
        movieList.displayMoviesForward();

        // Search for movies by director
        movieList.searchMoviesByDirector("Christopher Nolan");

        // Search for movies by rating
        movieList.searchMoviesByRating(8.8);

        // Update movie rating
        movieList.updateMovieRating("Inception", 9.2);

        // Display movies forward after update
        movieList.displayMoviesForward();

        // Remove a movie by title
        movieList.removeMovieByTitle("Interstellar");

        // Display movies forward after removal
        movieList.displayMoviesForward();

        // Display movies in reverse order
        movieList.displayMoviesReverse();
    }
}
