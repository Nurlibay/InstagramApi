package uz.texnopos.instagramprofileinfo.helper

import uz.texnopos.instagramprofileinfo.model.Data

interface NetworkListener {
    fun dataResponse(model: Data)
    fun dataFailure(msg: String?)
}