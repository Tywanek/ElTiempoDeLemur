package com.radlab.eltiempodelemur.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class SearchItem() : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var name: String? = null
}