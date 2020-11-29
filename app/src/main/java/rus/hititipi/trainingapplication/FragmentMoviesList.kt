package rus.hititipi.trainingapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {

    private var changeFragmentListener: ChangeFragmentListener ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<CardView>(R.id.card_view).setOnClickListener {
            changeFragmentListener?.showFragment(FragmentMoviesDetails.NAME)
        }
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
        val NAME = "MoveList"
    }
}