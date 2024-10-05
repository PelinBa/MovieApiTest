package movie;

import base.BaseApiTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pb.model.Movie;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MovieApiTest extends BaseApiTest{

    private Gson gson;

    @BeforeEach
    void before() {
        gson = new Gson();
    }

    @AfterEach
    void after() {
        gson = null;
    }

    @Test
    @DisplayName("given movie path, when call movie list api, then check api status code, movie list size and name of the id 84")
    void test_movie_list_status_size_and_item() {
        // Given
        String pathMovies = "/api/movies";
        String expectedMovieName = "Jumanji: Welcome to the Jungle";
        int selectMovieId = 84;
        int expectedStatusCode = 200;
        int expectedListSize = 100;

        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(baseUrl)
                .header(header);

        // When
        Response response = requestSpecification
                .when()
                .get(pathMovies);

        // Then
        Type listType = new TypeToken<ArrayList<Movie>>(){}.getType();
        ArrayList<Movie> movieList = gson.fromJson(response.body().asString(), listType);
        Movie selectedMovie = null;

        for (Movie item : movieList) {
            if (item.getId() == selectMovieId) {
                selectedMovie = item;
                break;
            }
        }

        Assertions.assertEquals(expectedStatusCode, response.statusCode());
        Assertions.assertEquals(expectedListSize, movieList.size());
        assert selectedMovie != null;
        Assertions.assertEquals(expectedMovieName, selectedMovie.getMovie());
    }
}
