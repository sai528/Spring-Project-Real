package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.ISaleOrderDao;
import in.nit.model.SaleOrder;

@Repository
public class SaleOrderDaoImpl implements ISaleOrderDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveSaleOrder(SaleOrder so) {
		return (Integer)ht.save(so);
	}

	@Override
	public List<SaleOrder> getAllSaleOrders() {
		return ht.loadAll(SaleOrder.class);

	}

	@Override
	public void DeleteSaleOrder(Integer id) {
		ht.delete(new SaleOrder(id));
	}

	@Override
	public void updateSaleOrder(SaleOrder so) {
		ht.update(so);
	}

	@Override
	public SaleOrder getOneSaleOrderId(Integer id) {

		return ht.get(SaleOrder.class, id);
	}

	@Override
	public List<Object[]> getSaleIdAndSaleOrdCode() {
		String hql=" select saleId,ordCode from "+SaleOrder.class.getName();
		return (List<Object[]>) ht.find(hql);
	}

	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public boolean isSaleOrderCodeExist(String ordCode) {
		boolean flag=false;
		String hql="select count(ordCode) from in.nit.model.SaleOrder where ordCode=?0";
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
