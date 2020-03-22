package validador;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("vcelular")
public class validaCelular implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        
        String ncelular = o.toString().trim();
        
        if(ncelular.length() == 0){
            throw new ValidatorException(new FacesMessage("Ingrese Celular"));
        }else{
            String erTexto="^9\\d\\d-\\d\\d\\d-\\d\\d\\d$";
            boolean ok=Pattern.matches(erTexto, ncelular);
            
            if(!ok){
                throw new ValidatorException(new FacesMessage("Formato debe ser 9##-###-###"));
            }
        }
        
    }
    
    
}
