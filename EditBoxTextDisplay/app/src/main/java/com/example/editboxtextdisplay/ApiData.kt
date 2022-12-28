package com.example.editboxtextdisplay

class ApiData {
    companion object {
        const val count = 10
        val api by lazy { Connect.callApi() }
        var disposable: Disposable? = null
        fun apiData(callback:Response){
            disposable = api.getApi(count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                        result ->
                    callback.data(result,true)
                }, { error ->
                    error.printStackTrace()
                })

        }

    }
    interface Response {
        fun data(data:Model.Result,status:Boolean)
    }
}