package com.kahlua17.momo.domain.meeting;

import com.kahlua17.momo.domain.meeting.entity.Meeting;
import com.kahlua17.momo.domain.meeting.service.MeetingService;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    public static class CreateMeetingResponse {
        public final String id;

        public CreateMeetingResponse(String id) {
            this.id = id;
        }
    }

    @PostMapping("/meetings")
    public CreateMeetingResponse createMeeting(
            @RequestHeader(value = "User-ID") String userId,
            @RequestParam("date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,
            @RequestParam(name = "location_desc") String locationDesc) {
        Meeting meeting = new Meeting(date, locationDesc, Set.of(userId), 0);

        String meetingId = meetingService.createMeeting(meeting);

        return new CreateMeetingResponse(meetingId);
    }

    public static class GetMeetingResponse {
        public final String id;
        public final LocalDate date;
        public final String locationDesc;
        public final int totalMemberCount;
        public final int totalExpenditure;
        public final String weekday;
        public final int dDay;

        public GetMeetingResponse(Meeting meeting) {
            this.id = meeting.getId();
            this.date = meeting.getDate();
            this.locationDesc = meeting.getLocationDesc();
            this.totalMemberCount = meeting.getMemberIds().size();
            this.totalExpenditure = meeting.getTotalExpenditure();
            this.weekday = meeting.getDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
            this.dDay = (int) ChronoUnit.DAYS.between(LocalDate.now(), meeting.getDate());
        }
    }

    @GetMapping("/meetings")
    public List<GetMeetingResponse> getMeetings(
            @RequestHeader(value = "User-ID") String userId) {
        List<Meeting> meetings = meetingService.getAllMeetings(userId);

        return meetings.stream()
                .map(GetMeetingResponse::new)
                .sorted(Comparator.comparingInt(m -> m.dDay))
                .collect(Collectors.toList());
    }

    @PostMapping("/meetings/join")
    public Object joinMeeting(
            @RequestHeader(value = "User-ID") String userId,
            @RequestParam(name = "meeting_id") String meetingId) {
        Meeting meeting = meetingService.joinMeeting(userId, meetingId);

        return new GetMeetingResponse(meeting);
    }

    @GetMapping("/meetings/{meeting_id}")
    public Object getMeetings(
            @RequestHeader(value = "User-ID") String userId,
            @PathVariable(name = "meeting_id") String meetingId) {
        Meeting meeting = meetingService.getMeetingById(meetingId);

        return new GetMeetingResponse(meeting);
    }
}
