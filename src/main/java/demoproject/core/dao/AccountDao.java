package demoproject.core.dao;

import demoproject.core.entity.Account;
import demoproject.core.entity.Blog;

/**
 * Created by sandeep kulkarni on 7/18/2015.
 */
public interface AccountDao {
    public Account findAccount(Long accountId);
    public Account createAccount(Account account);
    public Blog createBlog(Long accountId, Blog blog);
}
