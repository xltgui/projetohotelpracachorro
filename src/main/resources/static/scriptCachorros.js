(function (){
    $("#tabcachorros").on("click",".js-delete", function(){
        
        let botaoClicado = $(this); // pega a refencia do botão

        $("#btnCachorroSim").attr("data-id", botaoClicado.attr("data-id"));

        $("#modalcachorro").modal("show");
    });

    $("#btnCachorroSim").on("click", function(){
        let botaoSim = $(this);   // pega a refencia do botão  

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/cachorros/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/cachorros";
            }
        });
    });
})();