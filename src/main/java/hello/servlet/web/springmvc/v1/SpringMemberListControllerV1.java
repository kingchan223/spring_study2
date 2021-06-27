package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SpringMemberListControllerV1 {
    private final MemberRepository2 memberRepository2;

    @Autowired
    public SpringMemberListControllerV1(MemberRepository2 memberRepository2) {
        this.memberRepository2 = memberRepository2;
    }

    @RequestMapping("springmvc/v1/members")
    public ModelAndView process(){
        List<Member> members = memberRepository2.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}
