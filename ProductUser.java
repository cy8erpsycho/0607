import java.util.List;
import java.util.Scanner;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.product.dao.ProductRepository;
import com.my.product.dto.Product;

public class ProductUser{
	static Scanner sc = new Scanner(System.in);
	private ProductRepository repository = 	
			new ProductRepository();								
	
	public void findAll(){
		System.out.println(">>전체상품검색<<");
		List<Product> result;
		try {
			result = repository.selectAll();
			for(int i=0; i<result.size(); i++){
				result.get(i).print();
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	public void findByProdNo() {
		System.out.println(">>상품검색<<");
		System.out.print("상품번호를 입력하세요:");
		String noArg1 = sc.nextLine();//키보드로 입력받기
		System.out.print(noArg1);
		Product p;
		try {
			p = repository.selectByProdNo(noArg1);
			if(p != null) {
				p.print();
			}
		} catch (FindException e) {
			System.out.println(e.getMessage());
		}
	}
	public void add() {              
		System.out.println(">>상품추가<<");
		System.out.print("상품번호를 입력하세요:");
		String prodNo = sc.nextLine();
		System.out.print("상품명을 입력하세요:");
		String prodName = sc.nextLine();
		System.out.print("상품가격을 입력하세요:");
		int prodPrice = Integer.parseInt(sc.nextLine());		
		Product pArg = new Product(prodNo, prodName, prodPrice);
		
		try {
			repository.insert(pArg);
		} catch (AddException e) {
			e.printStackTrace();
		}
		
	}
	public void findByProdName() {
		System.out.println(">>상품이름으로 검색<<");
		System.out.print("단어를 입력하세요. 단어를 포함한 상품명으로 검색합니다:");
		String word = sc.nextLine();
		List<Product> result;
		try {
			result = repository.selectByProdName(word);
			for(Product p: result) {
				p.print();
			}	
		} catch (FindException e) {
			e.printStackTrace();
		}
			
	}
	public static void main(String[] args){
		ProductUser user = new ProductUser();
		String opt;
		do{
			System.out.println("작업을 선택하세요");
			System.out.print("1:상품전체검색,  2:상품번호로검색, 3: 상품추가, 4: 상품이름으로 검색,9: 종료");
			opt = sc.nextLine();//키보드로 입력받기
			if(opt.equals("1")){ // ==비교연산자사용안함
				user.findAll();
			}else if(opt.equals("2")){
				user.findByProdNo();
				
			}else if(opt.equals("3")){
				user.add();
			}else if(opt.equals("4")) {
				user.findByProdName();
			}else if(opt.equals("9")){
			}else{
				System.out.println("잘못입력하셨습니다");
			}
		}while(!opt.equals("9"));

	}
}