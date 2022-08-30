package com.pr.kotlin_flow_stateflow_sharedflow_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    val livedata=MutableLiveData<String>()
    fun invokeLivedata(){
        livedata.value="Hello from LiveData"
    }

    val stateflow= MutableStateFlow("")
    fun invokestateflow(){
        stateflow.value="Hello from StateFlow"
    }

    val sharedFlow=MutableSharedFlow<String>()
     fun invokesharedflow(){
        viewModelScope.launch {

            sharedFlow.emit("Hello from SharedFlow")
        }
    }


    fun invokeflow():Flow<Int>{
        return flow {
           for (i in 0..10){
               delay(1000)
               emit(i)
           }

        }
    }



}