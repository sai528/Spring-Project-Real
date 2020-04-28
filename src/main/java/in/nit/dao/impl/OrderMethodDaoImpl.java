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

	@Override
	public List<Object[]> getOrdIdAndOrdCode(String ordMode) {
		String hql="select ordId,ordCode from in.nit.model.OrderMethod where ordMode=?0";

		List<Object[]> list=(List<Object[]>)ht.find(hql, ordMode);
		return list;
	}

	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public boolean isOrderCodeExist(String ordCode) {
		boolean flag=false;
		String hql="select count(ordCode) from in.nit.model.OrderMethod where ordCode=?0";
		List<Long> list=(List<Long>)ht.find(hql, ordCode);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) {
				flag=false;
			}else {
				flag=true;
			}
		}
		return flag;
	}
}
