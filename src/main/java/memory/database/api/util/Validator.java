package memory.database.api.util;

import memory.database.api.model.Authenticator;
import memory.database.api.repository.IAuthRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Validator{

    private final IAuthRepository iAuthRepository;

    public Validator(IAuthRepository iAuthRepository) {
        this.iAuthRepository = iAuthRepository;
    }

    public boolean validate(String token){

        if(token == null){
            return false;
        }

        List<Authenticator> auth = iAuthRepository.findByToken(token);

        return !auth.isEmpty();

    }

}
