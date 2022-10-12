/* global fetch */

var btnpegar;

function aoCarregarPagina() {
    btnpegar = document.getElementById("btnpegar");
    btnpegar.addEventListener('click', requerercep);
}

function requerercep() {
    var cep = document.getElementById('txtcep').value;
    const endpoint = "https://viacep.com.br/ws/" + cep + "/json/";

    fetch(endpoint)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                document.getElementById("lblcidade").value = data.localidade;
                document.getElementById("lblbairro").value = data.bairro;
                document.getElementById("lblrua").value = data.logradouro;


            })


            .catch(() => console.log("ops!"));
}