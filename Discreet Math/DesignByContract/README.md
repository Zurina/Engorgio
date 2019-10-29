# Assigment 7 - Design by Contract Discrete Mathematics

## Description
This is an example of Design by Contract implementation in JavaScript and NodeJS. It is a simple "Bank" type of CLI system with ability to withdraw and deposit to an account.

## Design by Contract description
Deposit method 

    deposit(amount) which should increase the account’s balance
    with the amount, the amount should always be positive.

Withdraw method

    withdraw(amount) which on the other hand should decrease the
    account’s balance. Also this amount should be positive. If the amount
    exceeds the balance, the balance should be left untouched and an exception should be thrown.

Each are implemented using a npm library called [babel-plugin-contracts](https://github.com/codemix/babel-plugin-contracts). This library allows for adding checks similar to Java iContract and C# implementation of the same.

Contracts come in three flavours:

- **preconditions** which run at the start of a function.
- **postconditions** which run at the end of a function.
- **invariants** which run at both the start and end of a block.

Each statement in a contract must evaluate to true for the contract to be valid. If a contract fails, an error will be thrown.

Preconditions are usually used to validate the arguments to a function, or the state of the system before the main function body executes.

Postconditions are used to validate the result or side effects of the function.

Invariants are used to ensure that an assumption holds true for the duration of the function.

## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites
#### Node
- ##### Node installation on Windows

  Just go on [official Node.js website](https://nodejs.org/) and download the installer.
Also, be sure to have `git` available in your PATH, `npm` might need it (You can find git [here](https://git-scm.com/)).

- ##### Node installation on Ubuntu

  You can install nodejs and npm easily with apt install, just run the following commands.

      $ sudo apt install nodejs
      $ sudo apt install npm

- ##### Other Operating Systems
  You can find more information about the installation on the [official Node.js website](https://nodejs.org/) and the [official NPM website](https://npmjs.org/).

If the installation was successful, you should be able to run the following command.

```sh 
$ node --version
v8.11.3

$ npm --version
6.1.0
```

### Installation
 
1. Clone the repo
```sh
$ git clone https://github.com/Zurina/Engorgio
```
2. Go to root of folder then navigate to project
```sh
$ cd ./Discreet Math/DesignByContract
```
3. Install NPM packages
```sh
$ npm install
```
### How to run

1. Navigate to rootfolder of the project
```sh
$ cd ~/Engorgio/Discreet Math/DesignByContract
```
2. Run the project
```sh
$ npm start
```

## Authors

* **Mathias Bigler** - *developer* - [Zurina](https://github.com/Zurina)
* **Stanislav Novitski** - *developer* - [Stani2980](https://github.com/Stani2980)