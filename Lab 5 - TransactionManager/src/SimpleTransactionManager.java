class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message){
        super(message);
    }
}

public class SimpleTransactionManager implements TransactionManager{
    private String[] wallets = new String[1000];
    private String[] transactions = new String[10000];
    private int walletCount;
    private int transactionCount;
    public SimpleTransactionManager(String[] wallets) {
        for (String walletId : wallets) {
            this.wallets[walletCount++] = walletId;
        }
    }

    public boolean isValidWallet(String walletId){
        for (int i = 0; i < this.walletCount; i++){
            if (this.wallets[i] == walletId) return true;
        }
        return false;
    }

    public double getBalance(String walletId) {
        if (!isValidWallet(walletId)) {
            throw new IllegalArgumentException("Sender wallet does not exist.");
        }
  
        double balance = 0.0;
        for (int i = 0; i < transactionCount; i++) {
            String[] parts = transactions[i].split("\\|");
            if (parts[0].equals(walletId)) {
                balance -= Double.parseDouble(parts[2]);
            }
            if (parts[1].equals(walletId)) {
                balance += Double.parseDouble(parts[2]);
            }
        }
  
        return balance;
    }

    public boolean transferFunds(String senderWalletId, String receiverWalletId, double amount) {
        if (senderWalletId != "Wallet0"){
            if (getBalance(senderWalletId) < amount) throw new InvalidTransactionException("Not enough balance in source wallet.");
        }
        if (!isValidWallet(receiverWalletId)) {
            this.wallets[walletCount++] = receiverWalletId;
        }
        String transaction = senderWalletId + "|" + receiverWalletId + "|" + amount;
        this.transactions[transactionCount++] = transaction;
        return true;
    }
}
