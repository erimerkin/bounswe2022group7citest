package com.group7.artshare.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import lombok.Data
import java.util.*
import javax.persistence.*

@Data
@Entity
class AuctionInfo {

    @Id
    @GeneratedValue
    var id: Long = 0L

    @OneToOne(mappedBy = "auctionInfo", cascade = [CascadeType.ALL])
    @JsonBackReference
    var auction: Auction? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var startingDate: Date = Calendar.getInstance().time

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var endingDate: Date = Calendar.getInstance().time

    @Column
    var minimumPrice: Double = 0.0

    @Column
    var description: String? = null
}