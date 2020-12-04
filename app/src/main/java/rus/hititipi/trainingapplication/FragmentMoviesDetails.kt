package rus.hititipi.trainingapplication

import android.content.Context
import android.graphics.Outline
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import rus.hititipi.trainingapplication.databinding.FragmentMoviesDetailsBinding

class FragmentMoviesDetails : Fragment() {

    private var changeFragmentListener: ChangeFragmentListener ?= null
    private lateinit var  binding: FragmentMoviesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = FragmentMoviesDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding.backButton.setOnClickListener{
            changeFragmentListener?.showFragment(FragmentMoviesList.NAME)
        }
        setConrnerRadius();
        return binding.root
    }

    fun setConrnerRadius(){
        setCornerRadius(binding.ChrisHemsworthImage, 4f)
        setCornerRadius(binding.ChrisEvansImage, 4f)
        setCornerRadius(binding.MarkRuffaloImage, 4f)
        setCornerRadius(binding.RobertDowneyImage, 4f)
    }

    fun setCornerRadius(view: ImageView, radius: Float) {
        view.outlineProvider = object : ViewOutlineProvider() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width, view!!.height, radius)
            }
        }
        view.clipToOutline = true
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
        const val NAME = "MoveDetails"
    }
}