import { useState } from "react";
import API from "../api/axiosConfig";

function AddUser() {
  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
    role: "GUEST",
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const submitUser = async (e) => {
    e.preventDefault();
    await API.post("/users", user);
    alert("User added successfully");
    setUser({ name: "", email: "", password: "", role: "GUEST" });
  };

  return (
    <div className="form-container">
      <h2>Add User</h2>

      <form onSubmit={submitUser}>
        <input name="name" placeholder="Name" value={user.name} onChange={handleChange} />
        <input name="email" placeholder="Email" value={user.email} onChange={handleChange} />
        <input name="password" placeholder="Password" value={user.password} onChange={handleChange} />

        <select name="role" value={user.role} onChange={handleChange}>
          <option value="GUEST">GUEST</option>
          <option value="HOST">HOST</option>
        </select>

        <button type="submit">Add User</button>
      </form>
    </div>
  );
}

export default AddUser;