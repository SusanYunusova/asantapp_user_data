package az.unique.asantapp.user_data.proxies;

import az.unique.asantappuserbalance.db.entities.UserBalance;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="asantapp-user-balance")
@RibbonClient(name ="asantapp-user-balance")
public interface BalanceProxy {

    @GetMapping("/searchServices/getUserBalanceByIdUserBalance/{idUser}")
    ResponseEntity<UserBalance> getUserByIdUser(@PathVariable("idUser") long idUser);
}
