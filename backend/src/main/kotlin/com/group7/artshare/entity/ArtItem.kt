package com.group7.artshare.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import lombok.Data;
import java.util.*
import javax.persistence.*;

@Data
@Entity
class ArtItem{

    @Id
    @GeneratedValue
    var id: Long = 0L

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "artItemInfo")
    @JsonManagedReference
    var artItemInfo: ArtItemInfo? = null

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "creator")
    var creator: Artist? = null

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var creationDate: Date = Calendar.getInstance().time

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "owner")
    var owner: RegisteredUser? = null

    @Column
    var onAuction: Boolean = false

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "auction")
    var auction: Auction? = null //TODO: when Auction class is filled, the annotation will be arranged such that orphanremoval is false

    @Column
    var lastPrice: Double = 0.0;

    @OneToMany(orphanRemoval = true, mappedBy = "artItem", cascade = [CascadeType.ALL])
    var commentList: MutableSet<Comment> = mutableSetOf()

    @ManyToMany(mappedBy = "bookmarkedArtItems",cascade = [CascadeType.ALL])
    var bookmarkedBy: MutableSet<RegisteredUser> = mutableSetOf()

    fun addComment(comment:Comment){
        comment.artItem = this
        this.commentList.add(comment)
    }

    fun addComments(commentList : List<Comment>){
        for(comment in commentList){
            comment.artItem = this
        }
        this.commentList.addAll(commentList)
    }

}