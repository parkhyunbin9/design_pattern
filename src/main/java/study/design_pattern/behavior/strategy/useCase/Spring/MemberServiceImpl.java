package study.design_pattern.behavior.strategy.useCase.Spring;

public class MemberServiceImpl implements MemberService {

    public void callBefore() {
        System.out.println("MemberServiceImpl called! ");
    }

    @Override
    public void join(Member member) {
        callBefore();
    }

    @Override
    public Member findMember(Long memberId) {
        callBefore();
        return null;
    }
}
