package rus.hititipi.trainingapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), ChangeFragmentListener {

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
        if (fragmentName == FragmentMoviesDetails.NAME){
            supportFragmentManager.commit {
                add(R.id.main_container, FragmentMoviesDetails())
            }
        } else if (fragmentName == FragmentMoviesList.NAME){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, FragmentMoviesList())
                .addToBackStack(null)
                .commit()
        }
    }

}