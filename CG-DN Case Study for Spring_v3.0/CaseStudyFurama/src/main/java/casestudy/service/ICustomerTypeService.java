package casestudy.service;

import casestudy.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerTypeService extends IGeneralService<CustomerType> {
    @Override
    List<CustomerType> findListAll();

    @Override
    List<CustomerType> findListById(Integer id);

    @Override
    void save(CustomerType customerType);

    @Override
    CustomerType findById(Integer id);

    @Override
    void update(CustomerType customerType);

    @Override
    void remove(Integer id);

    @Override
    Page<CustomerType> findPageNameAll(Pageable pageable, String name);
}
