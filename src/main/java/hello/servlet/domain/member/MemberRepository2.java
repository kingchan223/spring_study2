package hello.servlet.domain.member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class MemberRepository2 {
    private  Map<Long, Member> store = new HashMap<>();
    private long sequence = 0L;

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());//store에 있는 모든 값들을 꺼내고 ArrayList에 담아서 반환한다.
    }

    public void clearStore(){
        store.clear();
    }
}
