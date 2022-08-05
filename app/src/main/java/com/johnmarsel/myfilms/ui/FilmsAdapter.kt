package com.johnmarsel.myfilms.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.johnmarsel.myfilms.data.Film
import com.johnmarsel.myfilms.databinding.ListItemFilmBinding

class FilmsAdapter: ListAdapter<Film, FilmsAdapter.FilmHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val binding = ListItemFilmBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FilmHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FilmHolder(private val binding: ListItemFilmBinding)
        : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(film: Film) {
            binding.film = film
        }

        override fun onClick(v: View) {
            /*
            val args = Bundle().apply {
                putInt(BOOK_ID, film.id)
            }
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment, args)

             */
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Film>() {

        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem == newItem
        }
    }
}