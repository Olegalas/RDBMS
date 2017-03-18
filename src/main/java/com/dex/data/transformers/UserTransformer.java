package com.dex.data.transformers;

import com.dex.data.dto.NotificationDTO;
import com.dex.data.dto.UserDTO;
import com.dex.data.model.User;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by dexter on 18.03.17.
 */
public class UserTransformer {

    public static final Function<User, UserDTO> toDTO = entity -> {
        UserDTO dto = new UserDTO();
        dto.id = entity.id;
        dto.login = entity.login;
        dto.notifications = entity.getNotifications().stream().map(NotificationTransformer.toDTO).collect(Collectors.toList());
        return dto;
    };

    public static final Function<UserDTO, User> toEntity = dto -> null;

}
