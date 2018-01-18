package pro05;

import java.util.List;
import java.util.Scanner;

public class BookShopApp {

	public static void main(String[] args) {
		
		BookShopDao dao = new BookShopDao();
		BookVo vo = new BookVo();
		
		vo.setTitle( "트와일라잇" );
		vo.setAuthorName( "스테파니메이어" );
		dao.insert( vo );

		vo.setTitle( "뉴문" );
		vo.setAuthorName( "스테파니메이어" );
		dao.insert( vo );

		vo.setTitle( "이클립스" );
		vo.setAuthorName( "스테파니메이어" );
		dao.insert( vo );
		
		vo.setTitle( "브레이킹던" );
		vo.setAuthorName( "스테파니메이어" );
		dao.insert( vo );

		vo.setTitle( "아리랑" );
		vo.setAuthorName( "조정래" );
		dao.insert( vo );

		vo.setTitle( "젊은그들" );
		vo.setAuthorName( "김동인" );
		dao.insert( vo );

		vo.setTitle( "아프니까 청춘이다" );
		vo.setAuthorName( "김난도" );
		dao.insert( vo );

		vo.setTitle( "귀천" );
		vo.setAuthorName( "천상병" );
		dao.insert( vo );

		vo.setTitle( "태백산맥" );
		vo.setAuthorName( "조정래" );
		dao.insert( vo );

		vo.setTitle( "풀하우스" );
		vo.setAuthorName( "원수연" );
		dao.insert( vo );
		
		Scanner key = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요.:");
		int num = key.nextInt();
		
		dao.rent(num);
		
		displayBookInfo();
	}
	
	public static void displayBookInfo() {
		System.out.println("*****도서 정보 출력하기******");
		
		List<BookVo> bList = new BookShopDao().getBookInfo();
		BookVo vo;
		
		for(int i = 0; i < bList.size(); i++) {
			vo = bList.get(i);
			System.out.print("책 제목:" + vo.getTitle());
			
			if(vo.getPubs() != null)
				System.out.print(", 출판사:" + vo.getPubs());
			if(vo.getPubDate() != null)
				System.out.print(", 출판일:" + vo.getPubDate());
			System.out.print(", 작가:" + vo.getAuthorName());
			System.out.print(", 대여 유무:");
			
			if(vo.getStateCode().equals("0"))
				System.out.println("대여중");
			else
				System.out.println("재고있음");
		}
	}	

}