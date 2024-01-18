package study.datajpaprac.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpaprac.member.entity.Member;
import study.datajpaprac.team.entity.Team;

import java.util.List;

@SpringBootTest // spring bean을 인젝션 받아서 사용할 것이기 때문이 필요 !!!
class MemberTest {
    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    public void memberTest() throws Exception {
        /**
         * team 1, 2
         * member 1, 2, 3, 4
         */
        // given
        Team teamA = new Team();
        Team teamB = new Team();
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        // 초기화
        em.flush();
        em.clear();

        // do
        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        // then
        for (Member m: members) {
            System.out.println("member : " + m);
            System.out.println("member's team : " + m.getTeam());
        }
    }
}