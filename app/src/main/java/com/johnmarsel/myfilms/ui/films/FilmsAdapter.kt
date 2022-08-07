package com.johnmarsel.myfilms.ui.films

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.johnmarsel.myfilms.data.model.Film
import com.johnmarsel.myfilms.databinding.ListItemFilmBinding

typealias ClickFilmAction = (title: String) -> Unit

class FilmsAdapter(val films: List<Film>,
                   val clickFilmAction: ClickFilmAction?
                   ) : RecyclerView.Adapter<FilmsAdapter.FilmHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        return FilmHolder(ListItemFilmBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(films[position])
    }

    override fun getItemCount(): Int = films.size

    inner class FilmHolder(private val binding: ListItemFilmBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Film) {
            binding.apply {
                clickListener = createOnClickListener(item.title)
                film = item
                executePendingBindings()
            }
        }

        private fun createOnClickListener(title: String): View.OnClickListener {
            return View.OnClickListener {
                clickFilmAction?.let {
                    it(title)
                }
            }
        }
    }
}