package com.group7.artshare.entity

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.annotation.ObjectIdGenerators.*
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.Data
import java.util.*
import javax.persistence.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue


@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
class ArtItem{

    @Id
    @GeneratedValue
    var id: Long = 0L

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "artItemInfo", referencedColumnName = "id")
    //@JsonManagedReference(value = "info")
    var artItemInfo: ArtItemInfo? = null

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "creator")
    //@JsonBackReference(value = "creator")
    var creator: Artist? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var creationDate: Date = Calendar.getInstance().time

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "owner")
    var owner: RegisteredUser? = null

    @Column
    var onAuction: Boolean = false

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "auction", referencedColumnName = "id")
    //@JsonManagedReference(value = "auctioned-item")
    var auction: Auction? = null

    @Column
    var lastPrice: Double = 0.0;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var commentList: MutableList<Comment> = mutableListOf()

/*
    @ManyToMany(mappedBy = "bookmarkedArtItems",cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    var bookmarkedBy: MutableSet<RegisteredUser> = mutableSetOf()
*/
}