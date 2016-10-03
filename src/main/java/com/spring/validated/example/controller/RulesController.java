package com.spring.validated.example.controller;

import com.spring.validated.example.bean.Rules;
import org.apache.commons.logging.Log;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
public class RulesController {
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(RulesController.class);
    @RequestMapping(value = "/rules", method = RequestMethod.GET)
    public Rules getRules(@RequestParam(value = "merchant") @NotBlank String merchantId,HttpServletResponse httpServletResponse){
        Rules rules = new Rules();
        rules.setMerchant(merchantId);
        rules.setRuleDescription("test rule from controller");
        rules.setRuleName("rule_name");
        rules.setRuleId("894085");
        return rules;
    }
    @RequestMapping(value = "/rules",method = RequestMethod.POST,consumes="application/json" , produces = "application/json")
    public @ResponseBody String saveRule(  @Validated({com.spring.validated.example.controller.MethodPOSTValidation.class})@RequestBody Rules rules,BindingResult bindingResult,HttpServletResponse httpServletResponse) throws Exception{
        LOG.info("save() rules :" + rules);
        if(bindingResult.hasErrors()){
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return "SAVE -- VALIDATION_ERROR : "+bindingResult.getFieldErrors();
        }
        LOG.info("no validation exception rule saved");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        return "successfully saved";
    }

    @RequestMapping(value = "/rules",method = RequestMethod.PUT ,consumes="application/json",produces = "application/json")
    public @ResponseBody String updateRule(  @Validated({MethodPUTValidation.class}) @RequestBody Rules rules,BindingResult bindingResult,HttpServletResponse httpServletResponse) throws Exception{
        LOG.info("updateRule() rules : " + rules);
        if(bindingResult.hasErrors()){
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return "UPDATE -- VALIDATION_ERROR : "+bindingResult.getFieldErrors();
        }
        LOG.info("no validation exception rule updated");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        return "successfully updated";
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LOG.info(" validation error ");
        BindingResult bindingResult = ex.getBindingResult();
        List errors = bindingResult.getFieldErrors();
        return errors.toString();
    }
}
