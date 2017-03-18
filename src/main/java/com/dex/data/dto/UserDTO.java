package com.dex.data.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dexter on 18.03.17.
 */
public class UserDTO {

    public long id;
    public String login;
    public List<NotificationDTO> notifications = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", notifications=").append(notifications);
        sb.append('}');
        return sb.toString();
    }
}
