package com.example.editboxtextdisplay

class UpcModel {
    data class Result(val data: Data)
    data class Data(val children: List<Children>)
    data class Children(val data: Datas)
    data class Datas(val author: String,val thumbnail: String,val title: String)
}