import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//런타임 익셉션 아이오 익셉션 구분
public class FileIOTest {

	public static void main(String[] args) {
		/*
		 * a.txt파일을 바이트 단위로 읽기
		 * 자원 : a.txt파일
		 * 노드스트림 : File
		 *
		 */
		//		.FileInputStream fis;
		FileReader fr = null;//fr변수 선언만 되어있고 초기화가 되어있지않음 ->따라서 null값대입
		try {
			//fis = new FileInputStream("..\\aunicode.txt"); //".\\resource\\a.txt" //현재경로 기준으로 하위경로를 찾는다
			fr = new FileReader("..\\a.txt");   
			//상위경로 ..을 추가한다 // "..\\a.txt"
			// "..\\..\\a.txt 
			//절대경로 "D:\\263\\myJAVA\\a.txt


			//			int readValue = fis.read();	//끝을 만나면 -1 반환
			//			System.out.println(readValue);
			//			readValue = fis.read();
			//			System.out.println(readValue);



			//			while(true) {
			//				int readValue = fis.read();	//끝을 만나면 -1 반환
			//				if(readValue == -1) {
			//					break;
			//				}
			//			}

			int readValue = -1;
			//while((readValue = fis.read())!=-1){
			while((readValue = fr.read())!=-1){	
				System.out.println(readValue + ":" + (char)readValue);
			}
			//fr.close();			// 자원(외부 리스소)과의 연결을 끊는다, try구문 끝에 문구작성, 정상작동하다가 끊을때
			// 중간에 문제가 발생(예외가 발생해도) 1000번지 객체와의 연결정보를 없애야함
			// 끊어졌는데도 자동으로 메모리가 사라지지 않기때문에 메모리 누수를 막기 위해서 


		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			System.out.println("파일이 없습니다");
		} catch (IOException e) {
			//부모
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
					fr.close();   //자원과의 연결을 끊기할때 문제가 발생할 수 있으니 그에 대한 처리를 해라
					//왜 초기화가 안될수있지?a.txt파일이 업으면?
				} catch (IOException e) {				

				}
				
				
				
			}

		}

	}

}


// UTF-8 파일은 자바에서 잘읽을수 있음 - 같은 포맷이기때문에
// 문자조합이 맞지 않는 aunicode-파일은 문자 깨짐현상이 발생할 수 있다 - ANSI 인코딩