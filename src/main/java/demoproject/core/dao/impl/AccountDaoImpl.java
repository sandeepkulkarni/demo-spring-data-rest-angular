package demoproject.core.dao.impl;

import demoproject.core.dao.AccountDao;
import demoproject.core.entity.Account;
import demoproject.core.entity.Blog;
import org.springframework.stereotype.Repository;

/**
 * Created by sandeep kulkarni on 7/18/2015.
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account findAccount(Long accountId) {
        return null;
    }

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Blog createBlog(Long accountId, Blog blog) {
        return null;
    }
}
