package study.datajpaprac.team.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import study.datajpaprac.team.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamRepository {

    private final EntityManager em;

    /**
     * method
     * - save return Team
     * - delete return void
     * - findAll return List<Team>
     * - findById return Optional<Team>
     * - count return Long
     * - find return Team
     */

    /**
//     * final : 수정할 수 없다. 상속 불가.
//     * -> 값이 필수다.
//     * -> 초기화 값이 필수다.
     */



    public Team save(Team team) {

        em.persist(team);
        return team;
    }

    public void delete(Team team) {
        em.remove(team);
    }

    public List<Team> findAll() {
        return em.createQuery("select t from Team t", Team.class)
                .getResultList();
    }

    public Optional<Team> findById(Long id) {
        Team team = em.find(Team.class, id);
        return Optional.ofNullable(team);
    }

    public Long count() {
        return em.createQuery("select count(t) from Team t", Long.class)
                .getSingleResult();
    }
}
