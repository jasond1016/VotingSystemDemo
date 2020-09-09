package vsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vsd.entity.Vote;

import java.util.List;

/**
 * @author JasonW
 * @date 2020/8/16
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {
    /**
     * 获取用户创建的所有投票
     *
     * @param creator 用户ID
     * @return 投票结果
     */
    List<Vote> findByCreator(Long creator);
}
