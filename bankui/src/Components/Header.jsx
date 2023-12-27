import React from 'react'
import './Header.css'

function Header() {
  return (
    <>
    <div className="site-section">
          <div className="container">
              <div className="row mb-4">
                  <div className="col-md-7">
                      <h2 className="heading-21921">Account Information</h2>
                  </div>
              </div>
              <div className="row">
                  <div className="col-md-6">
                      <div className=" mb-4">
                          <div className="form-group">
                              <label for="customerName">Name</label>
                              <input type="text" className="form-control" id='customerName' />
                          </div>
                          <div className="form-group">
                              <label for="customerEmail">Email</label>
                              <input type="email" className="form-control" id='customerEmail'   />
                          </div>
                          <div className="form-group">
                              <label for="customerMobileNum">Mobile Number</label>
                              <input type="text" className="form-control " id="customerMobileNum"   />
                          </div>
                      </div>
                  </div>
                  <div className="col-md-6">
                      <div className=" mb-4">
                          <div className="form-group">
                              <label for="customerAccNo">Account Number</label>
                              <input type="text" className="form-control" id='customerAccNo'   />
                          </div>
                          <div className="form-group">
                              <label for="customerAccountType">Account Type</label>
                              <input type="email" className="form-control" id='customerAccountType'   />
                          </div>
                          <div className="form-group">
                              <label for="branchAddress">Branch Address</label>
                              <input type="text" className="form-control " id="branchAddress"   />
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div><div className="row mb-5">
              <div className="col">
                  <div className="">
                      <button className="btn btn-eazybank" routerLink="/dashboard">
                          BACK
                      </button>
                  </div>
              </div>
          </div></>
  )
}

export default Header