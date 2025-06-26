import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박병호_1639 {  //메모리 14188  시간 108ms
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String S=br.readLine();

        int numLength;
        if(S.length()%2==0){  //행운 번호는 무조건 2N 이니까 홀수면 -1 합니다
            numLength=S.length();
        }else{
            numLength=S.length()-1;
        }
        boolean check=false;
        int answer=0;
        while (numLength>0) {   //가장 긴 번호를 출력 해야 하기 때문에 긴 경우 부터 검사 하고 점점 짧게
            for (int i = 0; i <= S.length() - numLength; i++) {
                String checkNumber = S.substring(i, i + numLength);
                check = luckyGotcha(checkNumber); //검사 할 패턴을 찾아서  합이 같은지 체크
                if (check) {  //참이면 for 문 탈출
                    break;
                }
            }
            if (check) {
                answer=numLength; //가장 긴 답을 발견 하면 정답 저장 후 탈출
                break;
            } else {   //아니면 그 다음으로 긴 문자 길이를 설정하고 처음으로 가서 가시 패턴 발견 후 검사 반복
                numLength -=2;
            }
        }
        System.out.println(numLength);
    }

    static boolean luckyGotcha (String checkNumber){

        int length=checkNumber.length()/2;  //패턴을 토막 냄
        String num1=checkNumber.substring(0,length); //처음 부터 반  반에서 끝까지
        String num2=checkNumber.substring(length);

        int num11=0;    //변수 이름은 대충 지었..
        int num22=0;
        for (int i = 0; i <num1.length() ; i++) {
            num11 +=num1.charAt(i)-'0';
            num22 +=num2.charAt(i)-'0';
        }
        if(num11==num22){  //두 정수의 합이 같다면 참 아니면 거짓 반환
            return true;
        }else{
            return  false;
        }
    }
}
