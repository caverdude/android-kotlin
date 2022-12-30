package com.example.editboxtextdisplay

class UpcModel {
    data class Result(val data: Data)
    data class Data(val children: List<Children>)
    data class Children(val data: Datas)
    data class Datas(val barcode_number: String,val barcode_formats: String,
                     val mpn: String, val model: String, val asin: String,
                    val title: String, val category: String, val manufacturer: String,
                    val brand: String)
}