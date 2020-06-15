package az.unique.asantappuserbalance.db.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBalance {
    private long idUserBalance;
    private long idUser;
    private BigDecimal balance;


}
