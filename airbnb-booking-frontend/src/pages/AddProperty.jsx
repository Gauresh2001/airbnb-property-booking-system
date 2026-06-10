import { useState } from "react";
import API from "../api/axiosConfig";

function AddProperty() {
  const [property, setProperty] = useState({
    title: "",
    description: "",
    location: "",
    pricePerNight: "",
    hostId: "",
  });

  const handleChange = (e) => {
    setProperty({ ...property, [e.target.name]: e.target.value });
  };

  const submitProperty = async (e) => {
    e.preventDefault();
    await API.post("/properties", property);
    alert("Property added successfully");
    setProperty({
      title: "",
      description: "",
      location: "",
      pricePerNight: "",
      hostId: "",
    });
  };

  return (
    <div className="form-container">
      <h2>Add Property</h2>

      <form onSubmit={submitProperty}>
        <input name="title" placeholder="Title" value={property.title} onChange={handleChange} />
        <textarea name="description" placeholder="Description" value={property.description} onChange={handleChange}></textarea>
        <input name="location" placeholder="Location" value={property.location} onChange={handleChange} />
        <input name="pricePerNight" placeholder="Price Per Night" value={property.pricePerNight} onChange={handleChange} />
        <input name="hostId" placeholder="Host ID" value={property.hostId} onChange={handleChange} />

        <button type="submit">Add Property</button>
      </form>
    </div>
  );
}

export default AddProperty;