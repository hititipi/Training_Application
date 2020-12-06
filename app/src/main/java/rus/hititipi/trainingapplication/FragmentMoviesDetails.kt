package rus.hititipi.trainingapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rus.hititipi.trainingapplication.databinding.FragmentMoviesDetailsBinding

class FragmentMoviesDetails : Fragment() {

    private var recycler: RecyclerView? = null
    private var changeFragmentListener: ChangeFragmentListener ?= null
    private lateinit var  binding: FragmentMoviesDetailsBinding
    private var movieTitle : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = FragmentMoviesDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        movieTitle = arguments?.getString(MOVIE_KEY)

        binding.backButton.setOnClickListener{
            changeFragmentListener?.showFragment(FragmentMoviesList.NAME)
        }


        setMovieDetails()
        this.createRecyclerView()
        return binding.root
    }

    private fun setMovieDetails(){
        val movie : Movie? = DataUtils.getMovie(movieTitle!!)
        if (movie != null) {
            binding.movieNameText.text = movie.title
            binding.ageText.text = movie.age
            binding.genreText.text = movie.genre
            binding.ratingBar.rating = movie.rating
            binding.reviewsText.text = movie.reviews
        }
    }

    private fun createRecyclerView(){
        recycler = binding.rvActors
        recycler?.adapter = ActorAdapter()
        recycler?.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChangeFragmentListener) {
            changeFragmentListener = context
        }
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? ActorAdapter)?.apply {
            bindActors(DataUtils.getActors(movieTitle))
        }
    }


    override fun onDetach() {
        super.onDetach()
        changeFragmentListener = null
        recycler = null
    }

    companion object {
        const val NAME = "MoveDetails"
        const val MOVIE_KEY = "_movie_key"

        fun newInstance(movie: Movie): FragmentMoviesDetails {
            val args = Bundle()
            args.putString(MOVIE_KEY, movie.title)
            val fragment = FragmentMoviesDetails()
            fragment.arguments = args
            return fragment
        }

    }
}