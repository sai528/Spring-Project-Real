package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 
import org.springframework.validation.Errors; 
import org.springframework.validation.Validator;

import in.nit.model.Part; 
import in.nit.service.IPartService;

@Component
public class PartValidator implements Validator 
{

	@Autowired 
	private IPartService service;

	@Override 
	public boolean supports(Class<?> clazz) { 
		return  Part.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { 
		Part part=(Part)target;
		if(service.isPartCodeExist(part.getPartCode())) {
			errors.rejectValue("partCode", null,"Part Code '"+part.getPartCode()+"' is already exist"); } }

}
