import React from 'react'
import './Balance.css'

function Balance() {
  return (
    <div>
        <div className="site-section">
  <div className="table-responsive-md">
    <div className="row mb-4">
      <div className="col-md-7">
        <h3 className="heading-21921">Current Balance</h3>
      </div>
    </div>
    <div className="row text-white align-items-center text-center h-100">
      <div className="col-md-4 bg-dark p-5 " style="height:130px;">
        <h1 className="text-white">Transaction</h1>
      </div>
    </div>
  </div>
  <div className="table-responsive-md">
    <div className="row mb-4">
      <div className="col-md-7">
        <h3 className="heading-21921">Transaction Details</h3>
      </div>
    </div>
    <table className="table table-striped table-hover">
      <thead className="table-dark">
        <tr>
          <th scope="col">Date</th>
          <th scope="col">Summary</th>
          <th scope="col">Withdrawal</th>
          <th scope="col">Deposit</th>
          <th scope="col">Closing Balance</th>
        </tr>
      </thead>
      <tbody>
        {/* <tr *ngFor="let transaction of transactions">
          <th>{{transaction.transactionDt}}</th>
          <td>{{transaction.transactionSummary}}</td>
          <td>{{transaction.transactionType=='Withdrawal' ? (transaction.transactionAmt | currency) : ' '}}</td>
          <td>{{transaction.transactionType=='Deposit' ? (transaction.transactionAmt | currency) : ' '}}</td>
          <td>{{transaction.closingBalance | currency}}</td>
        </tr> */}
      </tbody>
    </table>
    </div>
    <div className="row mb-5">
      <div className="col">
        <div className="">
          <button className="btn btn-eazybank" routerLink="/dashboard">
            BACK
          </button>
        </div>
      </div>
    </div>
</div>
    </div>
  )
}

export default Balance