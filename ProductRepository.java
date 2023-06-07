package com.my.product.dao;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.product.dto.Product;

public class ProductRepository{

	private String fileName;
	public ProductRepository() {
		fileName = "..\\products.dat";
	}

	/**
	 * 상품을 저장소에 추가한다
	 * @param p 저장할 상품
	 * @throws AddException 
	 *   상품번호가 존재할 경우 "이미존재하는 상품입니다"메시지를 갖는 예외가 발생한다  
	 */
	public void insert(Product p) throws AddException{
		/*
		 * 상품중복확인
		 * products.dat 파일을 자료형별로 읽기
		 * 자원 : products.dat 파일
		 * 노드스트림 : FileInputStream	
		 * 필터스트림 : DataInputStream
		 */
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			String prodNo = dis.readUTF();
			String prodName = dis.readUTF();
			int prodPrice = dis.readInt();
			if(prodNo.equals(p.getProdNo())) {
				throw new AddException("이미 존재하는 상품입니다");
			}
		} catch (FileNotFoundException e) {			
			//e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			if(dis != null)
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}


		/*
		 * products.dat파일에 상품정보(상품번호, 상품명, 가격)를 자료형별로 쓰기
		 * 목적지: proudcts.dat 파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : DataOutputStream
		 */
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(fileName,true));
			dos.writeUTF(p.getProdNo());
			dos.writeUTF(p.getProdName());
			dos.writeInt(p.getProdPrice());
		} catch (FileNotFoundException e) {  // 존재하지 않는 드라이브를 사용하는 경우 예외발생		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}

	}




	private List<Product> ArrayList(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 상품번호에 해당하는 상품을 저장소에서 찾아 반환한다
	 * @param no 상품번호
	 * @return 상품
	 * @throws com.my.exception.FindException 
	 * 번호에 해당상품이 없으면 "상품이 없습니다"메시지를 갖는 예외가 발생한다
	 */
	public Product selectByProdNo(String no) throws FindException{
		//상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다
		/*
		 * products.dat 파일을 자료형별로 읽기 = > 똑같은거 있으면 반환
		 * 자원 : products.dat 파일
		 * 노드스트림 : FileInputStream
		 * 필터스트림 : DataInputStream
		 */
		//		DataInputStream dis = null;
		//		dis = new DataInputStream(new FileInputStream(fileName));
		//
		//		while (dis.available()>0) {
		//			String prodNo = dis.readUTF();
		//			String prodName = dis.readUTF();
		//			int prodPrice = dis.readInt();
		//
		//			if(prodNo.equals(no)) {
		//				return new Product(prodNo, prodName, prodPrice);
		//
		//			}
		//		}
		//	}
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));

			while (dis.available() > 0) {
				String prodNo = dis.readUTF();
				String prodName = dis.readUTF();
				int prodPrice = dis.readInt();

				if (prodNo.equals(no)) {
					return new Product(prodNo, prodName, prodPrice);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		throw new FindException("상품을 찾을 수 없습니다.");
	}




	/**
	 * 모든상품을 검색하여 반환한다
	 * @return 
	 * @throws FindException
	 */
	public List<Product> selectAll() throws FindException{
		/*
		 * 상품전체반환
		 * products.dat 파일을 모두 읽기
		 * 자원 : products.dat 파일
		 * 노드스트림 : FileInputStream	
		 * 필터스트림 : DataInputStream
		 */
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			int readValue = -1;
			while((readValue = fr.read())!=-1) {
				System.out.println(readValue + ":" + (char)readValue);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	/**
	 * 단어를 포함한 이름을 갖는 상품들을 반환한다
	 * @param word 단어
	 * @return 
	 * @throws FindException
	 */
	/*
	 * 단어포함 상품반환 바이트단위로 해야될텐데
	 * products.dat 파일에서 다 읽고 부분검색
	 * 자원 : products.dat 파일
	 * 노드스트림 : FileInputStream	
	 * 필터스트림 : DataInputStream
	 */
	public Product selectByProdName(String word) throws FindException{

	}
	/**
	 * 상품번호에 해당 상품을 저장소에서 찾아 삭제한다
	 * @param prodNo 상품번호
	 * @throws com.my.exception.RemoveException 상품번호에 해당 상품이 없을 경우 예외가 발생한다
	 */
	//    public void delete(String prodNo) throws RemoveException{
	//    	try {
	//    		selectByProdNo(prodNo);
	//    	}catch(FindException e) {
	//   		throw new RemoveException(e.getMessage());
	//    	}
	//    	
	//    	int indexOfProdNo = 0; //  상품번호에 해당 상품의 위치
	//    	for(int i=0; i<pList.size(); i++) {
	//    		if(prodNo.equals(pList.get(i).getProdNo())){
	//    			indexOfProdNo = i;
	//    			break;
	//    		}
	//    	}
	//    	if(indexOfProdNo == 0) {
	//    		throw new RemoveException("상품이 없습니다");
	//    	}
	//    	//상품위치부터 다음상품을 앞으로 땡겨넣기
	//    	for(int i=indexOfProdNo; i<pList.size()-1; i++) {
	//    		pList(i) = pList(i+1);
	//    	}
	//    	//상품번호에 해당 상품이 있으면 
	//    	if(indexOfProdNo > 0) { 
	//    		pList.size()--;
	//    	}
	//    }    
} 