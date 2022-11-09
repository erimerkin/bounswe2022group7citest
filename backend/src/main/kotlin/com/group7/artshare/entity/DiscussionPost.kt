package com.group7.artshare.entity

import lombok.Data
import javax.persistence.*

@Data
@Entity
class DiscussionPost {

    @Id
    @GeneratedValue
    var itemId: Long = 0L

    @OneToMany(orphanRemoval = true, mappedBy = "discussionPost",  cascade = [CascadeType.ALL])
    var commentList: MutableSet<Comment> = mutableSetOf()

    fun addComment(comment:Comment){
        comment.discussionPost = this
        this.commentList.add(comment)
    }

    fun addComments(commentList : List<Comment>){
        for(comment in commentList){
            comment.discussionPost = this
        }
        this.commentList.addAll(commentList)
    }
}