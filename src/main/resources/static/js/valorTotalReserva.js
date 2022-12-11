(function (){

    const checkboxTaxiDog = document.getElementById("listaServicos1");
	const checkboxTaxiDogValue = Number(document.getElementById("valorServico_1").innerText)
	const checkboxBanhoTosa = document.getElementById("listaServicos2");
	const checkboxBanhoTosaValue = Number(document.getElementById("valorServico_2").innerText)
	const checkboxMedicacao = document.getElementById("listaServicos3")
	const checkboxMedicacaoValue = Number(document.getElementById("valorServico_3").innerText)
	const inputDataEntrada = document.getElementById("txtdataentrada");
	const inputDataSaida = document.getElementById("txtdatasaida");
	//console.log(inputDataEntrada, inputDataSaida)	
	const pesoCachorroSelect = document.getElementById("listaCachorrosSelect");
	const pesoCachorro = Number(pesoCachorroSelect.options[pesoCachorroSelect.selectedIndex].innerText)

	let totalServicosReservaSelector = document.getElementById("total-reserva");
	

	let total = 0;

	//console.log(checkboxTaxiDog);

	const transformData = (data) => {
		let parts = String(data??new Date()).split('-');
		let dataParsed = new Date(parts[0], parts[1] - 1, parts[2]); 
		return dataParsed;
	}

	const calculateTotalCallBack = () => {
		let totalInterno = 0;
        if (pesoCachorro) {
			if(pesoCachorro >= 0 && pesoCachorro <= 15 ){
				totalInterno += 55;
			}
			if(pesoCachorro >= 16 && pesoCachorro <= 25 ){
				totalInterno += 65;
			}
			if(pesoCachorro >= 26){
                totalInterno += 75
			}    
		    
		}
		
		const Difference_In_Time = transformData(inputDataSaida.value).getTime() - transformData(inputDataEntrada.value).getTime();
		totalInterno *= Difference_In_Time / (1000 * 3600 * 24);
		
		totalInterno += (
			Number(checkboxTaxiDog.checked) * checkboxTaxiDogValue + 
			Number(checkboxBanhoTosa.checked) * checkboxBanhoTosaValue +
			Number(checkboxMedicacao.checked) * checkboxMedicacaoValue
		);
	
		totalServicosReservaSelector.innerText =Number.isNaN(totalInterno)?0: totalInterno

		total = totalInterno

	}
	const validateData = (event) =>{
		console.log(event)
		if((event.target.id === inputDataSaida.id && inputDataEntrada.value) || (event.target.id === inputDataEntrada.id && inputDataSaida.value)){
			const dataZero = transformData(inputDataSaida.value)
			const dataUm = transformData(inputDataEntrada.value)
			if(dataZero.getTime() < dataUm.getTime()){
				inputDataSaida.value = undefined;
			}
			
		}
	}
	inputDataSaida.addEventListener('change', validateData)
	inputDataEntrada.addEventListener('change', validateData)
	inputDataSaida.addEventListener('change', calculateTotalCallBack)
	inputDataEntrada.addEventListener('change', calculateTotalCallBack)
	
	checkboxTaxiDog.addEventListener('change',calculateTotalCallBack)
	checkboxBanhoTosa.addEventListener('change',calculateTotalCallBack)
	checkboxMedicacao.addEventListener('change',calculateTotalCallBack)

	calculateTotalCallBack()

	/*console.log(checkboxTaxiDog);
	if(checkboxTaxiDog){
		console.log(checkboxTaxiDog)
		debugger
		checkboxTaxiDog.addEventListener('change', function() {
			if (this.checked) {
			  if (dataEntrada && dataSaida) {
				  totalServicos += 35;
				  total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
				  totalServicosReservaSelector.textContent = total;
			  }
			} else {
			  if (dataEntrada && dataSaida) {
				  totalServicos -= 35;
				  total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
				  totalServicosReservaSelector.textContent = total;
			  }
			}
		  });
	}


	let checkboxBanhoTosa = document.querySelector("#listaServicos2");
	if(checkboxBanhoTosa){
		checkboxBanhoTosa.addEventListener('change', function() {
			if (this.checked) {
			  if (dataEntrada && dataSaida) {
				  totalServicos += 65;
				  total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
				  totalServicosReservaSelector.textContent = total;
			  }
			} else {
			  if (dataEntrada && dataSaida) {
				  totalServicos -= 65;
				  total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
				  totalServicosReservaSelector.textContent = total;
			  }
			}
		  });
	}
	
    
	let checkboxMedicacao = document.querySelector("#listaServicos3");
	if(checkboxMedicacao){
	checkboxMedicacao.addEventListener('change', function() {
	  if (this.checked) {
		if (dataEntrada && dataSaida) {
	    	totalServicos += 25;
			total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
		    totalServicosReservaSelector.textContent = total;
		}
	  } else {
		if (dataEntrada && dataSaida) {
		    totalServicos -= 25;
			total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
		    totalServicosReservaSelector.textContent = total;
		}
	  }
	});
}


	let inputDataEntrada = document.querySelector("#txtdataentradaInput");
	if(inputDataEntrada){
	inputDataEntrada.addEventListener('change', function(data) {
    	let dataText = data.target.value;
		let parts =dataText.split('-');
		let dataParsed = new Date(parts[0], parts[1] - 1, parts[2]); 
		dataEntrada = dataParsed;

		if (dataEntrada && dataSaida) {
			let Difference_In_Time = dataSaida.getTime() - dataEntrada.getTime();
		    totalDiasReserva = Difference_In_Time / (1000 * 3600 * 24);
		    total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
		    totalServicosReservaSelector.textContent = total;
		}
	});
}

	let inputDataSaida = document.querySelector("#txtdatasaida");
	if(inputDataSaida){
	inputDataSaida.addEventListener('change', function(data) {
    	let dataText = data.target.value;
		let parts =dataText.split('-');
		let dataParsed = new Date(parts[0], parts[1] - 1, parts[2]); 
		dataSaida = dataParsed;

		if (dataEntrada && dataSaida) {
			let Difference_In_Time = dataSaida.getTime() - dataEntrada.getTime();
		    totalDiasReserva = Difference_In_Time / (1000 * 3600 * 24);
		    total = (totalServicosPesoCachorro + totalServicos) * totalDiasReserva;
		    totalServicosReservaSelector.textContent = total;
		}
	});
}


	

	console.log(pesoCachorro);
*/
	

})();