package com.johnmarsel.myfilms.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.johnmarsel.myfilms.R

class FilmDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val filmTitle = arguments?.getString(ARG_TITLE)
        val context = requireContext()

        return AlertDialog.Builder(context)
            .setMessage(context.getString(R.string.dialog_title, filmTitle))
            .setNeutralButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    companion object {

        const val ARG_TITLE = "title"
        const val FILM_DIALOG = "filmDialog"

        fun newInstance(filmTitle: String): FilmDialogFragment {
            val args = Bundle().apply {
                putString(ARG_TITLE, filmTitle)
            }
            return FilmDialogFragment().apply {
                arguments = args
            }
        }
    }
}