package com.codefarm.codefarmer.service.Mentor;

import com.codefarm.codefarmer.domain.mentor.MentorBoardDTO;
import com.codefarm.codefarmer.entity.member.Farmer;
import com.codefarm.codefarmer.entity.mentor.MentorBoard;
import com.codefarm.codefarmer.repository.member.FarmerRepository;
import com.codefarm.codefarmer.service.mentor.MentorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MentorBoardServiceTest {

    @Autowired
    private MentorService mentorService;
    @Autowired
    private FarmerRepository farmerRepository;

    @Test
    public void mentorBoardAddTest(){
        MentorBoardDTO mentorBoardDTO = new MentorBoardDTO();
        Optional<Farmer> findMentor = farmerRepository.findById(14L);

        mentorBoardDTO.setMentorCareer("고구마 농사 멘토 활동중");
        mentorBoardDTO.setMentorExCareer("20회 이상 멘티 컨설팅 25년 다양한 작물 재배");
        mentorBoardDTO.setMentorStrongTitle1("20회 이상 멘티 가르침으로 생긴 노하우 전수");
        mentorBoardDTO.setMentorStrongContent1("2019년 44명 지정된 농업 마스터");
        mentorBoardDTO.setMentorStrongTitle2("내 강점 2");
        mentorBoardDTO.setMentorStrongContent2("내 강점 내용 2");
        mentorBoardDTO.setMentorStrongTitle3("내 강점 3");
        mentorBoardDTO.setMentorStrongContent3("내 강점 내용 3");
        mentorBoardDTO.setMentorTitle("딸기를 재배해보양");
        mentorBoardDTO.setMentorTitleSub("서브 배너 문구입니다.");
        mentorBoardDTO.setMentorTextTitle("텍스트 제목");
        mentorBoardDTO.setMentorTextContent("텍스트 내용");
        mentorBoardDTO.setMemberId(findMentor.get());
        mentorService.mentorBoardAdd(mentorBoardDTO);
    }

//    멘토 글 상세페이지에서 확인하기
    @Test
    public void showDetailMentorBoardTest(){
        mentorService.showDetailMentorBoard(65L);
        log.info("멘토상세 글 : " + mentorService.showDetailMentorBoard(65L));
    }

//    멘토 보드 지우기
    @Test
    public void removeMentorBoardTest(){
        mentorService.removeMentorBoard(47L);
    }

}
