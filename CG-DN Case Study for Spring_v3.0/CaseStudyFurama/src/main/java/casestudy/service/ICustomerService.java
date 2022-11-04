package casestudy.service;

import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    @Override
    List<Customer> findListAll();

    @Override
    List<Customer> findListById(Integer id);

    @Override
    void save(Customer customer);

    @Override
    Customer findById(Integer id);

    @Override
    void update(Customer customer);

    @Override
    void remove(Integer id);
    void removeNew(Integer id);

    @Override
    Page<Customer> findPageNameAll(Pageable pageable, String name);
}
