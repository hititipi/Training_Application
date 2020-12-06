package rus.hititipi.trainingapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rus.hititipi.trainingapplication.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var recycler: RecyclerView? = null
    private var clickListener: OpenMovieListener? = null
    private lateinit var binding: FragmentMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        createRecyclerView()
        return binding.root
    }

    private fun createRecyclerView(){
        recycler = binding.rvMovies
        recycler?.adapter = MovieAdapter(clickListener)
        val columns = getResources().getInteger(R.integer.movie_columns)
        recycler?.layoutManager = GridLayoutManager(context, columns)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OpenMovieListener) {
            clickListener = context
        }
    }

    override fun onStart() {
        super.onStart()

        updateData()
    }

    override fun onDetach() {
        recycler = null
        clickListener = null
        super.onDetach()
    }

    private fun updateData() {
        (recycler?.adapter as? MovieAdapter)?.apply {
            bindMovies(DataUtils.getMovies())
        }
    }

    companion object {
        const val NAME = "MoveList"
    }

}

