package vsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsd.controller.vo.VoteOptionVO;
import vsd.controller.vo.VoteVO;
import vsd.entity.Vote;
import vsd.entity.VoteOption;
import vsd.repository.VoteOptionRepository;
import vsd.repository.VoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author JasonW
 * @date 2020/8/16
 */
@Service
public class VoteService {
    @Autowired
    VoteRepository voteRepository;

    @Autowired
    VoteOptionRepository voteOptionRepository;

    public void addVote(VoteVO vo) {
        Vote vote = new Vote();
        vote.setTitle(vo.getTitle());
        vote.setType(vo.getType());
        // TODO：creator
        vote.setCreator(1L);
        vote.setEndTime(vo.getEndTime());
        voteRepository.save(vote);
        vo.getVoteOptions().forEach(v -> {
            VoteOption voteOption = new VoteOption();
            voteOption.setOptionSeq(v.getOptionSeq());
            voteOption.setDescription(v.getDescription());
            voteOptionRepository.save(voteOption);
        });
    }

    public List<VoteVO> getVotes() {
        List<VoteVO> voteVos = new ArrayList<>();
        // TODO: creator
        List<Vote> votes = voteRepository.findByCreator(1L);

        votes.forEach(vote -> {
            VoteVO voteVO = new VoteVO();
            List<VoteOption> voteOptions = voteOptionRepository.findByVoteIdOrderByOptionSeq(vote.getId());
            List<VoteOptionVO> voteOptionVos = new ArrayList<>();
            voteOptions.forEach(voteOption -> {
                VoteOptionVO voteOptionVO = new VoteOptionVO();
                convert(voteOption, voteOptionVO);
                voteOptionVos.add(voteOptionVO);
            });
            voteVO.setType(vote.getType());
            voteVO.setTitle(vote.getTitle());
            voteVO.setEndTime(vote.getEndTime());
            voteVO.setVoteOptions(voteOptionVos);
            voteVos.add(voteVO);
        });
        return voteVos;
    }

    private void convert(VoteOption voteOption, VoteOptionVO voteOptionVO) {
        voteOptionVO.setDescription(voteOption.getDescription());
        voteOptionVO.setOptionSeq(voteOption.getOptionSeq());
    }

    public VoteVO getVote(Long voteId) {
        VoteVO voteVo = new VoteVO();
        Optional<Vote> vote = voteRepository.findById(voteId);
        if (vote.isPresent()) {
            transfer(vote.get(), voteVo);
            List<VoteOption> voteOptions = voteOptionRepository.findByVoteIdOrderByOptionSeq(voteId);
            List<VoteOptionVO> vovos = new ArrayList<>();
            voteOptions.forEach(voteOption -> {
                VoteOptionVO vovo = new VoteOptionVO();
                vovo.setOptionSeq(voteOption.getOptionSeq());
                vovo.setDescription(voteOption.getDescription());
                vovos.add(vovo);
            });
            voteVo.setVoteOptions(vovos);
            return voteVo;
        } else {
            return new VoteVO();
        }
    }

    private void transfer(Vote vote, VoteVO voteVo) {
        voteVo.setType(vote.getType());
        voteVo.setTitle(vote.getTitle());
        voteVo.setEndTime(vote.getEndTime());
    }
}
