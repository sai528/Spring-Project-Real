package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@Component
public class ShipmentTypeValidator implements Validator {

	@Autowired
	IShipmentTypeService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShipmentType shiptype=(ShipmentType) target;
		if(service.isShipCodeExist(shiptype.getShipCode())) {
			errors.rejectValue("shipCode",null,"Ship Code'"+shiptype.getShipCode()+"' already exist");
		}
	}

}
