package com.example.presentation.ui.historicalForecast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.ForecastForLastFiveDays
import com.example.presentation.R
import com.example.presentation.databinding.ForecastItemBinding
import com.example.presentation.utils.AutoUpdatableAdapter
import com.example.presentation.utils.Contacts
import com.example.presentation.utils.getImageUrl
import com.example.presentation.utils.loadAsyncImage
import kotlin.properties.Delegates


class HistoricalAdapter(val clickListener: (ForecastForLastFiveDays) -> Unit) : RecyclerView.Adapter<HistoricalAdapter.DataViewHolder>(),
    AutoUpdatableAdapter {

    var items: List<ForecastForLastFiveDays> by Delegates.observable(emptyList()) {
            prop, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    inner class DataViewHolder(val binding: ForecastItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(forecastData: ForecastForLastFiveDays?) {

            forecastData?.let {data ->
                binding.apply {

                    title1.text = data.date
                    title2.text = data.main
                    title3.text = data.description

                    val imageUrl = getImageUrl(data.icon)
                    icon.loadAsyncImage(imageUrl)
                }
                itemView.setOnClickListener { clickListener(data) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemBinding: ForecastItemBinding = ForecastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemBinding)
    }
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(items[position])
    }

}
