package az.unique.asantapp.user_data.api;

import az.unique.asantapp.user_data.internal.UserData;
import az.unique.asantapp.user_data.proxies.BalanceProxy;
import az.unique.asantapp.user_data.proxies.RankProxy;
import az.unique.asantapp.user_data.proxies.UserProxy;
import az.unique.asantappuserbalance.db.entities.UserBalance;
import az.unique.asantappusers.db.entities.Users;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static sun.jvm.hotspot.debugger.win32.coff.DebugVC50X86RegisterEnums.TAG;

@Component
@Slf4j
public class Service {
    private  final BalanceProxy balanceProxy;
    private  final RankProxy rankProxy;
    private  final UserProxy userProxy;

    public Service(BalanceProxy balanceProxy, RankProxy rankProxy, UserProxy userProxy) {
        this.balanceProxy = balanceProxy;
        this.rankProxy = rankProxy;
        this.userProxy = userProxy;
    }

    public ResponseEntity<UserData> getUserData(long idUser){
        try {
            log.info("trying to get users by id user{}",idUser);
            ResponseEntity<Users> user = userProxy.findByIdUsers(idUser);
            log.info("trying to get userBalance by idUser{}",idUser);
            ResponseEntity<UserBalance> balance = balanceProxy.getUserByIdUser(idUser);
            log.info("trying to get usrRank by id USer{}",idUser);
            ResponseEntity<Float> rank = rankProxy.getRankByIdUserTo(idUser);
            UserData userData = UserData.builder()
                .userBalance(balance.getBody())
                .userRank(rank.getBody())
                .users(user.getBody())
                .build();
            if (userData!=null){
                log.info("userData is not empty.userData{}",userData.toString());
                return  new ResponseEntity<>(userData, HttpStatus.OK);
            }else {
                log.info("usrData by id USer is empty ..idUser{}",idUser);
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }

        }catch (Exception e){
            log.error("error getting userData:{}{}",e,e);
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
