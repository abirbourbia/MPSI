package com.example.carenta

// the user's metadata

class user(
    var id:Int,
    var fullname :String?,
    var phonenumber:String?,
    var password: String,
    var birthdate:String?,
    var creditcard:String?,
    var expirationdate:String?,
)
    : java.io.Serializable

