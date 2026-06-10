import { Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import AddUser from "./pages/AddUser";
import AddProperty from "./pages/AddProperty";
import AddAvailability from "./pages/AddAvailability";
import CreateBooking from "./pages/CreateBooking";
import Bookings from "./pages/Bookings";
import Reviews from "./pages/Reviews";

function App() {
  return (
    <>
      <nav className="navbar">
        <h2>Airbnb Booking</h2>
        <div>
          <Link to="/">Home</Link>
          <Link to="/users">Add User</Link>
          <Link to="/property">Add Property</Link>
          <Link to="/availability">Availability</Link>
          <Link to="/booking">Booking</Link>
          <Link to="/bookings">Bookings</Link>
          <Link to="/reviews">Reviews</Link>
        </div>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/users" element={<AddUser />} />
        <Route path="/property" element={<AddProperty />} />
        <Route path="/availability" element={<AddAvailability />} />
        <Route path="/booking" element={<CreateBooking />} />
        <Route path="/bookings" element={<Bookings />} />
        <Route path="/reviews" element={<Reviews />} />
      </Routes>
    </>
  );
}

export default App;