package com.radlab.eltiempodelemur.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable

@RealmClass
open class SearchItem() : RealmObject(), Serializable {
    @PrimaryKey
    var id: Long = 0
    var name: String? = null
    var temperature: Int? = null
    var lat: Double? = null
    var lng: Double? = null

}