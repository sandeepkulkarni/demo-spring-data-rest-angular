package demoproject.rest.dto.asm;

import demoproject.core.entity.Account;
import demoproject.rest.controller.AccountController;
import demoproject.rest.dto.AccountDto;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class AccountDtoAsm extends ResourceAssemblerSupport<Account, AccountDto> {

    public AccountDtoAsm() {
        super(AccountController.class, AccountDto.class);
    }

    @Override
    public AccountDto toResource(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setName(account.getName());
        accountDto.setPassword(account.getPassword());
        accountDto.add(linkTo(methodOn(AccountController.class).getAccount(account.getAccountId())).withSelfRel());
        return accountDto;
    }
}
