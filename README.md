# Theolanthrophy Bank Corporation - ATM System

Welcome to the **ATM System** by **Theolanthrophy Bank Corporation**. This project demonstrates a fully functional, console-based ATM system that provides essential banking services, including balance checks, withdrawals, deposits, loan management, and transaction history tracking.

## Overview

The ATM system provides a simulation of basic banking operations, designed to run in a terminal or console environment. This system is built with Java and implements common ATM functionalities such as withdrawals, deposits, loan management, and transaction history review while also offering user feedback at the end of each session.

## Theolanthrophy Bank Corporation

**Theolanthrophy Bank Corporation** embodies several key qualities that enhance its appeal:

1. **Positive Connotation**: The term "philanthropy" suggests a commitment to social responsibility, community support, and ethical banking practices, resonating well with consumers who value corporate social responsibility.

2. **Professional Sound**: The inclusion of "Corporation" gives the name a formal, established feel, inspiring trust among potential customers.

3. **Memorable and Unique**: "Theolantrophy" is distinctive and catchy, making it easier for customers to remember.

4. **Versatility**: The name can attract a diverse clientele, including individuals and businesses prioritizing ethical banking practices and community involvement.

### Attention-Grabbing Qualities
- **Philanthropic Appeal**: With increasing consumer interest in socially responsible businesses, a name suggesting giving back can attract customers looking for a bank that aligns with their values.
- **Professionalism**: The formal nature of "Corporation" suggests reliability and stability, critical attributes for a bank.
- **Branding Potential**: The unique combination of "Theo" and "philanthropy" lends itself well to branding initiatives that highlight community projects, charitable donations, and a focus on customer welfare.

## Table of Contents
1. [Features](#features)
2. [System Requirements](#system-requirements)
3. [Usage](#usage)
4. [Transaction Limitations](#transaction-limitations)
5. [Error Handling](#error-handling)
6. [Feedback](#feedback)
7. [Contributing](#contributing)

## Features

- **PIN-based login** with a 3-attempt limit for enhanced security.
- **Account Balance Inquiry** to check the current available balance.
- **Withdrawals** with limits on amounts and frequency.
- **Deposits** with set conditions for accepted amounts.
- **Loan Management**, including requesting and repaying loans.
- **Transaction History** that displays recent transactions.
- **Inactivity Timeout**, automatically terminating sessions after 60 seconds of inactivity.
- **User Feedback** to rate the banking experience after each session.

## System Requirements

To run this system, you need:
- **Java JDK 8** or higher
- Any terminal/console interface for executing Java programs
- Optional: **Visual Studio Code** for easier project management and editing

## Usage

1. Upon starting the program, users are required to enter the correct **PIN** (default: `102030`) within 3 attempts to access the system.
2. After successful login, users can choose from the following **Transaction Menu**:
    - **Check Account Balance**: Displays the current balance.
    - **Withdraw**: Withdraw funds, subject to available balance and ATM limits.
    - **Deposit**: Deposit funds with conditions for accepted denominations.
    - **Loan**: Manage loans by requesting or repaying.
    - **Transaction History**: Review the last 5 transactions.
    - **Exit**: End the session and provide optional feedback.
3. The system will automatically terminate after 60 seconds of inactivity.

### Transaction Limitations
- **Withdrawals**: Minimum of ₱100, maximum of ₱20,000, and amounts must be multiples of ₱100.
- **Deposits**: Minimum of ₱100, maximum of ₱50,000, and amounts must be multiples of ₱100.
- **Loans**: Minimum loan request of ₱5,000, maximum of ₱50,000, and loan request amounts must be multiples of ₱5,000.

## Error Handling

The system handles common user errors, such as:
- **Invalid Data Types**: Non-numeric inputs trigger an error message and safely terminate the program.
- **Insufficient Funds**: If withdrawal or loan payment exceeds the account balance, the transaction is halted.
- **Incorrect PIN**: After 3 incorrect attempts, the system terminates.

## Feedback

At the end of each session, users are prompted to provide feedback on their experience:
- Options range from **Very Good** to **Very Poor**, or users can opt-out of providing feedback.

## Contributing

Feel free to fork this project and submit **pull requests**. Contributions are welcome to enhance functionality, fix bugs, or improve overall design.