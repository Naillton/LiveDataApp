package com.example.livedataapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(initialValue: Int): ViewModel() {
    // definindo mutablelivedata, para trabalhar com dados.
    private var total: MutableLiveData<Int> = MutableLiveData<Int>()
    // variavei usada para acessar o valor do total
    // a varivel totalSum é imutavel e criamos ela para observar valores usando o get() = total
    // para acessar o valor da varivel total, logo apos definirmos o observador totalSum
    val totalSum: LiveData<Int>
    get() = total

    // inicializando valor passado por padrao que sera usado no ModelFactory
    init {
        this.total.value = initialValue
    }

    // funcao para adcionar valor a nossa varivel total
    fun setTotal(add: Int) {
        this.total.value = (this.total.value)?.plus(add)
    }
}