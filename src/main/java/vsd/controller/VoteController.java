package vsd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vsd.controller.vo.VoteVO;
import vsd.service.VoteService;

import java.util.List;

/**
 * @author JasonW
 * @date 2020/8/16
 */
@RestController
public class VoteController {
    private static final Logger logger = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    VoteService voteService;

    @PostMapping("/votes")
    public void addVote(@RequestBody VoteVO param) {
        voteService.addVote(param);
    }

    @GetMapping("/votes")
    public List<VoteVO> getVotes() {
        return voteService.getVotes();
    }

    @GetMapping("/votes/{voteId}")
    public VoteVO getVote(@PathVariable Long voteId) {
        return voteService.getVote(voteId);
    }
}
