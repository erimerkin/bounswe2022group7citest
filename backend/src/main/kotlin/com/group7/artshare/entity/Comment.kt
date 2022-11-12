package com.group7.artshare.entity

import com.fasterxml.jackson.annotation.*
import lombok.Data
import java.util.*
import javax.persistence.*

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
class Comment {

    @Id
    @GeneratedValue
    val id: Long = 0L

    @Column
    var text : String = ""

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var creationDate: Date = Calendar.getInstance().time

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    var lastEditDate: Date = Calendar.getInstance().time

    @Column
    var upvoteNo : Int = 0

    @Column
    var downvoteNo : Int = 0

    @OneToMany(orphanRemoval = true, cascade = [CascadeType.ALL])
    var reports: MutableList<Report> = mutableListOf()

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author")
    //@JsonBackReference
    var author : RegisteredUser? = null
}