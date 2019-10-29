export class Account {
    constructor(accountBalance) {
        pre: {
            typeof accountBalance === 'number', "The accountBalance must be a number";
            accountBalance >= 0, "The account cannot have a negative balance";
        }
        this.accountBalance = accountBalance;
    }

    /**
     * Account deposit method with design by contract implementation
     * @throws {Error} - if contract is violated an exception is thrown
     * @param {number} amount - value to withdraw
     * @returns {number} accountBalance after deposit
     */
    deposit(amount) {
        pre: {
            typeof amount === 'number', "Argument must be a number";
            amount > 0.00, "Cannot deposit 0.00DKK or negative amounts"
        }
        return this.accountBalance += amount;
    }

    /**
     * Account withdraw method with design by contract implementation
     * @throws {Error} - if contract is violated an exception is thrown
     * @param {number} amount - value to withdraw
     * @returns {number} accountBalance after withdraw
     */
    withdraw(amount) {
        pre: {
            typeof amount === 'number', "Argument must be a number";
            amount > 0.00, "Cannot withdraw nothing or a negative amount";
        }
        post: {
            this.accountBalance - amount > 0.00, "Cannot withdraw more than account balance"

        }
        this.accountBalance -= amount;
        return this.accountBalance;
    }

    getCurrentBalance() {
        return `Account balance is : ${this.accountBalance}DKK`
    }
}