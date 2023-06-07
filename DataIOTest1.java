import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest1 {

	public static void main(String[] args) {
		/*
		 * a.dat파일에 자료형별 쓰기
		 * 목적지 : a.dat파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : DataOutputStream
		 */

		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("..\\a.dat")); // new FileOutputStream("..\\a.dat") FileOutputStream 의 객체 생성해서 파일생성됨
			dos.writeBoolean(false); //1byte
			dos.writeInt(99); //4yte 
			dos.writeDouble(123.3); //8byte
			dos.writeUTF("가나"); //6+2byte
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if(dos != null)
				try {
					dos.close();
				} catch (IOException e) {

				}
		}
	}
}


