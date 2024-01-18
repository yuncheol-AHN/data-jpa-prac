package study.datajpaprac.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpaprac.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
