package rus.hititipi.trainingapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {

    private var changeFragmentListener: ChangeFragmentListener ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            changeFragmentListener?.showFragment(FragmentMoviesList.NAME)
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
        val NAME = "MoveDetails"
    }
}