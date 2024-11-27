import React, { useEffect, useState } from "react";
import { connect } from "react-redux";
import * as actions from "../../../store/actions/index";
import classes from "./DashBoard.module.css";

const UserDashboard = ({ id, total, pending, approved, num, getMonthDetails, receipts }) => {
  const [month, setMonth] = useState("");

  useEffect(() => {
    const d = new Date();
    const monthNames = [
      "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", 
      "JUNE", "JULY", "AUGUST", "SEPTEMBER", 
      "OCTOBER", "NOVEMBER", "DECEMBER"
    ];
    const currentMonth = monthNames[d.getMonth()];
    setMonth(currentMonth);
    getMonthDetails(currentMonth, id);
  }, [getMonthDetails, id]);

  const handleMonthChange = (event) => {
    const selectedMonth = event.target.value;
    setMonth(selectedMonth);
    getMonthDetails(selectedMonth, id);
  };

  return (
    <div className={classes.DashBoard}>
      <div className={classes.monthHeader}>
        <h1>Expense & Receipt Manager</h1>
        <select name="month" value={month} onChange={handleMonthChange}>
          {[
            "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", 
            "JUNE", "JULY", "AUGUST", "SEPTEMBER", 
            "OCTOBER", "NOVEMBER", "DECEMBER"
          ].map((m) => (
            <option key={m} value={m}>
              {m.charAt(0) + m.slice(1).toLowerCase()}
            </option>
          ))}
        </select>
      </div>

     

      <div className={classes.receipts}>
        <h2>Receipts</h2>
        {receipts && receipts.length > 0 ? (
          receipts.map((receipt, index) => (
            <div key={index} className={classes.receiptCard}>
              <p>{receipt.title}</p>
              <p>Amount: {receipt.amount}</p>
              <p>Date: {receipt.date}</p>
            </div>
          ))
        ) : (
          <p>No receipts found</p>
        )}
      </div>
    </div>
  );
};

const mapStatetoProps = (state) => ({
  id: state.user.id,
  total: state.dashboard.totalExpense,
  approved: state.dashboard.approvedExpense,
  pending: state.dashboard.pendingExpense,
  num: state.dashboard.numberofExpenses,
  receipts: state.dashboard.receipts,
});

const mapDispatchtoProps = (dispatch) => ({
  getMonthDetails: (month, uid) => dispatch(actions.getMonthDetails(month, uid)),
});

export default connect(mapStatetoProps, mapDispatchtoProps)(UserDashboard);
