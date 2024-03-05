package com.bangkit.submissionsatu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class AgentAdapter(private val agentList:ArrayList<Agent>)
    : RecyclerView.Adapter<AgentAdapter.agentViewHolder>(){
    class agentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imagaView : ImageView = itemView.findViewById(R.id.imageView)
        val nameView : TextView = itemView.findViewById(R.id.nameAgent)
        val explainView : TextView = itemView.findViewById(R.id.explanationAgent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): agentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return agentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return agentList.size
    }

    override fun onBindViewHolder(holder: agentViewHolder, position: Int) {
        val agent = agentList[position]
        holder.imagaView.load(agent.image){
            placeholder(R.drawable.loading_animation)
        }
        holder.nameView.text = agent.name
        holder.explainView.text = agent.explain
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.agentDetais, agentList[position])
            it.context.startActivity(intent)
        }
    }
}