package kz.apps.wordsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.apps.wordsapp.databinding.ItemViewBinding

class WordAdapter(private val letterId: String, context: Context) :
    RecyclerView.Adapter<WordViewHolder>() {

    private val filteredWords: List<String>

    init {
        val words = context.resources.getStringArray(R.array.words).toList()
        filteredWords = words
            .filter { it.startsWith(letterId, ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return WordViewHolder(binding)
    }

    override fun getItemCount(): Int = filteredWords.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = filteredWords[position]
        holder.bind(item)
    }

}

class WordViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(word: String) {
        binding.buttonItem.text = word
    }
}