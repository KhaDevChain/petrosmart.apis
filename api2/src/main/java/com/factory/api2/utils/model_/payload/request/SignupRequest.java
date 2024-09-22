package com.factory.api2.utils.model_.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    public String Username; // đại diện cho SKU
    public String Email;
    public String Password;
    public String PasswordConfirm;
    public String Fullname;
    public String StationId;
    public String RoleId;
}
