// src/components/Login.jsx

import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router";
import "./login.css";

function Loginpage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [msgUsername, setMsgUsername] = useState(null);
  const [msgPassword, setMsgPassword] = useState(null);

  const navigate = useNavigate();

  const login = () => {
    if (!username) {
      setMsgUsername("Username cannot be blank");
      return;
    } else {
      setMsgUsername(null);
    }

    if (!password) {
      setMsgPassword("Password cannot be blank");
      return;
    } else {
      setMsgPassword(null);
    }

    const body = { username, password };

    axios
      .post("http://localhost:8080/api/user/token/generate", body)
      .then((response) => {
        const token = response.data.token;
        localStorage.setItem("token", token);
        localStorage.setItem("username", username);

        axios
          .get("http://localhost:8080/api/user/details", {
            headers: {
              Authorization: `Bearer ${token}`,
            },
          })
          .then((resp) => {
            switch (resp.data.role) {
              case "CUSTOMER":
                navigate("/customer");
                break;
              case "VENDOR":
                navigate("/vendor");
                break;
              case "ADMIN":
                navigate("/admin");
                break;
              default:
                break;
            }
          })
          .catch((err) => {
            setMsgUsername("Invalid Credentials");
            console.error(err);
          });
      })
      .catch((err) => {
        setMsgUsername("Invalid Credentials");
        console.error(err);
      });
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="login-card">
        <h2>Login</h2>
        {msgUsername && <div className="text-danger mb-3">{msgUsername}</div>}
        {msgPassword && <div className="text-danger mb-3">{msgPassword}</div>}
        <input
          type="text"
          className="form-control"
          placeholder="Username"
          onChange={(e) => {
            setUsername(e.target.value);
            setMsgUsername(null);
          }}
        />
        <input
          type="password"
          className="form-control"
          placeholder="Password"
          onChange={(e) => {
            setPassword(e.target.value);
            setMsgPassword(null);
          }}
        />
        <button className="btn-login mt-3" onClick={login}>
          Login
        </button>
        <div className="mt-3 signup-link">
          <small>
            Don’t have an account? <a href="/signup">Sign Up</a> <br />
            <a href="/reset-password">Reset Password</a>
          </small>
        </div>
      </div>
    </div>
  );
}

export default Loginpage;
