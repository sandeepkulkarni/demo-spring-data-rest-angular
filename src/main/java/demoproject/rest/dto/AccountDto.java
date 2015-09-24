package demoproject.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import demoproject.core.entity.Account;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class AccountDto extends ResourceSupport {
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Account toAccount() {
        Account account = new Account();
        account.setName(name);
        account.setPassword(password);
        return account;
    }
}
