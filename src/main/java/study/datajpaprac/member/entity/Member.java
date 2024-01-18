package study.datajpaprac.member.entity;

import jakarta.persistence.*;
import lombok.*;
import study.datajpaprac.team.entity.Team;

/**
 * 순수 JPA
 * -> JPA Repository
 * -> JPQL, dsl
 */

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    /**
     * id, username, age, team
     * <p>
     * constructor
     * - username
     * - username, age
     * - username, age, team
     * <p>
     * method
     * changeTeam
     */

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)  // foreign key
    @JoinColumn(name = "team_id")
    private Team team;  // 연관관계 주인

    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;

        if (team != null) {
            chageTeam(team);
        }
    }

    private void chageTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}