package com.example.editboxtextdisplay

interface CallApi {

    @GET(Url.URL)
//query needed if there is any query
    fun getApi(@Query("limit") limit: Int):
//model class is needed
            Observable<Model.Result>
}