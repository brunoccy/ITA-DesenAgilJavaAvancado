import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Authenticator.RequestorType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //Define so usar em metodo
public @interface IgnorarNaComparacao {

}
