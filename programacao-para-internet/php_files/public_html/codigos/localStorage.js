var teste = {"data": "22-08-2016"}
undefined
teste
Object {data: "22-08-2016"}
teste.stringify
undefined
window.localStorage.setItem(JSON.stringify(teste))
VM760:1 Uncaught TypeError: Failed to execute 'setItem' on 'Storage': 2 arguments required, but only 1 present.(…)(anonymous function) @ VM760:1
window.localStorage.setItem('teste',JSON.stringify(teste))
undefined
window.localStorage.getItem('teste')
"{"data":"22-08-2016"}"
var recuperado = window.localStorage.getItem('teste')
undefined
JSON.parse(recuperado)
Object {data: "22-08-2016"}
JSON.parse(recuperado)['data']
"22-08-2016"