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

// Borrar datos de modal del login cuando se cierre
const loginModal = document.getElementById("login-modal");
loginModal.addEventListener("hide.bs.modal", () => {
  document.getElementById("login").value = "";
  document.getElementById("pass").value = "";
  document.getElementById("error-login-msg").innerHTML = "";
});
