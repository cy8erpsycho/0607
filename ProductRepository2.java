package com.my.product.dao; // data access object
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.product.dto.Product;
	

public class ProductRepository2{
	public Product[] pArr = new Product[5];
	
	/**
	 * 저장소를 만든다
	 * 최대 
	 */
	public ProductRepository2() {
		pArr = new Product[5];
	}
	public ProductRepository2(int maxSize){
		if(maxSize <= 0) {
			maxSize = 5;
		}
		
		this.pArr = new Product[maxSize];
	}
	 
	//Product[] pArr;
	private int totalCnt = 0; //저장소에 저장된 상품수
	
	/**
	 * 상품을 저장소에 추가한다
	 * 
	 * @param p 저장할 상품
	 * @throws AddException 
	 * 	상품번호가 존재할 경우 "이미 존재하는 상품입니다"메세지를 갖는 예외가 발생한다
	 *  저장소가 꽉 찼을 경우 "저장소가 꽉 찼습니다. 현재 상품수는"
	 */
	public void insert(Product p) throws AddException{ 
		// 왜 insert 메소드의 매개변수가 Product로 만들어야 하는가?
		// 상품정보 상품명 가격이 인자로 전달됨
		// 왜 Product p ? 많은 정보가 전달되게 위해서는 매개변수가 많아야함
		// 매개변수를 나열하지 않고 product라는 class를 만들어서 한번에 옮기는 역할을 한다
	   
//		pArr[totalCnt++] = p;  //bad
		//   [10]번 인덱스를 사용하기때문에 프로그램이 죽는다?
		//   오류발생- ++연산을 하고 죽음 즉 totalCnt = 11이된다
		//   어떻게 하지?
		
//		for (int i=0; i<pArr.length; i++) {
//			for(int j=0; j<i; j++) {
//				if(pArr[i].equals(pArr[j])) {		
//				System.out.println("다시입력");
//				j--;
//				break;			
//				}
//			}  
//		}
		
		/* TODO
		 * 
		 */
//		for(int i=0;i<totalCnt;i++) {			//저장된 물품이기ㅣ 떄문에 totalCnt
//			if((pArr[i].getProdNo().equals(p.getProdNo())))  {
//				System.out.println("이미 존재하는 상품입니다.");
//				return ;}
//		}
		
		
		for(int i=0; i<totalCnt; i++) {
			Product p1 = pArr[i];// 저장소의 상품
			String p1ProdNo = p1.getProdNo(); // 저장소의 삼품의 상품번호
			String pProdNo = p.getProdNo(); // 저장하려는 상품의 상품번호		
			if(p.getProdNo().equals(p1ProdNo)) {
			//if(p.getProdNo().equals(pArr[i].getProdNo()
//				System.out.println("이미 존재하는 상품입니다");
//				return;
				throw new AddException("이미 존재하는 상품입니다");
			}
			
			
			// if(p.getProdNo()
		}

		
//		if(totalCnt >= pArr.length) {
//			System.out.println("저장소가 꽉 찼습니다. 현재 상품수는" + totalCnt);
//			return; // insert 메서드가 끝나면 다시 반복한다
//		}
		// 예외처리를 하지않고 미리 막을수있으면 좋음
		
		try {
		pArr[totalCnt] = p;    //good - totalCnt 값이 10으로 유지되어 죽는다
		totalCnt++; 
		}catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("저장소가 꽉 찼습니다. 현재 상품수는" + totalCnt);
			throw new AddException("저장소가 꽉 찼습니다. 현재 상품수는" + totalCnt);
		}
		//pArr[totalCnt]에서 예외 발생하면 바로 catch구문으로 이동
		//totalCnt ++ 의 ++ 연산자가 적용되지 않아 현재상품수가 그ㅐ대로 유지된다
		
//		try {
//		pArr[totalCnt++] = p;  //bad
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("저장소가 꽉 찼습니다. 현재 상품수는" + totalCnt);
//			//totalCnt++ 3에서 ++를 하고 와서 totalCnt가 4가출력됨
//		}
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
		for(int i=0; i<totalCnt; i++){
			Product p = pArr[i];
			if(p.getProdNo().equals(no)){ //==는 기본자료형(숫자,문자,논리)값 비교시 사용한다
				//equals()는 문자열(String)값 비교시 사용한다
				return p;
			}
		}
//		return null; //상품이 없는 경우 null을 반환한다
		throw new FindException("상품이 없습니다");
	}
	
	/**
	 * 상품전체를 검색한다
	 * @return 상품들
	 * @throws FindException
	 */
	public Product[] selectAll() throws FindException{
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		return all;
	}

	// p = 반환받을 값으로 쓰이거나 매개변수 인자로 쓰인다 data transfer object : dto, 자료를 전달할 객체

	/**
	 * 단어를 포함한 이름을 갖는 상품들을 반환한다
	 * @param word
	 * @return 상품들
	 * @throws FindException
	 */
	public Product[] selectByProdName(String word) throws FindException{
		Product[]all;
		int cnt=0; // 단어를 포함한 상품수
		for(int i=0; i<totalCnt; i++) {
			if(pArr[i].getProdName().contains(word)) {
				cnt++;
			}
		}
		all = new Product[cnt];
    	int index = 0;
    	for(int i=0; i<totalCnt; i++) {
    		Product p = pArr[i];    	
    		if(p.getProdName().contains(word)) {
    			all[index] = p;
    			index++;
    		}
    	}
    	return all;	
	}
	/**
	 * 상품번호에 해당 상품을 저장소에서 찾아 삭제한다
	 * @param prodNo 상품번호
	 * @throws com.my.exception.RemoveException 상품번호에 해당 상품이 없을 경우 예외가 발생한다
	 */
	
	
	/*
    public static void main(String[]args){
        //pArr =  new Product[5];

        //pArr[0] = new Product();
        //pArr[0].prodNo = "G0001";

        for(int i=0; i<5; i++){
            pArr[i] = new Product();
            pArr[i].prodNo = "G000" + (i+1);
        }

        for(int i=0; i<5; i++){
            System.out.println(pArr[i].prodNo);
        }
    }
	 */
} 