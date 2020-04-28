package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPurchaseOrderDao;
import in.nit.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return (Integer) ht.save(po);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return ht.loadAll(PurchaseOrder.class) ;
	}

	@Override
	public void DeletePurchaseOrder(Integer id) {
		ht.delete(new PurchaseOrder(id));
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
		ht.update(po);
	}

	@Override
	public PurchaseOrder getOnePurchaseOrderId(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public List<Object[]> getpurseIdAndOrdCode() {
		String hql=" select purseId,ordCode from "+PurchaseOrder.class.getName();
		List<Object[]> list= (List<Object[]>) ht.find(hql);
		return list;
	}

	@SuppressWarnings({"deprecation","unchecked"})
	@Override
	public boolean isPurchaseOrderCodeExist(String ordCode) {
		boolean flag=false;
		String hql="select count(ordCode) from in.nit.model.PurchaseOrder where ordCode=?0";
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

