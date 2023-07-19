package shop.mtcoding.mallrequest.controller;

// 브라우저에
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.mallrequest.model.Product;
import shop.mtcoding.mallrequest.model.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
// @Controller : 리턴되는 파일명과 일치한 파일명을 찾는다. = 즉, 같은 엔드포인트를 찾는다.
// 클라이언트와 상호작용을 하는 곳이며, Repository 속 메소드, jsp파일을 연결해서 반응을 한다.
public class ProductController {

    @Autowired
    // ProductRepository 클래스를 의존성 주입을 시킨다.
    private ProductRepository productRepository;

    // # GET 요청에 대한 응답으로 view하기

    // view, 브라우저에 보이게 하는 방법은 home.jsp파일을 모두 읽어서 데이터를 return하는 것이다.
    // 메소드 호출은 아니다. 이때 템플릿엔진을 사용해야 한다.
    // 1. 매개변수 request에 데이터를 담는다.
    // 2. home.jsp 파일에 가서 request 데이터를 for-each를 돌린다.
    @GetMapping("/")
    // @GetMapping : GET(요청)기능을 가지며, 엔트포인트가 /일 경우, 아래의 메소드가 실행된다.
    public String home(HttpServletRequest request)throws Exception{
        List<Product> productList = productRepository.findAll();
        // ProductRepository의 findAll메소드를 이용해, 데이터를 productList에 담는다.
        request.setAttribute("productList", productList);
        // setAtrribute : HttpServletRequest 객체에 데이터를 저장한다.
        return "home";
        // "home"과 파일명이 일치한 파일을 찾는다.
        // "home"파일의 확장자는, application.yml에서
        // viewResolver에서 jsp가 붙는 파일을 찾는다고 설정해놨다.
    }

    // # '상품등록'을 클릭하면 해당 창이 나오게 하는 응답(하이퍼링크 클릭)
    @GetMapping("/write")
    public String writePage(){
        return "write";
        // return "write"는 @Controller로 리턴되는 파일인 write.jsp를 찾아낸다.
    }

    // # 웹서버에 등록하기

    @PostMapping("/product")
    // @PostMapping : Post(등록)기능을 가지며, 엔드포인트가 /일 경우, 아래의 메소드가 실행된다.
    public void write(String name, int price, int qty, HttpServletResponse response) throws Exception{
        // value는 매개변수와 같은 타입 값을 넣어줘야 한다.
        // # 콘솔에서도 확인하기
        System.out.println("name" + name);
        System.out.println("price" + price);
        System.out.println("qty" + qty);

        productRepository.save(name, price, qty);
        // productRepository의 save 메소드 사용하기
        response.sendRedirect("/");
        // 사용자의 요청이 처리된 후, 클라이언트에게 지정된 URL로 리다이렉트(다시 보내기)를 요청하는 역할한다.
        // ()속은 원하는 URL 엔드포인트를 넣으면 된다.
    }
}
