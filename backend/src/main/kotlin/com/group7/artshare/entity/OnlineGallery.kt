package com.group7.artshare.entity

import lombok.Data
import java.util.ArrayList
import java.util.HashSet
import javax.persistence.*

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
class OnlineGallery : Event(){

    
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    var artItems: MutableSet<ArtItem> = mutableSetOf()

    @Column
    var platform: String = "ArtShare"

    @Column
    var externalUrl: String? = null
}