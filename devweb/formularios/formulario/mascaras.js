//inserir automaticamente os caracteres do telefone
function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}
function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}
function mtel(v){
    v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
    v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}
function id( el ){
  return document.getElementById(el);
}
window.onload = function(){
  id('telefone').onkeypress = function(){
    mascara( this, mtel );
  }
}

//valida data
function valida_data(obj)
{
    var data = obj.value;
    var dia = data.substring(0,2)
    var mes = data.substring(3,5)
    var ano = data.substring(6,10)
 
    
    var novaData = new Date(ano,(mes-1),dia);
 
    var mesmoDia = parseInt(dia,10) == parseInt(novaData.getDate());
    var mesmoMes = parseInt(mes,10) == parseInt(novaData.getMonth())+1;
    var mesmoAno = parseInt(ano) == parseInt(novaData.getFullYear());
 
    if (!((mesmoDia) && (mesmoMes) && (mesmoAno)))
    {
	  alert("Data inv�lida!");		
        obj.focus();    
        return false;
    }  
    return true;
}

//formatar data automaticamente
 function mascaraData(campoData){
              var data = campoData.value;
              if (data.length == 2){
                  data = data + '-';
                  document.forms[0].data.value = data;
      return true;              
              }
              if (data.length == 5){
                  data = data + '-';
                  document.forms[0].data.value = data;
                  return true;
              }
         }
