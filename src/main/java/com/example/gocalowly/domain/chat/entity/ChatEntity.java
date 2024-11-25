package com.example.gocalowly.domain.chat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_message")
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int chatNo;

    private String userNickname;
    private LocalDateTime chatDate;
    private String content;
    private int groupNo;

    public ChatEntity() {
    }

    public ChatEntity(String userNickname, String content, int groupNo) {
        super();
        this.userNickname = userNickname;
        this.chatDate = LocalDateTime.now();
        this.content = content;
        this.groupNo = groupNo;
    }

    public int getChatNo() {
        return chatNo;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public LocalDateTime getchatDate() {
        return chatDate;
    }

    public String getContent() {
        return content;
    }

    public int getGroupNo() {
        return groupNo;
    }

    @Override
    public String toString() {
        return "ChatEntity [chatNo=" + chatNo + ", userNickname=" + userNickname + ", chatDate=" + chatDate
                + ", content=" + content + ", groupNo=" + groupNo + "]";
    }

}
