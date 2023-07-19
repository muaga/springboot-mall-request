package shop.mtcoding.mallrequest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "product_tb")
// @Table : @Enity가 생성한 테이블에 관련된 설정
@Entity
// @Entity : DB 테이블 생성
public class Product {

    // @Id : PK
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) : AUTO_INCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;

}
