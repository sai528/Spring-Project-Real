package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;

@Component
public class PurchaseOrderValidator implements Validator {
	@Autowired
	private IPurchaseOrderService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder purchase=(PurchaseOrder)target;
if(service.isPurchaseOrderCodeExist(purchase.getOrdCode())){
	errors.rejectValue("ordCode",null,"Purchase Code '"+purchase.getOrdCode()+"' is alresdy exist");
}
	}

}
