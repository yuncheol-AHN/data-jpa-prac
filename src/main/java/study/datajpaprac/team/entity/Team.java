package study.datajpaprac.team.entity;

import jakarta.persistence.*;
import lombok.*;
import study.datajpaprac.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    /**
     * id, name, members
     *
     * constructor
     * - name
     */

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")   // LAZY (default), join colomn (x)
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
