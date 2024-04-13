package com.kahlua17.momo.domain.meeting.service;

import com.kahlua17.momo.domain.meeting.entity.Meeting;
import com.kahlua17.momo.domain.meeting.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public String createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting).getId();
    }
}
