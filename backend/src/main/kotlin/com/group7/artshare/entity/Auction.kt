package com.group7.artshare.entity

import com.fasterxml.jackson.annotation.*
import lombok.Data
import javax.persistence.*


@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
class Auction {
    @Id
    @GeneratedValue
    val id: Long = 0L

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "auctionInfo", referencedColumnName = "id")
    //@JsonManagedReference
    var auctionInfo: AuctionInfo? = null

    @OneToOne(mappedBy = "auction", cascade = [CascadeType.ALL])
    //@JsonBackReference(value = "auctioned-item")
    var itemOnSale: ArtItem? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator")
    var creator: Artist? = null

    @Column
    var isActive: Boolean = true

    @Column
    var markedAsSold: Boolean = false

    @OneToMany(orphanRemoval = true, cascade = [CascadeType.ALL])
    var bids: MutableList<Bid> = mutableListOf()
}