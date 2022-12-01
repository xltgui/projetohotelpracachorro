(function (){
    $("#tabfuncionarios").on("click",".js-delete", function(){
    
        let botaoClicado = $(this); // pega a refencia do botão

        $("#btnFuncionarioSim").attr("data-id", botaoClicado.attr("data-id"));

        $("#modalfuncionario").modal("show");
    });

    $("#btnFuncionarioSim").on("click", function(){
        let botaoSim = $(this);   // pega a refencia do botão  

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/funcionarios/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/funcionarios";
            }
        });
    });
})();