package com.kahlua17.momo.domain.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String uuid;
    private String nickname;
}