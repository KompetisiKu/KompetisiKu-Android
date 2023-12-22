package com.kompetisiku.app.ui.activity.register

import androidx.lifecycle.ViewModel
import com.kompetisiku.app.domain.repository.KompetisiKuRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegisterViewModel @Inject constructor(
    private val repository: KompetisiKuRepository
) : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    fun inc() {
        _count.value++
    }
}