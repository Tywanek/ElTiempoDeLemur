package com.radlab.eltiempodelemur.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.radlab.eltiempodelemur.R
import com.radlab.eltiempodelemur.network.models.geoModels.Geoname
import kotlinx.android.synthetic.main.geo_adapter_list_item.view.*


class GeoAdapter(val items: List<Geoname>, val context: Context) : RecyclerView.Adapter<GeoAdapter.ViewHolder>() {

    var onItemClick: ((Geoname) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.geo_adapter_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name1.text = items[position].name
        holder.name2.text = items[position].toponymName
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name1 = itemView.geo_name
        val name2 = itemView.geo_toponym_name

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }
}