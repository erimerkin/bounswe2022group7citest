package com.group7.artshare.entity

import lombok.Data
import java.util.*
import javax.persistence.*

@Data
@Entity
class Comment {

    @Id
    @GeneratedValue
    var itemId: Long = 0L

    @Column
    var body : String = ""

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: Date = Calendar.getInstance().time

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "creator")
    var author : RegisteredUser? = null

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name="artItemId")
    var artItem : ArtItem? = null

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name="onlineGalleryId")
    var onlineGallery : OnlineGallery? = null

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name="discussionPostId")
    var discussionPost : DiscussionPost? = null

    @ManyToOne
    @JoinColumn(name="physicalExhibitionId")
    var physicalExhibition : PhysicalExhibition? = null


}