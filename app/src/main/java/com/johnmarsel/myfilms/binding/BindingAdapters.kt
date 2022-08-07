package com.johnmarsel.myfilms.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.johnmarsel.myfilms.R
import com.johnmarsel.myfilms.data.model.Actor

@BindingAdapter("initialsFromName")
fun getInitialsFromName(view: TextView, fullName: String?) {
    if (!fullName.isNullOrEmpty()) {
        val (first, patronymic, last) = fullName.split(" ")
        view.text = view.context.getString(R.string.initials, last, first[0], patronymic[0])
    }
}

@BindingAdapter("namesOfActors")
fun getNamesOfActors(view: TextView, actors: List<Actor>?) {
    if (!actors.isNullOrEmpty()) {
        val names = mutableListOf<String>()
        actors.toSet().forEach {
            names.add(it.actorName)
        }
        view.text = names.joinToString(separator = ", ")
    }
}

