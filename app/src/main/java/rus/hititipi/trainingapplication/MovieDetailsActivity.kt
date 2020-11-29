package rus.hititipi.trainingapplication

import android.graphics.Outline
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setConrnerRadius();
    }

    fun setConrnerRadius(){
        setCornerRadius(findViewById(R.id.ChrisHemsworth_image), 4f)
        setCornerRadius(findViewById(R.id.CrisEvans_image), 4f)
        setCornerRadius(findViewById(R.id.MarkRuffalo_image), 4f)
        setCornerRadius(findViewById(R.id.RobertDowney_image), 4f)
    }

    fun setCornerRadius(view: View, radius: Float) {
        view.outlineProvider = object : ViewOutlineProvider() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width, view!!.height, radius)
            }
        }
        view.clipToOutline = true
    }
}