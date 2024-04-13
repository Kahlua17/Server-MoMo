package com.kahlua17.momo.domain.meeting;

import com.kahlua17.momo.domain.meeting.entity.Meeting;
import com.kahlua17.momo.domain.meeting.service.MeetingService;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping("/meetings")
    public ResponseEntity createMeeting(
            @RequestHeader(value = "User-ID") String userId,
            @RequestParam("date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,
            @RequestParam(name = "location_desc") String locationDesc) {
        String meetingId = meetingService.createMeeting(new Meeting(date, locationDesc, List.of(userId)));

        return ResponseEntity.ok(Collections.singletonMap("id", meetingId));
    }
}
