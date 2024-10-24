package com.hrsh.analoghh.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrsh.analoghh.domain.Offer
import com.hrsh.analoghh.domain.Response
import com.hrsh.analoghh.domain.SubscribeResponseUseCase
import com.hrsh.analoghh.domain.Vacancy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val subscribeResponseUseCase: SubscribeResponseUseCase
): ViewModel() {
    private val _offers: MutableStateFlow<List<Offer>> = MutableStateFlow(emptyList())
    val offers: StateFlow<List<Offer>> = _offers.asStateFlow()

    private val _vacancies: MutableStateFlow<List<Vacancy>> = MutableStateFlow(emptyList())
    val vacancies: StateFlow<List<Vacancy>> = _vacancies.asStateFlow()

    init {
        viewModelScope.launch {
            _vacancies.value = subscribeResponseUseCase.invoke().vacancies
            _offers.value = subscribeResponseUseCase.invoke().offers
        }
    }
}