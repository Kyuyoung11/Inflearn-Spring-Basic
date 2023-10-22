package hello.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberServiceTest {
    MemberService memberServcie = new MemberServiceImpl();
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberServcie.join(member);
        Member findMember = memberServcie.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }
}
