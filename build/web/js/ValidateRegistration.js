/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function validateUserRegistration(){
    


    var fname = document.getElementById('fname').value;  
    var lname = document.getElementById('lname').value; 
    var username = document.getElementById('username').value; 
    var email = document.getElementById('email').value; 
    var password = document.getElementById('password').value; 
    var repassword = document.getElementById('repassword').value; 
    var country = document.getElementById('country').value; 

       
    
    if(fname==null || fname=='null' || fname==''){
            
        alert('Please enter your First Name ');
    }
     
    else if(lname==null || lname =='null' || lname=='')
    {
        alert('Please enter your Last Name ');
    
    }
    else if(username==null || username =='null' || username=='')
    {
        alert('Please enter your User Name ');
       
    }
 
    else  if(email==null || email =='null' || email=='')
    {
        alert('Please enter your Email ');
       
    }
    
    else  if(country=='--Select--')
    {
        alert('Please enter your Country ');
       
    }
 
    else if(password==null || password =='null' || password=='')
    {
        alert('Please enter password ');

    }
 
    else if(repassword==null || repassword =='null' || repassword=='')
    {
        alert('Please repeat the password ');
    
    }
     
    else   if(repassword!=password)
    {
        alert('Passwords dont match  ');
    
    }
    
    else {
        document.forms["regforms"].submit();
    }
   
}

function countrySelection(){
 
    var country = document.getElementById('country').value;  
    
    if(country=='Jordan' || country=='Egypt'|| country=='USA'){
        document.getElementById('phoneNumber').style.visibility = 'visible';
        document.getElementById('phoneNumber').disabled=false;   
    }
     
    else if(country=='KSA')
    {
        document.getElementById('phoneNumber').style.visibility = 'visible';
        document.getElementById('phoneNumber').disabled=true; 
    }
    else if(country=='UAE')
    {
        document.getElementById('phoneNumber').style.visibility = 'hidden';
        document.getElementById('phoneNumber').disabled=true; 
    }
    
    else {
        document.forms["countrySelect"].submit();
    }
}