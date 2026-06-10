import { useEffect, useState } from "react";
import API from "../api/axiosConfig";

function Bookings() {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    API.get("/bookings")
      .then((res) => setBookings(res.data))
      .catch((err) => console.log(err));
  }, []);

  const cancelBooking = async (id) => {
    await API.put(`/bookings/${id}/cancel`);
    alert("Booking cancelled");
    window.location.reload();
  };

  const completeBooking = async (id) => {
    await API.put(`/bookings/${id}/complete`);
    alert("Booking completed");
    window.location.reload();
  };

  return (
    <div className="container">
      <h2>All Bookings</h2>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Property ID</th>
            <th>Guest ID</th>
            <th>Start</th>
            <th>End</th>
            <th>Total Price</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {bookings.map((b) => (
            <tr key={b.id}>
              <td>{b.id}</td>
              <td>{b.property?.id}</td>
              <td>{b.guest?.id}</td>
              <td>{b.startDate}</td>
              <td>{b.endDate}</td>
              <td>₹{b.totalPrice}</td>
              <td>{b.status}</td>
              <td>
                <button onClick={() => cancelBooking(b.id)}>Cancel</button>
                <button onClick={() => completeBooking(b.id)}>Complete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Bookings;