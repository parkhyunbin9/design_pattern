package study.design_pattern.behavior.strategy.useCase.Spring;


public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
