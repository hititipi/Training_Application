package rus.hititipi.trainingapplication

class DataUtils {

    fun getMovies(): List<Movie> {
        return listOf(
            Movie(R.drawable.poster_avengers, "Avengers: End Game", false,"13+", "Action, Adventure, Drama", 4f, "125", "137 min"),
            Movie(R.drawable.poster_tenet,"Tenet", true,"16", "Action, Sci-Fi, Thriller ", 5f, "98", "97 min"),
            Movie(R.drawable.poster_black_widow,"Black Widow", false,"13", "Action, Adventure, Sci-Fi", 4f, "38","102 min"),
            Movie(R.drawable.poster_wonder_women, "Wonder Woman 1984", false,"13", "Action, Adventure, Drama", 5f, "74", "120 min")
        )
    }


}