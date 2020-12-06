package rus.hititipi.trainingapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ActorAdapter : RecyclerView.Adapter<ActorHolder>() {

    /*private val RecyclerView.ViewHolder.context
        get() = this.itemView.context**/

    private var actors = listOf<Actor>()

    override fun getItemCount(): Int {
        return actors.size
    }

    private fun getItem(position: Int): Actor = actors[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        return ActorHolder(view)
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun bindActors(newActors: List<Actor>) {
        actors = newActors
        notifyDataSetChanged()
    }
}