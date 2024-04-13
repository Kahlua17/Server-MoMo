package com.kahlua17.momo.domain.meeting.repository;

import com.kahlua17.momo.domain.meeting.entity.Meeting;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeetingRepository extends MongoRepository<Meeting, String> {

    List<Meeting> findByMemberIdsContaining(String memberId);
}