import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//런타임 익셉션 아이오 익셉션 구분
public class FileIOTest2 {

	public static void main(String[] args) {
		/*
		 * a.txt파일을 바이트 단위로 읽기
		 * 자원 : a.txt파일
		 * 노드스트림 : FileInputStream
		 *
		 */
		FileInputStream fis;
		try {
			fis = new FileInputStream("..\\aunicode.txt"); //".\\resource\\a.txt" //현재경로 기준으로 하위경로를 찾는다
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
			while((readValue = fis.read())!=-1){
				System.out.println(readValue + ":" + (char)readValue);
			}




		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			System.out.println("파일이 없습니다");
		} catch (IOException e) {
			//부모
			e.printStackTrace();
		}



	}

}
