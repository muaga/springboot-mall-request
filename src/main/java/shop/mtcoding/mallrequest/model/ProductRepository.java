package shop.mtcoding.mallrequest.model;

// DAO 역할
// ? Repository인 이유 : DAO는 DB만 접근이 가능한 개념으로,
// Repository가 조금 더 넓은 의미로 사용되기 때문이다.


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.awt.desktop.QuitResponse;
import java.util.List;

@Repository
// @Repository : 해당 어노테이션이 붙은 클래스는 DB에 접근해 Data Access, CRUD역할을 한다.
// 해당 클래스를 IoC컨테이너에 넣어서
// 클래스 내의 메소드를 싱글톤으로 사용할 수 있도록 해준다.
// (new를 해서 매번 새롭게 객체를 생성할 필요가 없다.)
public class ProductRepository {

    @Autowired
    // 의존성 주입
    // @Autowired : EntityManager를 멤버변수로 한다.
    // 이렇게 주입된 멤버 변수는 클래스 내의 모든 메소드에서 사용 가능하다.
    // EntityManager가 이미 스프링 컨테이너에서 관리되는 빈으로 등록되어 있기
    // 때문에, 클래스 내부의 모든 메소드에서 EntityManager를 사용할 수 있다.
    private EntityManager em;
    // EntityManager : JPA를 사용하여 DB와 상호작용하는 데 사용되는 객체이다.
    // DBConnection역할을 하며, 이러한 매핑관리와 실제로 DB와의 CRUD작업을 수행한다.
    // 객체의 영속성 관리와 DB 트랜잭션 관리도 한다.

    @Transactional
    // @Transactional : 트랜잭션, INSERT, DELETE, UPDATE시 무조건 해야한다.
    public void save(String name, int price, int qty){
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty) values(:name, :price, :qty)");
        // JPA를 통해 네이티브SQL쿼리를 사용하는 것
        // Query : Query 인터페이스는 JPA에서 정의된 쿼리를 나타내는 인터페이스로서,
        // 데이터베이스와 상호작용하는 쿼리를 실행하고 결과를 반환하는데 사용
        // createNativeQuery : 네이티브SQL쿼리를 실행하도록 하는 메소드
        // 네이티브SQL쿼리 : 특정SQL문법을 사용하여, 직접 실행하게 하는 쿼리
        query.setParameter("name", name);
        // "name" column의 name(data)
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.executeUpdate();
    }

    public List<Product> findAll(){
        Query query = em.createNativeQuery("select * from product_tb", Product.class);
        // Product.class : 쿼리 결과를 Product class의 각 모델에 담는다.
        // 위의 코드로 while을 돌면서, Product class의 각 모델에 담을 필요가 없다.
        List<Product> productList = query.getResultList();
        // = executequery();
        return productList;
    }

}
