import { useState } from "react";
import API from "../api/axiosConfig";

function AddAvailability() {
  const [data, setData] = useState({
    propertyId: "",
    availableFrom: "",
    availableTo: "",
  });

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const submitAvailability = async (e) => {
    e.preventDefault();
    await API.post("/properties/availability", data);
    alert("Availability added successfully");
    setData({ propertyId: "", availableFrom: "", availableTo: "" });
  };

  return (
    <div className="form-container">
      <h2>Add Availability</h2>

      <form onSubmit={submitAvailability}>
        <input name="propertyId" placeholder="Property ID" value={data.propertyId} onChange={handleChange} />
        <input type="date" name="availableFrom" value={data.availableFrom} onChange={handleChange} />
        <input type="date" name="availableTo" value={data.availableTo} onChange={handleChange} />

        <button type="submit">Add Availability</button>
      </form>
    </div>
  );
}

export default AddAvailability;