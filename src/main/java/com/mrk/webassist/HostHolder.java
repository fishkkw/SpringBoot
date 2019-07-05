package com.mrk.webassist;

import com.mrk.sys.entity.Account;

public class HostHolder {
    //本地线程变量，在每个线程中都有一份该变量的拷贝，因此有多个线程同时访问的时候也不会发生冲突
    private static ThreadLocal<Account> accounts = new ThreadLocal<>();
    public static Account getAccount() {
    	return accounts.get();
    }
    
    public static void setAccount(Account account) {
    	accounts.set(account);
    }
    public static void clear() {
    	accounts.remove();
    }
    
 
}
