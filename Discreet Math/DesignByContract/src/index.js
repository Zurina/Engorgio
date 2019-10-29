import rl from 'readline-sync';
import { Account } from './Account';

const account = new Account(100.00);

let exit = true;

console.log('***********************************')
console.log('      WELCOME TO YOUR ACCOUNT      ')
console.log('\n   ' + account.getCurrentBalance() + '\n');
console.log('***********************************')


while (exit) {
    console.log("\n\n1 - Deposit \n2 - Withdraw \n3 - Current balance \n4 - Exit\n");

    let resp = rl.keyIn("Choose your action? : ");

    try {
        switch (resp) {
            case "1": {
                const deposit = rl.questionFloat("How much would you wish to deposit?\n Amount: ");
                account.deposit(deposit);
                console.log('***********************************')
                console.log('\n' + account.getCurrentBalance() + '\n');
                console.log('***********************************')
            }
                break;
            case "2": {
                const withdraw = rl.questionFloat("How much would you like to withdraw?\n Amount:");
                account.withdraw(withdraw);
                console.log('***********************************')
                console.log('\n' + account.getCurrentBalance() + '\n');
                console.log('***********************************')
            }
                break;
            case "3": {
                console.log('***********************************')
                console.log('\n' + account.getCurrentBalance() + '\n');
                console.log('***********************************')
            }
                break;
            case "4": {
                exit = false;
            }
                break;
            default: {
                console.log('!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!')
                console.log("\nInvalid action!\n")
                console.log('!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!')
                rl.question('\nPress Enter to proceed\n\n\n');
            }
        }
    } catch (error) {
        console.log('!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!')
        console.log('\nERROR :\n', error.message, '\n');
        console.log('!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!')
        rl.question('\nPress Enter to proceed\n\n\n');
    }
}
console.log(' ')
console.log(`
< Thank you come again! >
        \\   ^__^
         \\  (oo)\\_______
            (__)\\       )\\/\\
                ||----w |
                ||     ||`)
process.exit(0);