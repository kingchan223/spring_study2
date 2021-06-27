package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 * //@RequestParam 사용
 * //@RequestMapping -> @GetMapping, @PostMapping*/
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository2 memberRepository2;

    public SpringMemberControllerV3(MemberRepository2 memberRepository2) {
        this.memberRepository2 = memberRepository2;
    }
    @GetMapping("/new-form")// = @RequestMapping(value="/new-form", method = RequestMethod.GET)
    public String newForm(){
        return "new-form";
    }
    @GetMapping// = @RequestMapping(method = RequestMethod.GET)
    public String members(Model model){
        List<Member> members = memberRepository2.findAll();
        model.addAttribute("members", members);
        return "members";
    }
    @PostMapping("/save")// = @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model){

        Member member = new Member(username, age);
        memberRepository2.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}
