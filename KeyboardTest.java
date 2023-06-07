import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class KeyboardTest {

	public static void main(String[] args) {
		/*
		 * 키보드 자원으로부터 한 문자씩 입력받기
		 * 자원: 키보드 
		 * 노드스트림:System.in
		 * 필터스트림 : InputStreamReader	
		 */
		InputStream is = System.in;
//		InputStreamReader ir = null;
		Scanner sc = null;
//		try {
//			int readValue = is.read();
//			ir = new InputStreamReader(is);
//			int readValue = ir.read();
//			System.out.println("입력된 값:" + readValue +",문자값:"+ (char)readValue ); // '가'입력시 온전치 않은 1바이트 값만 반환
//		} catch (IOException e) { //키보드와의 하드웨어적 연결이 끊겼을때?			
//			e.printStackTrace();
//		}
			
			sc = new Scanner(is);
			String readLine = sc.nextLine(); // 인트타입으로 읽음
			System.out.println("입력된 값:" + readLine);
//			String readLine = sc.next();
//			String read = sc.nextLine();
			
//			int i = sc.nextInt();
//			System.out.println(i);
//			int j = sc.nextInt();
//			System.out.println(j);
//			System.out.println(sc.nextLine());
			
			
			
		//스캐너 쓸떄는 IO 익셉션 x
					
	}


}
