package com.codefarm.codefarmer.service.board;

import com.codefarm.codefarmer.domain.board.ReplyDTO;
import com.codefarm.codefarmer.entity.board.Reply;
import com.codefarm.codefarmer.repository.board.BoardRepository;
import com.codefarm.codefarmer.repository.board.ReplyRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final JPAQueryFactory jpaQueryFactory;
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

//    해당 보드에 게시글 추가하기
    public void replyAdd(ReplyDTO replyDTO){
        Reply reply = replyDTO.toEntity();
        reply.changeMember(replyDTO.getMemberId());
        reply.changeBoard(replyDTO.getBoardId());
        replyRepository.save(reply);
    }

//    댓글 수정하기
    public void replyUpdate(ReplyDTO replyDTO){
        Reply reply = replyRepository.findById(replyDTO.getReplyId()).get();
        reply.update(replyDTO);
    }

//    댓글 단 사람 닉네임 갖고오기기
    public String showReplyNickName(Long replyId){
        Reply reply = replyRepository.findById(replyId).get();

        return reply.getMember().getMemberNickname();
    }

//     내가 남긴 댓글 총 개수(전체)
    public Long showReplyAllCount(Long memberId){
       return replyRepository.countByMemberMemberId(memberId);
    }

//    내가 작성한 댓글 지우기
    public void removeReply(Long replyId){
        replyRepository.deleteById(replyId);
    }


}

















