package az.unique.asantapp.user_data.internal;

import az.unique.asantappuserbalance.db.entities.UserBalance;
import az.unique.asantappuserrank.db.entities.UserRank;
import az.unique.asantappusers.db.entities.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {
    private  Users users;
    private UserBalance userBalance;
    private Float userRank;

}
