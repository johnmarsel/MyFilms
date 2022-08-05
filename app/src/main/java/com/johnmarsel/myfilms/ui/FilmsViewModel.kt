package com.johnmarsel.myfilms.ui

import androidx.lifecycle.ViewModel
import com.johnmarsel.myfilms.data.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val repository: FilmsRepository,
) : ViewModel() {
    // TODO: Implement the ViewModel
}