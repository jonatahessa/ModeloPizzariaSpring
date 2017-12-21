function main() {
  var botoes = document.querySelectorAll(".botoes-top");
  for (var i = 0; i < botoes.length; i++) {
    botoes[i].addEventListener("click", mudarPagina);
  }
}

function mudarPagina(event) {
  var botao = event.target.id;
  var botoes = document.querySelectorAll(".botoes-top");
  desmarcaBotoes(botoes);
  marcaBotao(botao);
  transicaoPaginas(botao);
}

function marcaBotao(botao) {
  document.getElementById(botao).classList.remove('non-selected');
  document.getElementById(botao).classList.add('selected');
}

function desmarcaBotoes(botoes) {
  for (var i = 0; i < botoes.length; i++) {
    botoes[i].classList.remove('selected');
    botoes[i].classList.add('non-selected');
  }
}

function transicaoPaginas(botao) {
  var paginas = document.querySelectorAll(".paginas");
  if (botao == "botao-sua") {
    for (var i = 0; i < paginas.length; i++) {
      if (paginas[i].id == "pagina-sua") {
        paginas[i].classList.remove('non-show-on-click');
        paginas[i].classList.add('show-on-click');
      } else {
       paginas[i].classList.add('non-show-on-click');
       paginas[i].classList.remove('show-on-click');
    }
  }
} else if (botao == "botao-cardapio") {
    for (var i = 0; i < paginas.length; i++) {
      if (paginas[i].id == "pagina-cardapio") {
        paginas[i].classList.remove('non-show-on-click');
        paginas[i].classList.add('show-on-click');
      } else {
        paginas[i].classList.add('non-show-on-click');
        paginas[i].classList.remove('show-on-click');
      }
    }
  } else if (botao == "botao-promo") {
      for (var i = 0; i < paginas.length; i++) {
        if (paginas[i].id == "pagina-promo") {
          paginas[i].classList.remove('non-show-on-click');
          paginas[i].classList.add('show-on-click');
        } else {
          paginas[i].classList.add('non-show-on-click');
          paginas[i].classList.remove('show-on-click');
        }
      }
    } else if (botao == "botao-local") {
        for (var i = 0; i < paginas.length; i++) {
          if (paginas[i].id == "pagina-local") {
            paginas[i].classList.remove('non-show-on-click');
            paginas[i].classList.add('show-on-click');
          } else {
            paginas[i].classList.add('non-show-on-click');
            paginas[i].classList.remove('show-on-click');
          }
        }
      } else if (botao == "botao-contato") {
          for (var i = 0; i < paginas.length; i++) {
            if (paginas[i].id == "pagina-contato") {
              paginas[i].classList.remove('non-show-on-click');
              paginas[i].classList.add('show-on-click');
            } else {
              paginas[i].classList.add('non-show-on-click');
              paginas[i].classList.remove('show-on-click');
            }
        }
    }
}

window.addEventListener("load", main);
