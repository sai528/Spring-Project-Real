package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;

@Component
public class SaleOrderValidator implements Validator {
	
	@Autowired
	private ISaleOrderService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return SaleOrder.class.equals(clazz);
		}

	@Override
	public void validate(Object target, Errors errors) {
SaleOrder sale=(SaleOrder)target;
if(service.isSaleOrderCodeExist(sale.getOrdCode())) {
	errors.rejectValue("ordCode",null,"Sale Order '"+sale.getOrdCode()+"' is already exist");
}
	}

}
