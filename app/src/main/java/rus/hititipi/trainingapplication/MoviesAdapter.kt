package rus.hititipi.trainingapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(
    var clickListener: OpenMovieListener?
    ) : RecyclerView.Adapter<MovieHolder>() {

    private val RecyclerView.ViewHolder.context
        get() = this.itemView.context


    var movies =  listOf<Movie>()

    override fun getItemCount(): Int {
        return movies.size
    }

    fun getItem(position: Int): Movie = movies[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            clickListener?.onClick(movies[position])
        }
    }

    fun bindMovies (newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }


}

