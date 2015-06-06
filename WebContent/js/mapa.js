var map;
var idInfoBoxAberto;
var infoBox = [];
var markers = [];

function initialize() {	
	var latlng = new google.maps.LatLng(-18.8800397, -47.05878999999999);
	
    var options = {
        zoom: 5,
		center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("mapa"), options);
}

initialize();

function abrirInfoBox(id, marker) {
	if (typeof(idInfoBoxAberto) == 'number' || typeof(infoBox[idInfoBoxAberto]) == 'object') {
		infoBox[idInfoBoxAberto].close();
	}

	infoBox[id].open(map, marker);
	idInfoBoxAberto = id;
}

function carregarPontos() {
	$.getJSON('js/pontos.json', function(pontos) {
		
		var latlngbounds = new google.maps.LatLngBounds();
		
		$.each(pontos, function(index, ponto) {
			var marker = new google.maps.Marker({
				position: new google.maps.LatLng(ponto.Latitude, ponto.Longitude),
				icon: ponto.Icon,
				title: ponto.Title
			});
			
			var myOptions = {
				content: "<p class='text-center'><b>"+ponto.Nome+"</b>"+
								"<img width='265' height='70' src='img/localidades/id/" + ponto.Id + ".jpg' /></p>"+
								"<p class='text-left'>"+
									"<b>Categoria: </b>" + ponto.Categoria + "</br>"+
									"<b>Endereço: </b>" + ponto.Endereco + "</br>"+
									"<b>Mais Informações: </b><a target='_blank' href='"+ponto.Site+"'>Website</a></br>"+
									"<b>Faixa Etária Permitida: </b>" + ponto.Faixa_Etaria + "</br>"+
								"</p>"+
								"<form>"+
									"<button type='button' class='btn btn-default' onclick='GravarRoteiro("+ponto.Id+")'>"+
										"Adicionar ao Roteiro</button>"+
								"</form>",
				pixelOffset: new google.maps.Size(-160, 0)
        	};

			infoBox[ponto.Id] = new InfoBox(myOptions);
			infoBox[ponto.Id].marker = marker;
			
			infoBox[ponto.Id].listener = google.maps.event.addListener(marker, 'click', function (e) {
				abrirInfoBox(ponto.Id, marker);
			});	
			markers.push(marker);
			latlngbounds.extend(marker.position);
		});
		var markerCluster = new MarkerClusterer(map, markers);
		map.fitBounds(latlngbounds);
	});
}

function GravarRoteiro(ponto){		
	var xmlhttp;
	if (window.XMLHttpRequest){
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	 }
	else{
		// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			var response = xmlhttp.responseText;
			alert(response);
		}
	}
	xmlhttp.open("GET","back-end/addLocalidadeRoteiro.php?idLocalidade="+ponto, true);
	xmlhttp.send();
}

carregarPontos();