package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		return (Integer)ht.save(om);
	}
	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public void deleteOrderMethod(Integer id) {

		/* OrderMethod om=new OrderMethod();
		st.setOrderId(id);
		ht.delete(om);
		   (or)
		 */
		ht.delete(new OrderMethod(id));
	}

	@Override
	public OrderMethod getOneOrderMethodId(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);		
	}

	@Override
	public List<Object[]> getOrderTypeCount() {
		String hql="select ordType,count(ordType) from in.nit.model.OrderMethod group by ordType";

		return (List<Object[]>) ht.find(hql);
	}
}
