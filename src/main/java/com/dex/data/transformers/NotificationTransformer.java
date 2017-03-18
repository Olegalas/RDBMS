package com.dex.data.transformers;

import com.dex.data.dto.NotificationDTO;
import com.dex.data.model.Notification;

import java.util.function.Function;

/**
 * Created by dexter on 18.03.17.
 */
public class NotificationTransformer {

    public static final Function<Notification, NotificationDTO> toDTO = entity -> {
        NotificationDTO dto = new NotificationDTO();
        dto.id = entity.getId();
        dto.message = entity.getMessage();
        dto.type = entity.getType();

        return dto;
    };

}
