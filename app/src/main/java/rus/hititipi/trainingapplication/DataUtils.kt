package rus.hititipi.trainingapplication

class DataUtils {

    companion object {

        // actors
        private val robert_downey = Actor("Robert Downey Jr.", R.drawable.actor_robert_downey)
        private val chris_evans = Actor("Chris Evans", R.drawable.actor_chris_evans)
        private val mark_ruffalo = Actor("Mark Ruffalo", R.drawable.actor_mark_ruffalo)
        private val chris_hemsworth = Actor("Chris Hemsworth", R.drawable.actor_chris_hemsworth)

        // movies
        private val avengers = Movie(
            R.drawable.poster_avengers,
            "Avengers: End Game",
            false,
            "13+",
            "Action, Adventure, Drama",
            4f,
            "125",
            "137 min",
            listOf(robert_downey, chris_evans, mark_ruffalo, chris_hemsworth)
        )

        private val tenet = Movie(
            R.drawable.poster_tenet,
            "Tenet",
            true,
            "16+",
            "Action, Sci-Fi, Thriller ",
            5f,
            "98",
            "97 min",
            listOf()
        )

        private val black_widow = Movie(
            R.drawable.poster_black_widow,
            "Black Widow",
            false, "13+",
            "Action, Adventure, Sci-Fi",
            4f,
            "38",
            "102 min",
            listOf()
        )

        private val wonder_women = Movie(
            R.drawable.poster_wonder_women,
            "Wonder Woman 1984",
            false,
            "13+",
            "Action, Adventure, Drama",
            5f,
            "74",
            "120 min",
            listOf()
        )

        private val movies: HashMap<String, Movie> = hashMapOf(
            avengers.title to avengers,
            tenet.title to tenet,
            black_widow.title to black_widow,
            wonder_women.title to wonder_women
        )

        fun getMovies(): List<Movie> {
            return listOf(
                avengers,
                tenet,
                black_widow,
                wonder_women
            )
        }

        fun getMovie(title: String): Movie? {
            return movies.get(title)
        }

        fun getActors(movieTitle: String?): List<Actor> {
            val movie = movies.get(movieTitle)
            val actors = movie?.actors ?: listOf()
            return actors
        }
    }

}