package rus.hititipi.trainingapplication

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieHolder(iView: View) : RecyclerView.ViewHolder(iView) {

      private val poster: ImageView = itemView.findViewById(R.id.avengers_poster)
        private val age: TextView = itemView.findViewById(R.id.age)
        private val like: ImageView = itemView.findViewById(R.id.like)
        private val genre: TextView = itemView.findViewById(R.id.genres)
        private val ratng: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val reviews: TextView = itemView.findViewById(R.id.reviews)
        private val title: TextView = itemView.findViewById(R.id.card_title)
        private  val duration: TextView = itemView.findViewById(R.id.duration)

        fun bind(movie : Movie){
            poster.setImageResource(movie.posterID)
            age.setText(movie.age)
            title.setText(movie.title)
            genre.setText(movie.genre)
            ratng.rating = (movie.rating)
            reviews.setText(movie.reviews)
            duration.setText(movie.duration)
            if (movie.like){
                like.setImageResource(R.drawable.like)
            } else {
                like.setImageResource(R.drawable.no_like)
            }
        }

}