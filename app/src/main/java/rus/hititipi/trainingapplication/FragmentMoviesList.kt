package rus.hititipi.trainingapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import rus.hititipi.trainingapplication.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {

    private var changeFragmentListener: ChangeFragmentListener ?= null
    private lateinit var binding: FragmentMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = FragmentMoviesListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding.cardView.setOnClickListener {
            changeFragmentListener?.showFragment(FragmentMoviesDetails.NAME)
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChangeFragmentListener) {
            changeFragmentListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        changeFragmentListener = null
    }

    companion object {
        const val NAME = "MoveList"
    }
}