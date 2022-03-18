/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */

/**
 *  2043. 简易银行系统
 *  简单
 *  99ms 100%
 */
public class class2043 {
    long[] balance;

    public class2043(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1> balance.length || account2 > balance.length){
            return false;
        }
        if (balance[account1 - 1] >= money) {
                balance[account1 - 1] -= money;
                balance[account2-1] += money;
                return true;
        } else{
            return false;
        }
    }

    public boolean deposit(int account, long money) {
        if(account> balance.length ){
            return false;
        }
        balance[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account> balance.length ){
            return false;
        }
        if (balance[account - 1] >= money) {
            balance[account - 1] -= money;
            return true;
        } else{
            return false;
        }
    }
}
