
public class SuggestId {

	public static void main(String[] args) {
		System.out.println(solution("Hello World!_H..."));
		System.out.println(solution(""));
		System.out.println(solution("z-+.^."));

	}
	
	public static String solution(String new_id) {
		String answer = "";
		char[] id = new_id.toCharArray();
		int len = id.length;
		
		for(int i=0; i<len; i++) {
			char c = id[i];
			if(('a'<=c && c<='z') || c=='-' || c=='_' || c=='.' || ('0'<=c && c<='9')) 
				continue;
			
			if('A'<=c && c<='Z') {
				id[i] = (char)(c+32);
			}else {
				remove(id, i, len);
				len--;
				i--;
			}
		}
		
		for(int i=0; i<len; i++) {
			if(i==0 || i==(len-1)) {
				if(id[i] == '.') {
					remove(id, i, len);
					i--;
					len--;
				}
				continue;
			}
			if(id[i-1]=='.' && id[i]=='.') {
				remove(id, i, len);
				i--;
				len--;
			}
		}
		
		if(len>15) {
			for(int i=15; i<len; i++) {
				remove(id, i, len);
				i--;
				len--;
			}
		}
		for(int i=(len-1); i>=0; i--) {
			if(id[i]!='.')
				break;
			len--;
		}
		
		for(int i=0; i<len; i++)
			answer += id[i];
		
		if(answer.length()==0)
			answer += 'a';
		if(answer.length()<3) {
			int l = answer.length();
			for(int i=l; i<3; i++) {
				answer += answer.charAt(l-1);
			}
		}
		
		return answer;
	}
	
	public static void remove(char[] id, int index, int len) {
		char c;
		for(int i=index; i<(id.length-1); i++) {
			c = id[i+1];
			id[i] = c;
		}
	}

}
