package rus.hititipi.trainingapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), ChangeFragmentListener {

    private val fragmentMoviesDetails = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.main_container, FragmentMoviesList())
            }
        }
    }

    override fun showFragment(fragmentName: String) {
        println(fragmentName)
        when (fragmentName){
            FragmentMoviesDetails.NAME ->
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.main_container, fragmentMoviesDetails).addToBackStack(null).commit()
            }
            FragmentMoviesList.NAME ->  supportFragmentManager.popBackStack()
        }
    }

}