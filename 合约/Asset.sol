pragma solidity ^0.4.0;

contract Asset {
    address public issuer;
    mapping (address => uint) public balances;

    event Sent(address from, address to, uint amount);

    constructor() {
        issuer = msg.sender;
    }

    function issue(address receiver, uint amount) public {
      require(msg.sender == issuer, "Only issuer can issue tokens");
        balances[receiver] += amount;
    }

    function send(address receiver, uint amount) public {
      require(balances[msg.sender] >= amount, "Insufficient balance");
        balances[msg.sender] -= amount;
        balances[receiver] += amount;
        emit Sent(msg.sender, receiver, amount);
    }
    
    function getBalance(address account) public  view returns (uint) {
        return balances[account];
    }
    
}
