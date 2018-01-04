package com.peanut.p2p.products.dao;

import com.peanut.data.orm.dao.IBaseDao;
import com.peanut.data.orm.dao.builder.annotation.RepositoryProxy;
import com.peanut.data.query.anotation.*;
import com.peanut.p2p.products.model.entity.Product;

import java.util.List;

/**
 * Created by lenovo on 2014/12/12.
 */
@RepositoryProxy("productDao")
public interface ProductDao extends IBaseDao {
    @NativeQuery("SELECT * FROM product p, real_stock r WHERE p.product_id = r.product_id")
    @ReturnType(Product.class)
    List<Product> getLeftAmount();

    @Update("update Product set act_status='0' where id= :id")
    public int update(@Param("id") Long id);

    @Update("update Product set enterStatus=:enterStatus where id= :id")
    public int updateEnterS(@Param("enterStatus") String enterStatus,@Param("id") Long id);
//     @Query("from Product p, Transfer t where p.product_id = t.product_id " +
//             "order by t.pre_time = :preTime")
//     Page<Product> getProductPageById(@Param("preTime")Timestamp preTime ,@PageSize int pageSize, @PageNum int pageNum);

    @Update("update Product set statusCode=:statusCode where id= :id")
    public int updateStatus(@Param("statusCode") String statusCode,@Param("id") Long id);

    @Query("from Product p where p.status_code =:statusCode")
    List<Product> findProductByStatus(@Param("statusCode") String statusCode);

    @NativeQuery("SELECT p.* FROM product p,transfer t WHERE p.product_id = t.product_id AND p.act_status = 1 AND TIMESTAMPDIFF(SECOND,SYSDATE(), t.end_time)> 0 AND TIMESTAMPDIFF(SECOND,SYSDATE(), t.end_time)< 600 AND p.status_code = '1'")
    @ReturnType(Product.class)
    List<Product> getList();

    @NativeQuery("SELECT p.* FROM product p,transfer t WHERE p.act_status = 1 AND p.status_code = 0 AND p.product_id = t.product_id AND SYSDATE() > t.start_time AND SYSDATE() < t.end_time")
    @ReturnType(Product.class)
    List<Product> getTBZ();

    @NativeQuery("SELECT p.* FROM product p,transfer t WHERE p.act_status = 1 AND p.status_code IN(1,0) AND p.product_id = t.product_id  AND SYSDATE() > t.end_time AND t.finish_time IS NULL")
    @ReturnType(Product.class)
    List<Product> getSAE();

    @NativeQuery("SELECT p.* FROM product p,transfer t WHERE p.act_status = 1 AND p.status_code IN(1,7) AND p.product_id = t.product_id  AND t.finish_time IS NULL ORDER BY product_id DESC")
    @ReturnType(Product.class)
    List<Product> getSList();
    @NativeQuery("SELECT p.* FROM product p,transfer t WHERE p.act_status = 1 AND p.status_code=2 AND p.product_id = t.product_id  AND SYSDATE()>t.end_time ORDER BY product_id DESC")
    @ReturnType(Product.class)
    List<Product> getMBList();
  /*  @NativeQuery("SELECT product_id id,\n" +
            "product_code productCode,\n" +
            "product_name productName,\n" +
            "product_desc productDesc,\n" +
            "product_type_code productTypeCod,\n" +
            "investment_start_date investmentStartDate,\n" +
            "investment_end_date investmentEndDate,\n" +
            "used used,\n" +
            "repayment_date repaymentDate,\n" +
            "year_rate yearRate,\n" +
            "status_code statusCode,\n" +
            "minimum_investment minimumInvestment,\n" +
            "ascendcompanyidea ascendcompanyidea,\n" +
            "enter_status enterStatus,\n" +
            "approval_status approvalStatus,\n" +
            "total_money totalMoney,\n" +
            "release_status releaseStatus,\n" +
            "buy_type buyType,\n" +
            "borrower_rep_time,\n" +
            "borrower_bor_time,\n" +
            "approval_opinion,\n" +
            "act_status act_status,\n" +
            "verify_user,\n" +
            "verify_time\n" +
            "FROM product p\n" +
            " WHERE p.product_id =:id")
    @ReturnType(Product.class)
    Product findById(@Param("id") Long id);*/
}
