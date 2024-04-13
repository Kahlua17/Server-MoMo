package com.kahlua17.momo.domain.meeting.entity;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@RequiredArgsConstructor
@Document(collection = "meeting")
public class Meeting {

    @Id
    private String id;
    private final LocalDate dateTime;
    private final String locationDesc;
    private final List<String> memberIds;
}
