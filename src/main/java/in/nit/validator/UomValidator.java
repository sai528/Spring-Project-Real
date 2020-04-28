package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.Uom;
import in.nit.service.IUomService;

@Component
public class UomValidator implements Validator {

	@Autowired
	IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom uom=(Uom)target;
		if(service.isUomModelExist(uom.getUomModel())) {
			errors.rejectValue("uomModel",null,"Uom Model '"+uom.getUomModel()+"' already exist");
		}
	}

}
