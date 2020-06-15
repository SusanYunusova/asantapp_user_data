package az.unique.asantapp.user_data.api;

import az.unique.asantapp.user_data.internal.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/searchController")
public class Controller {
    private  final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/userData/{idUser}")
    public ResponseEntity<UserData> getUserData(@PathVariable("idUser") long idUser){
       log.info("trying to get UserData by id User{}",idUser);
        return service.getUserData(idUser);
    }

}
