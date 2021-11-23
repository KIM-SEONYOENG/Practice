
public class SuggestId {

	public static void main(String[] args) {
		System.out.println(solution("Hello World!_HA."));

	}
	
	public static String solution(String new_id) {
		char[] id = new_id.toCharArray();
		int len = id.length;
		for(int i=0; i<len; i++) {
			char c = id[i];
			if('a'<=c && c<='z' && c=='-' && c=='_' && c=='.') 
				continue;
			
			if('A'<=c && c<='Z') {
				id[i] = (char)(c+32);
				System.out.println("YES! " + c);
			}else {
				remove(id, i, len);
				len--;
			}
		}
		
		String answer = String.valueOf(id);
		return answer;
	}
	
	public static void remove(char[] id, int index, int len) {
		char c;
		for(int i=index; i<(id.length-1); i++) {
			c = id[index+1];
			id[index] = c;
		}
	}

}
