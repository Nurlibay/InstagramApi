package uz.texnopos.instagramprofileinfo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import uz.texnopos.instagramprofileinfo.databinding.ActivityProfileBinding
import uz.texnopos.instagramprofileinfo.helper.NetworkHelper
import uz.texnopos.instagramprofileinfo.helper.NetworkListener
import uz.texnopos.instagramprofileinfo.model.Data
import uz.texnopos.instagramprofileinfo.retrofit.ApiClient

class ProfileActivity : AppCompatActivity(), NetworkListener {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkHelper = NetworkHelper(ApiClient.getClient())
        val username = intent.getStringExtra("username")!!
        setData(username)
    }

    private fun setData(username: String){
        networkHelper.getData(this, username)
    }

    override fun dataResponse(model: Data) {
        Glide
            .with(this)
            .load(model.profile_picture.normal)
            .centerCrop()
            .into(binding.profileImage)

        binding.postCount.text = model.figures.posts.toString()
        binding.followersCount.text = model.figures.followers.toString()
        binding.followingCount.text = model.figures.followings.toString()
        binding.tvFullName.text = model.full_name
        binding.tvBioGraphy.text = model.biography
    }

    override fun dataFailure(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}