package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1. 회원 조회
        Member member = memberRepository.findById(memberId);

        //2. 할인
        int discountPrice = discountPolicy.discount(member,itemPrice);

        //3. 주문생성
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
