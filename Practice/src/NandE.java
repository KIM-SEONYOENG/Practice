
public class NandE {

	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}
	
	public static int solution(String s) {
		int answer = 0;
		
		String a = "";
		
		char[] c = s.toCharArray();
		int len = c.length;
		String tmp = "";
		for(int i=0; i<len; i++) {
			if('0'<=c[i] && c[i]<='9') {
				a += c[i];
				continue;
			}
			tmp += c[i];
			int k = check(tmp);
			if(k!=-1) {
				a += String.valueOf(k);
				tmp = "";
			}
		}
		
		answer = Integer.valueOf(a);
		return answer;
	}
	
	public static int check(String s) {
		if(s.equals("zero"))
			return 0;
		if(s.equals("one"))
			return 1;
		if(s.equals("two"))
			return 2;
		if(s.equals("three"))
			return 3;
		if(s.equals("four"))
			return 4;
		if(s.equals("five"))
			return 5;
		if(s.equals("six"))
			return 6;
		if(s.equals("seven"))
			return 7;
		if(s.equals("eight"))
			return 8;
		if(s.equals("nine"))
			return 9;
		
		
		return -1;
	}
}
