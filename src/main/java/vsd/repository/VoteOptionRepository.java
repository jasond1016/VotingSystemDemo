package vsd.repository;

import org.springframework.data.repository.CrudRepository;
import vsd.entity.VoteOption;

import java.util.List;

/**
 * @author JasonW
 * @date 2020/8/16
 */
public interface VoteOptionRepository extends CrudRepository<VoteOption, Long> {
    List<VoteOption> findByVoteIdOrderByOptionSeq(Long voteId);
}
