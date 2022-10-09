import { calcular, login, logout } from "./modules/fetch.js";

const loginBtn = document.getElementById("loginBtn");
const logoutBtn = document.getElementById("logoutBtn");
const calcularBtn = document.getElementById("calcularBtn");

calcularBtn.addEventListener("click", calcular);
loginBtn.addEventListener("click", login);
logoutBtn.addEventListener("click", logout);

// Borrar resultado cuando cambie el selector
const selector = document.getElementById("operacion");
selector.addEventListener(
  "change",
  () => (document.getElementById("resultado").innerHTML = "")
);