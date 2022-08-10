package com.berkayatmali.project1.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkayatmali.project1.NewsDataModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val uiScope = CoroutineScope(Dispatchers.IO)
    val list: MutableLiveData<MutableList<NewsDataModel>> = MutableLiveData()
    val filteredList: MutableLiveData<MutableList<NewsDataModel>> = MutableLiveData()
    val aramaDegeri: MutableLiveData<String> = MutableLiveData()

    init {
        uiScope.launch {
            prepareList()
        }
    }

    fun prepareList(){
        val _list: MutableList<NewsDataModel> = mutableListOf()
        for (i in 1..999) {
            _list.add(NewsDataModel(i, i.toString(), "xxx", "SEN", 1, "CAT$i"))
            _list.add(NewsDataModel(i, i.toString(), "xxx", "BEN", 2, "DOG$i"))
            _list.add(NewsDataModel(i, i.toString(), "xxx", "DESC", 3, "FISH$i"))
            _list.add(NewsDataModel(i, i.toString(), "xxx", "DESC", 4, "BIRD$i"))
        }
        list.postValue(_list)
    }

    fun runFiltered(x: String?){
        if(x!=null) {
            val filtered = list.value?.filter {
                it.category.contains(x.toString())
            }
            filteredList.postValue(filtered?.toMutableList())
        }
    }
}