(function (){
    $("#tabreservas").on("click",".js-delete", function(){
    
        let botaoClicado = $(this); // pega a refencia do botão

        $("#btnReservaSim").attr("data-id", botaoClicado.attr("data-id"));

        $("#modalreserva").modal("show");
    });

    $("#btnReservaSim").on("click", function(){
        let botaoSim = $(this);   // pega a refencia do botão  

        let id = botaoSim.attr("data-id");

        $.ajax({
            url: "/reservas/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/reservas";
            }
        });
    });
})();