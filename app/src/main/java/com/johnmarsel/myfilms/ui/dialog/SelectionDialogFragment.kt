package com.johnmarsel.myfilms.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SelectionDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val title = arguments?.getString(ARG_TITLE)

        return AlertDialog.Builder(requireContext())
            .setMessage(title)
            .setNeutralButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    companion object {

        const val ARG_TITLE = "title"
        const val FILM_DIALOG = "filmDialog"

        fun newInstance(filmTitle: String): SelectionDialogFragment {
            val args = Bundle().apply {
                putString(ARG_TITLE, filmTitle)
            }
            return SelectionDialogFragment().apply {
                arguments = args
            }
        }
    }
}