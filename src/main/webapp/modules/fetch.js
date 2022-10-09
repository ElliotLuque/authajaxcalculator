import { calcularUI, loginUI, logoutUI } from "./ui.js";

const BASE_URL = "http://localhost:8080/authajaxcalculator/calculadora";

async function calcular() {
  const operacion = document.getElementById("operacion").value;
  const op1 = document.getElementById("op1").value;
  const op2 = document.getElementById("op2").value;

  const response = await fetch(`${BASE_URL}?op=calcular`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    credentials: "include",
    body: JSON.stringify({
      op1: op1,
      op2: op2,
      operacion: operacion,
    }),
  });
  const msg = await response.json();

  calcularUI(msg);
}

async function login() {
  const login = document.getElementById("login").value;
  const password = document.getElementById("pass").value;

  const response = await fetch(`${BASE_URL}?op=login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    credentials: "include",
    body: JSON.stringify({
      login: login,
      pass: password,
    }),
  });

  const msg = await response.json();

  loginUI(msg);
}

async function logout() {
  const response = await fetch(`${BASE_URL}?op=logout`, {
    method: "POST",
    credentials: "include",
  });
  const msg = await response.json();

  logoutUI(msg);
}

export { calcular, login, logout };
