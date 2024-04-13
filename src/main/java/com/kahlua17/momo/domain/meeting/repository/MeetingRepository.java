package com.kahlua17.momo.domain.meeting.repository;

import com.kahlua17.momo.domain.meeting.entity.Meeting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeetingRepository extends MongoRepository<Meeting, String> {

}