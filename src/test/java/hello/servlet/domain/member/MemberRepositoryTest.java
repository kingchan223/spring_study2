package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    @DisplayName("저장된 멤버와 조회한 멤버가 같아야한다.")
    void save(){

        //given
        Member memberA = new Member("memberA", 20);

        //when
        Member saveMember = memberRepository.save(memberA);

        //then
        Member findMember = memberRepository.findById(memberA.getId());
        assertThat(saveMember).isSameAs(findMember);

    }

    @Test
    @DisplayName("모든 멤버 조회")
    void findAll(){

        //given
        Member memberA = new Member("memberA", 20);
        Member memberB = new Member("memberB", 22);

        //when
        Member saveMember1 = memberRepository.save(memberA);
        Member saveMember2 = memberRepository.save(memberB);

        //then
        List<Member> all = memberRepository.findAll();
        for (Member member : all) {
            System.out.println("member = " + member.getUsername());
        }
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(memberA, memberB); //all에 memberA, memberB가 있나?
    }
}
