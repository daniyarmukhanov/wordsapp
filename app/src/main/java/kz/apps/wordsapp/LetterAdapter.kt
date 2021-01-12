package kz.apps.wordsapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.apps.wordsapp.databinding.ItemViewBinding


class LetterAdapter : RecyclerView.Adapter<LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemViewBinding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return LetterViewHolder(itemViewBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.bind(list[position])
    }
}

class LetterViewHolder(private val binding: ItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(char: Char) {
        binding.buttonItem.text = char.toString()
    }
}
