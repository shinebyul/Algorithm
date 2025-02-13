import java.util.*;

class Solution {
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> money = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            share(seller[i], amount[i] * 100);
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = money.getOrDefault(enroll[i], 0);
        }

        return result;

    }
    
    void share(String seller, int sales) {
        int next = sales / 10;
        money.put(seller, money.getOrDefault(seller, 0) + sales - next);

        if (next > 0 && parent.containsKey(seller)) {
            share(parent.get(seller), next);
        }
    }
}
// enroll, referral을 순회하며 멤버와 추천인을 저장한다.
// seller, amount를 순회하며 판매자, 판매한 개수 * 100 로 share()을 호출한다.
// 이익의 90%를 자신이 가진다.
// 이익의 10%를 자신의 추천인에게 넘긴다. (단, 이익의 10%가 0원이 아닐 때)
// enroll을 순회하며 money에서 멤버를 검색하여 result에 넣는다.
// result를 반환한다.