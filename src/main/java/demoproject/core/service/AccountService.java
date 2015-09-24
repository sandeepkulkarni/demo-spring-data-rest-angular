package demoproject.core.service;

import demoproject.core.entity.Account;
import demoproject.core.entity.Blog;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public interface AccountService {
    public Account findAccount(Long accountId);
    public Account createAccount(Account account);
    public Blog createBlog(Long accountId, Blog blog);
}
