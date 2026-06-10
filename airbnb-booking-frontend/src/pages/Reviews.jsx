import { useState } from "react";
import API from "../api/axiosConfig";

function Reviews() {
  const [review, setReview] = useState({
    propertyId: "",
    guestId: "",
    rating: "",
    comment: "",
  });

  const handleChange = (e) => {
    setReview({ ...review, [e.target.name]: e.target.value });
  };

  const submitReview = async (e) => {
    e.preventDefault();
    await API.post("/reviews", review);
    alert("Review added successfully");
    setReview({ propertyId: "", guestId: "", rating: "", comment: "" });
  };

  return (
    <div className="form-container">
      <h2>Add Review</h2>

      <form onSubmit={submitReview}>
        <input name="propertyId" placeholder="Property ID" value={review.propertyId} onChange={handleChange} />
        <input name="guestId" placeholder="Guest ID" value={review.guestId} onChange={handleChange} />
        <input name="rating" placeholder="Rating 1 to 5" value={review.rating} onChange={handleChange} />
        <textarea name="comment" placeholder="Comment" value={review.comment} onChange={handleChange}></textarea>

        <button type="submit">Add Review</button>
      </form>
    </div>
  );
}

export default Reviews;