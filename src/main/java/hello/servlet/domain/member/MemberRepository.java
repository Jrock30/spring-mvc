package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    // static 으로 공유자원. , 싱글턴으로 구현을 해 놓았기 때문에 굳이 static으로 사용할 필요는 없다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글턴 생성
    private static final MemberRepository instance = new MemberRepository();

    // 이 메소드 에서만 생성 ( 싱글턴 )
    public static MemberRepository getInstance() {
        return instance;
    }

    // 생성자를 막는다. ( new 로 생성을 막는다 )
    private MemberRepository() {
    }

    // 저장
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findByid(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // 이렇게하면 store 를 보호하기 위해서
        return new ArrayList<>(store.values());
    }

    // 테스트 용도 ( reset )
    public void clearStore() {
        store.clear();
    }

}
