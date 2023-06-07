import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class DataIOTest {

	public static void writeTest() {
		/*
		 * a.dat파일에 자료형별 쓰기
		 * 목적지 : a.dat파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : DataOutputStream
		 */

		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("..\\a.dat", true)); // new FileOutputStream("..\\a.dat") FileOutputStream 의 객체 생성해서 파일생성됨
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
	public static void readTest() {
		/*
		 * a.dat파일을 자료형별로 읽기
		 * 자원.a.dat파일
		 * 노드스트림 : FileInputStream
		 * 필터스트림 : DataInputStream
		 */
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("..\\a.dat"));
			while(true) {//데이터 모두 읽기
				boolean flag = dis.readBoolean(); // EOF예외 발생하면 부모 예외 클래스인IO 예외에 !
				int i = dis.readInt(); //4yte 
				double d = dis.readDouble(); //8byte
				String utf = dis.readUTF(); //6+2byte
				System.out.println(flag + ":" + i + ":" + d + ":" + utf);
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch(EOFException e) {
			System.out.println("파일의 끝입니다");
		} catch (IOException e) {			
			e.printStackTrace();
		} finally{
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
			
	}		
	public static void main(String[] args) {
		 //writeTest();
		readTest();
		}
	
	
	
}


