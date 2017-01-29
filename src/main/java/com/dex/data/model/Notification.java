package com.dex.data.model;

import javax.persistence.*;

/**
 * Created by dexter on 29.01.17.
 */

@Entity
@Table(name = "notification")
public class Notification {

    public enum Type{
        INFO, WARN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "message")
    private String message;

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private User user;


    public Notification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Notification{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", message='").append(message).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", user=").append(user.getLogin());
        sb.append('}');
        return sb.toString();
    }
}
