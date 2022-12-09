(function (){
    $("#tabclientes").on("click",".js-delete", function(){
        
        let botaoClicado = $(this); // pega a refencia do botão

        $("#btnClienteSim").attr("data-id", botaoClicado.attr("data-id"));

        $("#modalcliente").modal("show");
    });

    $("#btnClienteSim").on("click", function(){
        let botaoSim = $(this);   // pega a refencia do botão  

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/clientes";
            }
        });
    });
})();