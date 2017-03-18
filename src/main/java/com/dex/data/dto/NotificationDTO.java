package com.dex.data.dto;

import com.dex.data.model.Notification.Type;

/**
 * Created by dexter on 18.03.17.
 */
public class NotificationDTO {

    public long id;
    public String message;
    public Type type;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NotificationDTO{");
        sb.append("id=").append(id);
        sb.append(", message='").append(message).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
