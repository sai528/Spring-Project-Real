package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Component
public class OrderMethodValidator implements Validator {

	@Autowired
	IOrderMethodService service;
	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod order=(OrderMethod)target;
		if(service.isOrderCodeExist(order.getOrdCode())) {
			errors.rejectValue("ordCode",null,"ordCode '"+order.getOrdCode()+"' is already exist");
		}
	}

}
