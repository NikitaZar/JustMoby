package ru.nikitazar.justmoby.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.nikitazar.justmoby.dto.CategoryData
import ru.nikitazar.justmoby.repository.Repository
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val data: LiveData<List<CategoryData>>
        get() = _data
    private val _data = MutableLiveData<List<CategoryData>>()

    init {
        getList()
    }

    private fun getList() = viewModelScope.launch {
        _data.value = repository.getList()
    }
}