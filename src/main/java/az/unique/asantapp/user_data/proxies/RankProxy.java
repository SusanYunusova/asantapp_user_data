package az.unique.asantapp.user_data.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="asantapp-user-rank")
@RibbonClient(name ="asantapp-user-rank")
public interface RankProxy {
    @GetMapping("/searchController/getRankByIdUserTo/{idUserTo}")
    ResponseEntity<Float> getRankByIdUserTo(@PathVariable("idUserTo") long idUserTo);
}
