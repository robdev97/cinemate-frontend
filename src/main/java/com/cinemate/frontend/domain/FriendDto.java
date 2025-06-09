package com.cinemate.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendDto {

    private Long id;
    private Long userId;
    private Long friendUserId;
    private String status;
}