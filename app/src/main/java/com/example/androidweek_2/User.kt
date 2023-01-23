//package com.example.androidweek_2
package com.example.authapp

class User (fullName:String, eMail:String, numBer:String, passWord:String){
    public var fullName:String? = null
    public var eMail:String? = null
    public var numBer:String? = null
    public var passWord:String? = null

    /*
    public fun User()
    {

    }
    */

    init
    {
        this.fullName = fullName
        this.eMail = eMail
        this.numBer = numBer
        this.passWord = passWord
    }
}