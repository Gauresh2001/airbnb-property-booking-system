import { useEffect, useState } from "react";
import API from "../api/axiosConfig";

function Home() {
  const [properties, setProperties] = useState([]);

  useEffect(() => {
    API.get("/properties")
      .then((res) => setProperties(res.data))
      .catch((err) => console.log(err));
  }, []);

  return (
    <div className="container">
      <h1>Available Properties</h1>

      <div className="grid">
        {properties.map((p) => (
          <div className="card" key={p.id}>
            <h3>{p.title}</h3>
            <p>{p.description}</p>
            <p><b>Location:</b> {p.location}</p>
            <p><b>Price:</b> ₹{p.pricePerNight}</p>
            <p><b>Rating:</b> ⭐ {p.rating}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Home;