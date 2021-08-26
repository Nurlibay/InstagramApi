package uz.texnopos.instagramprofileinfo.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import uz.texnopos.instagramprofileinfo.model.Model

interface ApiInterface {
    @Headers("x-rapidapi-key:2af141cbeemsh787f3b8bb13b2e7p138e0bjsnc483a79ed0cf")
    @GET("{username}/info")
    fun getData(@Path("username") username: String): Call<Model>
}