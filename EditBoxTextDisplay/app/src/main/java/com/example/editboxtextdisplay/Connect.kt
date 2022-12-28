package com.example.editboxtextdisplay

class Connect {

    companion object {

        private fun getRetrofit(Url:String):Retrofit {
            return Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(Url)
                .build()
        }

        fun getApiData():Retrofit{
            val retrofitApi = getRetrofit(Url.BASE_URL)
            return retrofitApi
        }

        fun callApi():CallApi{
            val retrofitCall = getApiData()
            return retrofitCall.create(CallApi::class.java)
        }

    }
}