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
    val artItems: MutableSet<ArtItem> = mutableSetOf()

    @Column
    val platform: String = "ArtShare"

    @Column
    val externalUrl: String? = null
}