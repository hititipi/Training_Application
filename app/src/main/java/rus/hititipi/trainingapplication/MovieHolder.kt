package rus.hititipi.trainingapplication

import android.graphics.Outline
import android.os.Build
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class MovieHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val poster: ImageView = itemView.findViewById(R.id.avengers_poster)
    private val age: TextView = itemView.findViewById(R.id.age)
    private val like: ImageView = itemView.findViewById(R.id.like)
    private val genre: TextView = itemView.findViewById(R.id.genres)
    private val ratng: RatingBar = itemView.findViewById(R.id.ratingBar)
    private val reviews: TextView = itemView.findViewById(R.id.reviews)
    private val title: TextView = itemView.findViewById(R.id.card_title)
    private val duration: TextView = itemView.findViewById(R.id.duration)

    fun bind(movie: Movie) {
        poster.setImageResource(movie.posterID)
        setCornerRadius(poster, 4f)
        age.text = movie.age
        title.text = movie.title
        genre.text = movie.genre
        ratng.rating = (movie.rating)
        reviews.text = movie.reviews
        duration.text = movie.duration
        if (movie.like) {
            like.setImageResource(R.drawable.like)
        } else {
            like.setImageResource(R.drawable.no_like)
        }
    }

    private fun setCornerRadius(view: ImageView, radius: Float) {
        view.outlineProvider = object : ViewOutlineProvider() {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, view!!.width, view.height, radius)
            }
        }
        view.clipToOutline = true
    }

}