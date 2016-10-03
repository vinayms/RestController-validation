package com.spring.validated.example.bean;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.spring.validated.example.controller.MethodPOSTValidation;
import com.spring.validated.example.controller.MethodPUTValidation;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JacksonStdImpl
public class Rules implements Serializable {
    @NotNull(groups = MethodPUTValidation.class , message = "ruleId cannot be null")
    @NotEmpty(groups = MethodPUTValidation.class , message = "ruleId cannot be null")
    private String ruleId;
    @NotNull(groups = {MethodPOSTValidation.class, MethodPUTValidation.class} ,message = "ruleName cannot be null")
    @NotEmpty(groups = {MethodPOSTValidation.class, MethodPUTValidation.class} ,message = "ruleName cannot be null")
    private String ruleName;

    private String ruleDescription;
    @NotNull(groups = {MethodPOSTValidation.class, MethodPUTValidation.class} , message = "merchant cannot be null")
    @NotEmpty(groups = {MethodPOSTValidation.class, MethodPUTValidation.class} ,message = "merchant cannot be null")
    private String merchant;
    public Rules(){}

    @Override
    public String toString() {
        return "Rules{" +
                "ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", ruleDescription='" + ruleDescription + '\'' +
                ", merchant='" + merchant + '\'' +
                '}';
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
}
