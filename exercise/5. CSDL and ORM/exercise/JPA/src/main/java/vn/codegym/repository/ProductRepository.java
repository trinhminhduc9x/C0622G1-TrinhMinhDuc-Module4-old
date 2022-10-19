package vn.codegym.repository;

import vn.codegym.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Transactional
@Repository
public class ProductRepository implements vn.codegym.repository.IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product); //thêm mới
    }

    @Override
    public Product findById(int id) {
      return  entityManager.find(Product.class, id); //tìm kiếm với id
    }

    @Override
    public void update( Product product) {
        entityManager.merge(product); //cập nhật

    }

    @Override
    public void remove(Product product) {
        entityManager.remove(product); //xóa
    }
}