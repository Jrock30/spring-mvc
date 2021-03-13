package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    // 싱글턴 이기 때문에 불러지지 않음 (생성자를 막아 놓음), 스프링을 쓰면 직접 구현안해도 된다. 스프링이 싱글턴 보장해줌.
//    MemberRepository memberRepository = new MemberRepository();
    MemberRepository memberRepository = MemberRepository.getInstance();
    
    // 각 테스트 끝나면 실행된다.(초기화)
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }
    
    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findByid(saveMember.getId());
        // assertJ
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        // static import 사용 Assertions
        assertThat(result.size()).isEqualTo(2);
        // 객체를 포함하는지 확인
        assertThat(result).contains(member1, member2);
    }
}