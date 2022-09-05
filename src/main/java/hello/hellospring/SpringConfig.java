package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//컴포넌트 스캔이 아닌 자바코드로 직접 등록하는 방법
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean //스프링 빈에 등록하라는 의미
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


//    @Bean
//    public MemberRepository memberRepository(){
//       // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//       //return new JdbcTemplateMemberRepository(dataSource);
//        // return new JpaMemberRepository(em);
//
//    }

}
