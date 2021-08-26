package uz.texnopos.instagramprofileinfo.helper

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import uz.texnopos.instagramprofileinfo.model.Model
import uz.texnopos.instagramprofileinfo.retrofit.ApiInterface

class NetworkHelper(private val apiClient: Retrofit) {

    fun getData(listener: NetworkListener, username: String) {
        val call: Call<Model> = apiClient.create(ApiInterface::class.java).getData(username)
        call.enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>?, response: Response<Model>?) {
                listener.dataResponse(response?.body()!!.data)
            }
            override fun onFailure(call: Call<Model>?, t: Throwable?) {
                listener.dataFailure(t?.localizedMessage)
            }
        })
    }

}