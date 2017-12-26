function main() {
  document.querySelector("#buttonhome").addEventListener("click", home);
  document.querySelector("#buttonpromocoes").addEventListener("click", promocao);
  document.querySelector("#buttonnossacasa").addEventListener("click", nossacasa);
  document.querySelector("#buttoncardapio").addEventListener("click", cardapio);
  document.querySelector("#buttonlocalizacao").addEventListener("click", localizacao);
  document.querySelector("#buttoncontato").addEventListener("click", scrollcontato);
}

function home() {
  window.scrollTo(0,0);
}

function nossacasa() {
  document.querySelector("#nossacasa").scrollIntoView();
}

function promocao() {
  document.querySelector("#sessaopromocoes").scrollIntoView();
}

function cardapio() {
  document.querySelector("#sessaocardapio").scrollIntoView();
}

function localizacao() {
  document.querySelector("#sessaolocalizacao").scrollIntoView();
}

function scrollcontato() {
  document.querySelector("#sessaocontato").scrollIntoView();
}

function mostrarpizzas() {
  document.querySelector("#botao-bebida").classList.remove("ativo");
  document.querySelector("#botao-pizza").classList.add("ativo");
  document.querySelector("#pizzas").style.display = 'block';
  document.querySelector("#bebidas").style.display = 'none';
}

function mostrarbebidas() {
  document.querySelector("#botao-pizza").classList.remove("ativo");
  document.querySelector("#botao-bebida").classList.add("ativo");
  document.querySelector("#pizzas").style.display = 'none';
  document.querySelector("#bebidas").style.display = 'block';
}

window.addEventListener("load", main);
