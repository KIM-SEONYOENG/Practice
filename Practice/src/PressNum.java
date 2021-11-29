
public class PressNum {

	public static void main(String[] args) {
		int[] num = {1,3,4,5,8,2,1,4,5,9,5};
		System.out.println(solution(num, "right"));

	}
	public static String solution(int[] nums, String hand) {
		String answer = "";
		
		int left = -1;
		int right = -1;
		
		for(int i=0; i<nums.length; i++) {
			int k = nums[i];
			if(k%3 == 1) {
				left = k;
				answer += 'L';
			}else if(k%3==0) {
				right = k;
				answer += 'R';
			} else {
				int level = findLevel(k);
				int rd = Math.abs(level - findLevel(right)) + Math.abs((k%3) - (right%3));
				int ld = Math.abs(level-findLevel(left)) + Math.abs((k%3) - (left%3));
				
				if(rd < ld) {
					right = k;
					answer += 'R';
				} else if(ld < rd) {
					left = k;
					answer += 'L';
				} else if(ld==rd) {
					if(hand.equals("right")) {
						right = k;
						answer += 'R';
					} else {
						left = k;
						answer += 'L';
					}
				}
			}
		}
		
		return answer;
	}
	
	public static int findLevel(int k) {
		if(1<=k && k<=3)
			return 1;
		if(4<=k && k<=6)
			return 2;
		if(7<=k && k<=9)
			return 3;
		
		return 4;
	}

}
