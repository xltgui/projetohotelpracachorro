(function (){
    $("#tabservicos").on("click",".js-delete", function(){
    
        let botaoClicado = $(this); // pega a refencia do botão

        $("#btnServicoSim").attr("data-id", botaoClicado.attr("data-id"));

        $("#modalservico").modal("show");
    });

    $("#btnServicoSim").on("click", function(){
        let botaoSim = $(this);   // pega a refencia do botão  

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/servicos/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/servicos";
            }
        });
    });
})();