import { useState } from "react";
import API from "../api/axiosConfig";

function CreateBooking() {
  const [booking, setBooking] = useState({
    propertyId: "",
    guestId: "",
    startDate: "",
    endDate: "",
  });

  const handleChange = (e) => {
    setBooking({ ...booking, [e.target.name]: e.target.value });
  };

  const submitBooking = async (e) => {
    e.preventDefault();

    try {
      await API.post("/bookings", booking);
      alert("Booking created successfully");
      setBooking({ propertyId: "", guestId: "", startDate: "", endDate: "" });
    } catch (error) {
      alert(error.response?.data?.error || "Booking failed");
    }
  };

  return (
    <div className="form-container">
      <h2>Create Booking</h2>

      <form onSubmit={submitBooking}>
        <input name="propertyId" placeholder="Property ID" value={booking.propertyId} onChange={handleChange} />
        <input name="guestId" placeholder="Guest ID" value={booking.guestId} onChange={handleChange} />
        <input type="date" name="startDate" value={booking.startDate} onChange={handleChange} />
        <input type="date" name="endDate" value={booking.endDate} onChange={handleChange} />

        <button type="submit">Book Now</button>
      </form>
    </div>
  );
}

export default CreateBooking;