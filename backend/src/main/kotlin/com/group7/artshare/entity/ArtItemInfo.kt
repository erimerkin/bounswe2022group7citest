package com.group7.artshare.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import lombok.Data
import javax.persistence.*

@Data
@Entity
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
@JsonInclude(JsonInclude.Include.NON_NULL)
class ArtItemInfo {

    @Id
    @GeneratedValue
    var id: Long = 0L

    @OneToOne(mappedBy = "artItemInfo", cascade = [CascadeType.ALL])
    //@JsonBackReference(value = "info")
    var artItem: ArtItem? = null

    @Column
    var name: String? = null

    @Column
    var description: String? = null

    @Column
    var category: String? = null

    @Column
    var imageUrl: String? = null

    @Column
    var labels: String? = null
}