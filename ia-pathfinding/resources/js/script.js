//inicia mapa comum
function initBodyMap(){
  var pnts = new Array();
  pnts[0] = {label: '0', id: 0,lat: -29.981386500, lng: -51.135263400, proxpnt : [] };
  pnts[1] = {label: '1',id: 1, lat: -29.983115000, lng: -51.135134700, proxpnt : [] };
  pnts[2] = {label: '2',id: 2, lat: -29.984806300, lng: -51.135048900, proxpnt : [] };
  pnts[3] = {label: '3',id: 3, lat:-29.986516200, lng: -51.134898700, proxpnt : [] };
  pnts[4] = {label: '4',id: 4, lat: -29.988244600, lng: -51.134705500, proxpnt : [] };
  pnts[5] = {label: '5',id: 5, lat: -29.988114500, lng: -51.133997400, proxpnt : [] };
  pnts[6] = {label: '6',id: 6, lat: -29.986441800, lng: -51.134233500, proxpnt : [] };
  pnts[7] = {label: '7',id: 7, lat: -29.984750600, lng: -51.134276400, proxpnt : [] };
  pnts[8] = {label: '8',id: 8, lat:-29.983077800, lng: -51.134383700, proxpnt : [] };
  pnts[9] = {label: '9',id: 9, lat: -29.981405100, lng: 	-51.134405100, proxpnt : [] };
  pnts[10] = {label: '10',id: 10, lat:-29.981367900, lng:	-51.133697000, proxpnt : [] };
  pnts[11] = {label: '11',id: 11, lat: -29.982984900	, lng: -51.133589700, proxpnt : [] };
  pnts[12] = {label: '12',id: 12, lat: -29.984713400	, lng: -51.133439500, proxpnt : [] };
  pnts[13] = {label: '13',id: 13, lat: -29.986404700	, lng: -51.133289300, proxpnt : [] };
  pnts[14] = {label: '14',id: 14, lat: -29.988077300	, lng: -51.133267900, proxpnt : [] };
  pnts[15] = {label: '15',id: 15, lat: -29.988077300	, lng: -51.132495400, proxpnt : [] };
  pnts[16] = {label: '16',id: 16, lat: -29.986367500	, lng: -51.132559800, proxpnt : [] };
  pnts[17] = {label: '17',id: 17, lat: -29.984676200	, lng: -51.132731400, proxpnt : [] };
  pnts[18] = {label: '18',id: 18, lat: -29.981293500	, lng: -51.132924600, proxpnt : [] };
  pnts[19] = {label: '19',id: 19, lat: -29.981256400	, lng: -51.132173500, proxpnt : [] };
  pnts[20] = {label: '20',id: 20, lat: -29.982260000	, lng: -51.132087700, proxpnt : [] };
  pnts[21] = {label: '21',id: 21, lat: -29.982947700	, lng:-51.132087700, proxpnt : [] };
  pnts[22] = {label: '22',id: 22, lat: -29.983654000	, lng: -51.132023300, proxpnt : [] };
  pnts[23] = {label: '23',id: 23, lat: -29.984676200	, lng: -51.131894600, proxpnt : [] };
  pnts[24] = {label: '24',id: 24, lat: -29.986311700	, lng: -51.131787300, proxpnt : [] };
  pnts[25] = {label: '25',id: 25, lat: -29.987928700	, lng:-51.131658600, proxpnt : [] };
  pnts[26] = {label: '26',id: 26, lat: -29.987891500	, lng: -51.130971900, proxpnt : [] };
  pnts[27] = {label: '27',id: 27, lat: -29.986330300	, lng: -51.131100700, proxpnt : [] };
  pnts[28] = {label: '28',id: 28, lat: -29.984620500	, lng: -51.131143600, proxpnt : [] };
  pnts[29] = {label: '29',id: 29, lat:-29.983579600	, lng: -51.131293800, proxpnt : [] };
  pnts[30] = {label: '30',id: 30, lat:-29.982222900	, lng: -51.131379600, proxpnt : [] };
  pnts[31] = {label: '31',id: 31, lat: -29.981144900	, lng: -51.131401100, proxpnt : [] };
  pnts[32] = {label: '32',id: 32, lat: -29.981182000		, lng: -51.130757300, proxpnt : [] };
  pnts[33] = {label: '33',id: 33, lat: -29.982241400	, lng: -51.130607100, proxpnt : []};
  pnts[34] = {label: '34',id: 34, lat: -29.983486700		, lng: -51.130521300, proxpnt : [] };
  pnts[35] = {label: '35',id: 35, lat: 	-29.984527500	, lng: -51.130456900, proxpnt : [] };
  pnts[36] = {label: '36',id: 36, lat: -29.987947300		, lng: -51.130199400, proxpnt : [] };
  pnts[37] = {label: '37',id: 37, lat: -29.987928700	, lng: -51.129362600, proxpnt : [] };
  pnts[38] = {label: '38',id: 38, lat: -29.986181600	, lng:-51.129512800, proxpnt : [] };
  pnts[39] = {label: '39',id: 39, lat: -29.984490400	, lng: -51.129663000, proxpnt : [] };
  pnts[40] = {label: '40',id: 40, lat: -29.981107700	, lng: -51.129941900, proxpnt : [] };
  pnts[41] = {label: '41',id: 41, lat: -29.981051900	, lng: -51.129190900, proxpnt : [] };
  pnts[42] = {label: '42',id: 42, lat: -29.984508900	, lng: -51.128890500, proxpnt : [] };
  pnts[43] = {label: '43',id: 43, lat: -29.987835700	, lng:-51.128611600, proxpnt : [] };
  //fim criação dos pontos
  //cria mapa
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 16,
    center: pnts[28],
  });
  //fim cria mapa
  var p3 = document.getElementById('formGroupExampleInput3').value;
  //inserir marcadores no mapa
  var iconBase ='resources/img/point_black.ico';
  var markers = new Array();
  for (var i = 0; i < pnts.length; i++) {
    markers.push(new google.maps.Marker({
      position: pnts[i],
      map: map,
      icon: iconBase,
      label: {
        fontSize: "1em",
        fontWeight: "bold",
        text: pnts[i].label,
        color: 'white',
      },
      title: 'Ponto '+ pnts[i].id
    }));
    attClick(i);
  }//fim marcadores

  //event click
  function attClick(pos){
    markers[pos].addListener('click', function() {
      var num = parseInt(markers[pos].getLabel().text, 10);
      p3 = num;
      $("#formGroupExampleInput3").attr("value", ""+p3+"");
    });
  }//fim evenct click
}//fim mapa comum




//função map após o cálculo
function initMap() {

  //criação dos pontos
  var pnts = new Array();
  function addpnt(pntf1, pntf2) {
    pntf1.proxpnt.push(pntf2);
    addpnt1(pntf2, pntf1);
  }
  function addpnt1(pntf1, pntf2) {
    pntf1.proxpnt.push(pntf2);
  }
  pnts[0] = {label: '0', id: 0,lat: -29.981386500, lng: -51.135263400, proxpnt : [] };
  pnts[1] = {label: '1',id: 1, lat: -29.983115000, lng: -51.135134700, proxpnt : [] };
  pnts[2] = {label: '2',id: 2, lat: -29.984806300, lng: -51.135048900, proxpnt : [] };
  pnts[3] = {label: '3',id: 3, lat:-29.986516200, lng: -51.134898700, proxpnt : [] };
  pnts[4] = {label: '4',id: 4, lat: -29.988244600, lng: -51.134705500, proxpnt : [] };
  pnts[5] = {label: '5',id: 5, lat: -29.988114500, lng: -51.133997400, proxpnt : [] };
  pnts[6] = {label: '6',id: 6, lat: -29.986441800, lng: -51.134233500, proxpnt : [] };
  pnts[7] = {label: '7',id: 7, lat: -29.984750600, lng: -51.134276400, proxpnt : [] };
  pnts[8] = {label: '8',id: 8, lat:-29.983077800, lng: -51.134383700, proxpnt : [] };
  pnts[9] = {label: '9',id: 9, lat: -29.981405100, lng: 	-51.134405100, proxpnt : [] };
  pnts[10] = {label: '10',id: 10, lat:-29.981367900, lng:	-51.133697000, proxpnt : [] };
  pnts[11] = {label: '11',id: 11, lat: -29.982984900	, lng: -51.133589700, proxpnt : [] };
  pnts[12] = {label: '12',id: 12, lat: -29.984713400	, lng: -51.133439500, proxpnt : [] };
  pnts[13] = {label: '13',id: 13, lat: -29.986404700	, lng: -51.133289300, proxpnt : [] };
  pnts[14] = {label: '14',id: 14, lat: -29.988077300	, lng: -51.133267900, proxpnt : [] };
  pnts[15] = {label: '15',id: 15, lat: -29.988077300	, lng: -51.132495400, proxpnt : [] };
  pnts[16] = {label: '16',id: 16, lat: -29.986367500	, lng: -51.132559800, proxpnt : [] };
  pnts[17] = {label: '17',id: 17, lat: -29.984676200	, lng: -51.132731400, proxpnt : [] };
  pnts[18] = {label: '18',id: 18, lat: -29.981293500	, lng: -51.132924600, proxpnt : [] };
  pnts[19] = {label: '19',id: 19, lat: -29.981256400	, lng: -51.132173500, proxpnt : [] };
  pnts[20] = {label: '20',id: 20, lat: -29.982260000	, lng: -51.132087700, proxpnt : [] };
  pnts[21] = {label: '21',id: 21, lat: -29.982947700	, lng:-51.132087700, proxpnt : [] };
  pnts[22] = {label: '22',id: 22, lat: -29.983654000	, lng: -51.132023300, proxpnt : [] };
  pnts[23] = {label: '23',id: 23, lat: -29.984676200	, lng: -51.131894600, proxpnt : [] };
  pnts[24] = {label: '24',id: 24, lat: -29.986311700	, lng: -51.131787300, proxpnt : [] };
  pnts[25] = {label: '25',id: 25, lat: -29.987928700	, lng:-51.131658600, proxpnt : [] };
  pnts[26] = {label: '26',id: 26, lat: -29.987891500	, lng: -51.130971900, proxpnt : [] };
  pnts[27] = {label: '27',id: 27, lat: -29.986330300	, lng: -51.131100700, proxpnt : [] };
  pnts[28] = {label: '28',id: 28, lat: -29.984620500	, lng: -51.131143600, proxpnt : [] };
  pnts[29] = {label: '29',id: 29, lat:-29.983579600	, lng: -51.131293800, proxpnt : [] };
  pnts[30] = {label: '30',id: 30, lat:-29.982222900	, lng: -51.131379600, proxpnt : [] };
  pnts[31] = {label: '31',id: 31, lat: -29.981144900	, lng: -51.131401100, proxpnt : [] };
  pnts[32] = {label: '32',id: 32, lat: -29.981182000		, lng: -51.130757300, proxpnt : [] };
  pnts[33] = {label: '33',id: 33, lat: -29.982241400	, lng: -51.130607100, proxpnt : []};
  pnts[34] = {label: '34',id: 34, lat: -29.983486700		, lng: -51.130521300, proxpnt : [] };
  pnts[35] = {label: '35',id: 35, lat: 	-29.984527500	, lng: -51.130456900, proxpnt : [] };
  pnts[36] = {label: '36',id: 36, lat: -29.987947300		, lng: -51.130199400, proxpnt : [] };
  pnts[37] = {label: '37',id: 37, lat: -29.987928700	, lng: -51.129362600, proxpnt : [] };
  pnts[38] = {label: '38',id: 38, lat: -29.986181600	, lng:-51.129512800, proxpnt : [] };
  pnts[39] = {label: '39',id: 39, lat: -29.984490400	, lng: -51.129663000, proxpnt : [] };
  pnts[40] = {label: '40',id: 40, lat: -29.981107700	, lng: -51.129941900, proxpnt : [] };
  pnts[41] = {label: '41',id: 41, lat: -29.981051900	, lng: -51.129190900, proxpnt : [] };
  pnts[42] = {label: '42',id: 42, lat: -29.984508900	, lng: -51.128890500, proxpnt : [] };
  pnts[43] = {label: '43',id: 43, lat: -29.987835700	, lng:-51.128611600, proxpnt : [] };
  //fim criação dos pontos

  //colocação dos vizinhos
  addpnt(pnts[0],pnts[1]);
  addpnt(pnts[0],pnts[9]);
  addpnt(pnts[1], pnts[2]);
  addpnt(pnts[1], pnts[8]);
  addpnt(pnts[2], pnts[3]);
  addpnt(pnts[2], pnts[7]);
  addpnt(pnts[3], pnts[4]);
  addpnt(pnts[3], pnts[6]);
  addpnt(pnts[4], pnts[5]);
  addpnt(pnts[5], pnts[6]);
  addpnt(pnts[5], pnts[14]);
  addpnt(pnts[6], pnts[7]);
  addpnt(pnts[6], pnts[13]);
  addpnt(pnts[7], pnts[8]);
  addpnt(pnts[7], pnts[12]);
  addpnt(pnts[8], pnts[9]);
  addpnt(pnts[8], pnts[11]);
  addpnt(pnts[9], pnts[10]);
  addpnt(pnts[10], pnts[11]);
  addpnt(pnts[10], pnts[18]);
  addpnt(pnts[11], pnts[12]);
  addpnt(pnts[12], pnts[13]);
  addpnt(pnts[12], pnts[17]);
  addpnt(pnts[13], pnts[14]);
  addpnt(pnts[13], pnts[16]);
  addpnt(pnts[14], pnts[15]);
  addpnt(pnts[15], pnts[16]);
  addpnt(pnts[15], pnts[25]);
  addpnt(pnts[16], pnts[17]);
  addpnt(pnts[16], pnts[24]);
  addpnt(pnts[17], pnts[23]);
  addpnt(pnts[18], pnts[19]);
  addpnt(pnts[19], pnts[20]);
  addpnt(pnts[19], pnts[31]);
  addpnt(pnts[20], pnts[21]);
  addpnt(pnts[20], pnts[30]);
  addpnt(pnts[21], pnts[22]);
  addpnt(pnts[22], pnts[23]);
  addpnt(pnts[22], pnts[29]);
  addpnt(pnts[23], pnts[24]);
  addpnt(pnts[23], pnts[28]);
  addpnt(pnts[24], pnts[25]);
  addpnt(pnts[24], pnts[27]);
  addpnt(pnts[25], pnts[26]);
  addpnt(pnts[26], pnts[27]);
  addpnt(pnts[26], pnts[36]);
  addpnt(pnts[27], pnts[28]);
  addpnt(pnts[28], pnts[35]);
  addpnt(pnts[28], pnts[29]);
  addpnt(pnts[29], pnts[34]);
  addpnt(pnts[30], pnts[31]);
  addpnt(pnts[30], pnts[33]);
  addpnt(pnts[31], pnts[32]);
  addpnt(pnts[32], pnts[33]);
  addpnt(pnts[32], pnts[40]);
  addpnt(pnts[33], pnts[34]);
  addpnt(pnts[34], pnts[35]);
  addpnt(pnts[35], pnts[39]);
  addpnt(pnts[36], pnts[37]);
  addpnt(pnts[37], pnts[43]);
  addpnt(pnts[37], pnts[38]);
  addpnt(pnts[38], pnts[39]);
  addpnt(pnts[39], pnts[42]);
  addpnt(pnts[39], pnts[40]);
  addpnt(pnts[40], pnts[41]);
  addpnt(pnts[41], pnts[42]);
  addpnt(pnts[42], pnts[43]);
  //fim vizinhos
  //cria mapa
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 16,
    center: pnts[28],
  });
  //fim cria mapa
  //Desenha trajeto no mapa
  var Ruas = [];
  for(var c = 0; c < pnts.length; c++){
    for(var d = 0; d < pnts[c].proxpnt.length; d++){
      Ruas.push({lat: pnts[c].lat, lng: pnts[c].lng});
      Ruas.push({lat: pnts[c].proxpnt[d].lat, lng: pnts[c].proxpnt[d].lng});
    }
    var DesenharRota = new google.maps.Polyline({
      path: Ruas,
      geodesic: true,
      strokeColor: 'grey',
      strokeOpacity: 0.3,
      strokeWeight: 7
    });
    DesenharRota.setMap(map);
    var Ruas = [];
  }
  //fim Desenharua code

  //inserir marcadores no mapa
  var iconBase = 'resources/img/point_black.ico';
  var iconS = 'resources/img/point_red.ico';
  var iconE = 'resources/img/point_green.ico';
  var iconO = 'resources/img/point_no.ico';
  var p1 = document.getElementById('formGroupExampleInput').value; //origem
  var p2 = document.getElementById('formGroupExampleInput2').value; // destino
  var p3 = document.getElementById('formGroupExampleInput3').value; // obstruido
 var alerta = function(message){$.iGrowl({
      animation:	true,
      type: 'error',
      title: 'Tente novamente',
      message: message,
      icon: 'vicons-cancel',
      animShow: 'fadeInDown',
      animHide: 'bounceOut',
      small: true,
  })};
  //condiçoes de valores
  if(p1.length == 0 || p2.length == 0){
	alerta('Deve existir ao menos o ponto incial e final.');
	initBodyMap();
  }
  else if(p1 < 0 || p1 > 43 || p2 < 0 || p2 > 43 || p3 < 0 || p3 > 43){ //valores fora dos pontos
    initBodyMap();
	alerta('Entradas inválidas. Insira outro valor.');
  } else if(p1 == p2){ //ponto igual
    alerta('Você já está neste Ponto, escolha outro.');
    initBodyMap();
  } else if(p1 == p3 || p2 == p3){
    alerta('Não há como remover esse ponto, escolha outro.');
    initBodyMap();
  }else {
    if(p3.length != 0) {
      caminhodanificado(p3);
    }
    //função danificado para remover pontos e seus vizinhos
    function caminhodanificado(npnt){
      for(var i = 0; i < pnts[npnt].proxpnt.length; i++){
        rmvpnt(pnts[npnt].proxpnt[i],pnts[npnt]);
      }
      for(i; i>=0; i--){
        pnts[npnt].pop;
      }
    }
    // //fim obstaculo
    var markers = new Array();
    //event click
    function attClick(vet,pos){
      //console.log("vet: " + vet[pos]+ "  pos: " +pos);
      vet[pos].addListener('click', function() {
        p3 = pos;
        $("#formGroupExampleInput3").attr("value", ""+p3+"");
      });
    }
    //fim evenct click

    //inserção de markers e condições
    for (var i = 0; i < pnts.length; i++) {
      if(i == 0){
        if(p1 == 0){
          markers[i] = new google.maps.Marker({
            position: pnts[i],
            map: map,
            icon: iconS,
            label: {
              fontSize: "1em",
              fontWeight: "bold",
              text: pnts[i].label,
              color: 'white',
            },
            title: 'Ponto Partida: ' + pnts[i].id
          });
        } else if(p2 == 0){
          markers[i] = new google.maps.Marker({
            position: pnts[i],
            map: map,
            icon: iconE,
            label: {
              fontSize: "1em",
              fontWeight: "bold",
              text: pnts[i].label,
              color: 'white',
            },
            labelClass: "label",
            title: 'Ponto Destino: ' + pnts[i].id
          });
        }
        else {
          markers[i] = new google.maps.Marker({
            position: pnts[i],
            map: map,
            icon: iconBase,
            label: {
              fontSize: "1em",
              fontWeight: "bold",
              text: pnts[i].label,
              color: 'white',
            },
            title: 'Ponto 0'
          });
        }
      }
      else if(i == p1) {
        markers[i] = new google.maps.Marker({
          position: pnts[i],
          map: map,
          icon: iconS,
          label: {
            fontSize: "1em",
            fontWeight: "bold",
            text: pnts[i].label,
            color: 'white',
          },
          title: 'Ponto Partida: ' + pnts[i].id
        });
      } else if(i == p2){
        markers[i] = new google.maps.Marker({
          position: pnts[i],
          map: map,
          icon: iconE,
          label: {
            fontSize: "1em",
            fontWeight: "bold",
            text: pnts[i].label,
            color: 'white',
          },
          title: 'Ponto Destino: ' + pnts[i].id
        });
      } else if(i == p3){
        markers[i] = new google.maps.Marker({
          position: pnts[i],
          map: map,
          icon: iconO,
          animation:  google.maps.Animation.DROP,
          title: 'Ponto interditado.'
        });
      } else {
        markers[i] = new google.maps.Marker({
          position: pnts[i],
          map: map,
          icon: iconBase,
          label: {
            fontSize: "1em",
            fontWeight: "bold",
            text: pnts[i].label,
            color: 'white',
          },
          title: 'Ponto '+ pnts[i].id
        });
      }
      attClick(markers, i);
    }
    //fim marcadores

    //MelhorTrajeto code
    var MelhorRota = []; //vetor onde será adicionada a MelhorRota encontrada pela funcção
    function rmvpnt(pntf1, pntf2) {
      for(var i = 0; i < pntf1.proxpnt.length; i++){
        if(pntf1.proxpnt[i].lat == pntf2.lat && pntf1.proxpnt[i].lng == pntf2.lng )
        {
          pntf1.proxpnt.splice(i,1);
        }
      }
    }
    var MelhorTrajeto = function(pnt1, pnt2,MelhorRota){
      for(var i =0; i < pnts.length;i++){
        rmvpnt(pnts[i],pnt1);
      }
      if(DistTraj(pnt1,pnt2) == 0){ //verifica se a distância do ponto até o ponto destino, em linha reta, é igual a zero
        //console.log('Distancia do ponto ' + pnt1.id+' até o destino:'+DistTraj(pnt1,pnt2));
        return 0; //se for, então é porque estamos no ponto final
      }
      //console.log('Distancia do ponto ' + pnt1.id + ' até o destino:' +DistTraj(pnt1,pnt2));
      var aux = 1000000;
      var pntaux;
      for(var i = 0; i < pnt1.proxpnt.length;i++){
        if( aux > DistTraj(pnt1.proxpnt[i],pnt2)){
          aux = DistTraj(pnt1.proxpnt[i],pnt2); //aux recebe o menor valor
          pntaux = i;
        }
      }
      if(pnt1.proxpnt.length == 0)
      return 1;
      MelhorRota.push({id: pnt1.id, lat: pnt1.lat, lng: pnt1.lng});
      MelhorRota.push({id: pnt1.proxpnt[pntaux].id, lat: pnt1.proxpnt[pntaux].lat, lng: pnt1.proxpnt[pntaux].lng});


      if(MelhorTrajeto(pnt1.proxpnt[pntaux], pnt2,MelhorRota) == 1){
        MelhorRota.pop();
        MelhorRota.pop();
        return MelhorTrajeto(pnt1,pnt2,MelhorRota);
      }
      return 0;
    }

    //função que calcula a distâcia entre os dois pontos
    var DistTraj = function(pnt1, pnt2) {
      var deg2rad = 0.017453292519943295; // === Math.PI / 180
      var cos = Math.cos;
      lat1 = pnt1.lat;
      lon1 = pnt1.lng;
      lat2 = pnt2.lat;
      lon2 = pnt2.lng;
      lat1 *= deg2rad;
      lon1 *= deg2rad;
      lat2 *= deg2rad;
      lon2 *= deg2rad;
      var diam = 12742; // Diameter of the earth in km (2 * 6371)
      var dLat = lat2 - lat1;
      var dLon = lon2 - lon1;
      var a = ( (1 - cos(dLat)) +
      (1 - cos(dLon)) * cos(lat1) * cos(lat2)
    ) / 2;
    return diam * Math.asin(Math.sqrt(a)) * 1000;
  };

  MelhorTrajeto(pnts[p1],pnts[p2],MelhorRota);
  console.log('Initiating Greedy Depth-First Search Pathfinding...');
  //deleta valores duplicados no array para função abaixo
  function squash(arr){
    var tmp = [];
    for(var i = 0; i < arr.length; i++){
      if(tmp.indexOf(arr[i].id) == -1){
        tmp.push(arr[i].id);
      }
    }
    return tmp;
  }
  //adicionar rota em uma lista que será mostrada no HTML
  function reapareceDiv() {
    document.getElementById("lista").style.visibility = "visible";
  }
  var MelhorRota2 = squash(MelhorRota);
  var subs = [];
  for(var i = 0; i < MelhorRota2.length; i++){
    if(i == (MelhorRota2.length-1)){
      subs[i] = "<li> Você chegou ao destino. </li>";
    } else {
      subs[i] = "<li> Saia do ponto " + MelhorRota2[i] +" e vá até o " + MelhorRota2[i+1] + ".</li>";
    }
  }
  document.getElementById("cam").innerHTML = subs.join('');
  reapareceDiv();
  //fim adicionar rota no HTML
  //fim Melhor trajeto code

  //DesenhaRota no mapa code
  var DesenharRota = new google.maps.Polyline({
    path: MelhorRota,
    geodesic: true,
    strokeColor: '#0095b6 ',
    strokeOpacity: 1,
    strokeWeight: 10
  });
  DesenharRota.setMap(map);
  //fim DesenhaRota code
}
console.log('Finished Greedy Depth-First Search Pathfinding successfully.');
}//fim mapa calculo
