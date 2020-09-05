package vsd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vsd.controller.vo.VoteVO;
import vsd.entity.Vote;

import java.util.List;

/**
 * @author JasonW
 * @date 2020/8/16
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {
    @Query("select v from Vote v left join VoteOption vo on v.id = vo.voteId")
    List<VoteVO> findAllVotes();
}
