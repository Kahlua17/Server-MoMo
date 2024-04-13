package com.kahlua17.momo.domain.meeting.service;

import com.kahlua17.momo.common.exception.NotFoundException;
import com.kahlua17.momo.domain.meeting.entity.Meeting;
import com.kahlua17.momo.domain.meeting.repository.MeetingRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public String createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting).getId();
    }

    public List<Meeting> getAllMeetings(String userId) {
        return meetingRepository.findByMemberIdsContaining(userId);
    }

    public Meeting joinMeeting(String userId, String meetingId) {
        Meeting meeting = getMeetingById(meetingId);
        meeting.getMemberIds().add(userId);
        meetingRepository.save(meeting);

        return meeting;
    }

    public Meeting getMeetingById(String meetingId) {
        return meetingRepository.findById(meetingId).orElseThrow(() -> new NotFoundException("Meeting not found"));
    }
}
