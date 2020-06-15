package az.unique.asantappuserrank.db.entities;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserRank implements Serializable {

    private long idUserRank;
    private long idUserForm;
    private long idUserTo;
    private float rank;
    private long idUserServices;
}
