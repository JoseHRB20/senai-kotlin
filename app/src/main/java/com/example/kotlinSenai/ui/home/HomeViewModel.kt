package com.example.kotlinSenai.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bem vindo!"
    }
    private val welcomeTxt = MutableLiveData<String>().apply {
        value = "Olá"
    }

    val texto: LiveData<String> = welcomeTxt
    val text: LiveData<String> = _text
}