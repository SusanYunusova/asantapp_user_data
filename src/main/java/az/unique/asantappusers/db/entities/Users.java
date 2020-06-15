package az.unique.asantappusers.db.entities;

import lombok.Data;

@Data
public class Users {
    private long idUsers;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private int isConfirmed;
    private int isActive;
    private String confirmedKey;
    private long idPropertiesGender;

}
