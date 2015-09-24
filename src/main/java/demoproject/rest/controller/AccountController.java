package demoproject.rest.controller;

import demoproject.core.entity.Account;
import demoproject.core.entity.Blog;
import demoproject.core.service.AccountService;
import demoproject.core.service.exception.AccountDoesNotExistException;
import demoproject.core.service.exception.AccountExistsException;
import demoproject.core.service.exception.BlogExistsException;
import demoproject.rest.dto.AccountDto;
import demoproject.rest.dto.BlogDto;
import demoproject.rest.dto.asm.AccountDtoAsm;
import demoproject.rest.dto.asm.BlogDtoAsm;
import demoproject.rest.exception.BadRequestException;
import demoproject.rest.exception.ConflictException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
@Controller
@RequestMapping("/rest/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto sentAccount) {
        try {
            Account createdAccount = accountService.createAccount(sentAccount.toAccount());
            AccountDto res = new AccountDtoAsm().toResource(createdAccount);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<AccountDto>(res, headers, HttpStatus.CREATED);
        } catch(AccountExistsException exception) {
            throw new ConflictException(exception);
        }
    }

    @RequestMapping( value="/{accountId}",
            method = RequestMethod.GET)
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long accountId) {
        Account account = accountService.findAccount(accountId);
        if(account != null)
        {
            AccountDto res = new AccountDtoAsm().toResource(account);
            return new ResponseEntity<AccountDto>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<AccountDto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{accountId}/blogs",
            method = RequestMethod.POST)
    public ResponseEntity<BlogDto> createBlog(@PathVariable Long accountId, @RequestBody BlogDto res) {
        try {
            Blog createdBlog = accountService.createBlog(accountId, res.toBlog());
            BlogDto createdBlogRes = new BlogDtoAsm().toResource(createdBlog);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdBlogRes.getLink("self").getHref()));
            return new ResponseEntity<BlogDto>(createdBlogRes, headers, HttpStatus.CREATED);
        } catch(AccountDoesNotExistException exception)
        {
            throw new BadRequestException(exception);
        } catch(BlogExistsException exception)
        {
            throw new ConflictException(exception);
        }
    }


}
