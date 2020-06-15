package az.unique.asantapp.user_data.proxies;

import az.unique.asantappusers.db.entities.Users;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asantapp-users")
@RibbonClient(name = "asantapp-users")
public interface UserProxy {
    @GetMapping("/searchController/findUsersByIdUsers/{idUsers}")
    ResponseEntity<Users> findByIdUsers(@PathVariable("idUsers") long idUsers);


}
