package oldEntriesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.grata.database.GratitudeEntry
import com.example.android.grata.databinding.ListItemEntryBinding
import com.example.android.grata.formatDate
import java.util.*

class GradEntryAdapter : ListAdapter<GratitudeEntry,
        GradEntryAdapter.ViewHolder>(GradEntryDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if( item != null)
            holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemEntryBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GratitudeEntry) {
            binding.entry = item
            binding.entryDateTv.text = formatDate(Calendar.getInstance().getTime())
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemEntryBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}


class GradEntryDiffCallback : DiffUtil.ItemCallback<GratitudeEntry>() {
    override fun areItemsTheSame(oldItem: GratitudeEntry, newItem: GratitudeEntry): Boolean {
        return oldItem.entryId == newItem.entryId
    }

    override fun areContentsTheSame(oldItem: GratitudeEntry, newItem: GratitudeEntry): Boolean {
        return oldItem == newItem
    }
}





