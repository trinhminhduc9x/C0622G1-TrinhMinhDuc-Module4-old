package casestudy.repository;

import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = " select * from customer where name like :name and phone_number like :phone_number ", nativeQuery = true)
    Page<Customer> findAllByNameAndPhone(Pageable pageable, @Param("name") String name, @Param("phone") String phone);


    @Query(value = " select * from customer where name like :name", nativeQuery = true)
    Page<Customer> findAllByName(Pageable pageable, @Param("name") String name);



    @Query(value = " select * from customer where category_id = :id ", nativeQuery = true)
    List<Customer> findListById(@Param("id") Integer id);

    @Query(value = " UPDATE customer SET id_delete = '1' where id = :id ", nativeQuery = true)
    List<Customer> deleteById_delete(@Param("id") Integer id);
}
