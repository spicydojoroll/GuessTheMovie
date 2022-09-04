import java.io.File;
import java.util.Scanner;

/**
 * Created by Donasia "Dojo" Brown
 * Project: GuessTheMovie
 * Date: 8/18/2022
 * Time: 19:39
 * Title:
 */

public class MoviePicker {

    public String pickAMovie() throws Exception {
        //Open the movies file
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        // Count the number of movies
        int numberOfMovies = 0;
        while (scanner.hasNextLine()) {
            String movie = scanner.nextLine();
            numberOfMovies++;
        }

        // Choose a random movie based on the total number of movies
        int movieIndex = (int) (Math.random() * numberOfMovies);
        Scanner chooser = new Scanner(file);
        String chosenMovie = "";
        for (int i = 0; i <= movieIndex; i++) {
            chosenMovie = chooser.nextLine();
        }

        return chosenMovie;
    }
}