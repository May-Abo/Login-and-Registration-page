/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function getMessage(message){
    
var result ='';  
document.getElementById('mymsg').innerHTML='';
result+='<div class="alert alert-danger">'
result+='<button type="button" class="close" data-dismiss="alert">X</button>'
result+='<strong>Error!</strong> '+message+'</div>'  
document.getElementById('mymsg').innerHTML=result;}

