package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 할인이 10% 적용되어야한다.")
    void vip_o(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        int discount = discountPolicy.discount(member, 15000);
        Assertions.assertThat(discount).isEqualTo(1500);
    }

    @Test
    @DisplayName("VIP는 할인이 10% 적용되면 안된다.")
    void vip_x(){
        //given
        Long memberId = 2L;
        Member member = new Member(memberId,"memberA", Grade.NORMAL);
        int discount = discountPolicy.discount(member, 15000);
        Assertions.assertThat(discount).isEqualTo(0);
    }

}