package com.github.Filmorum.model.enums;

public class ValidateSignup {

    public Boolean nicknameExists;
    public Boolean emailExists;

    public ValidateSignup(){
        nicknameExists = false;
        emailExists = false;
    }

    public Boolean getNicknameExists() {
        return nicknameExists;
    }

    public void setNicknameExists(Boolean nicknameExists) {
        this.nicknameExists = nicknameExists;
    }

    public Boolean getEmailExists() {
        return emailExists;
    }

    public void setEmailExists(Boolean emailExists) {
        this.emailExists = emailExists;
    }
}
