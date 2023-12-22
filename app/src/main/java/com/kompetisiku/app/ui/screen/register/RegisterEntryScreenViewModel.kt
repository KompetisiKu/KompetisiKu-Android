package com.kompetisiku.app.ui.screen.register

import androidx.lifecycle.ViewModel
import com.kompetisiku.app.ui.activity.register.RegisterViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterEntryScreenViewModel @Inject constructor(
    private val registerViewModel: RegisterViewModel
): ViewModel() {
    val count = registerViewModel.count

    fun inc() {
        registerViewModel.inc()
    }
}