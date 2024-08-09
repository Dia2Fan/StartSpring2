package hello.core.member;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //DIP위반 MemberServiceImpl 클래스가 구현체와 인터페이스 모두 의존하고 있음
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }//추상화에만 의존하여 DIP을 지키고 OCP를 지키게 됨(생성자 생성할때 memberRepository 받음)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
