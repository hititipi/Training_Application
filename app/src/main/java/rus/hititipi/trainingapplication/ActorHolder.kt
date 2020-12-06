package rus.hititipi.trainingapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val avatar: ImageView = itemView.findViewById(R.id.actor_avatar)
    private val name: TextView = itemView.findViewById(R.id.actor_name)

    fun bind(actor : Actor){
        avatar.setImageResource(actor.photoID)
        name.text = actor.name
    }
}