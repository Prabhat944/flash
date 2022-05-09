//Examine the document object
//console.dir(document);

//console.log(document.domain);
//console.log(document.url);
//console.log(document.title);
//document.title=123;
//console.log(document.doctype);
//console.log(document.head);
//console.log(document.body);
//console.log(document.all);
//console.log(document.all[10]);
//document.all[10].textContent= 'hello';
//console.log(document.forms[0]);
//console.log(document.links);
//console.log(document.links);
//console.log(document.images);


//GetElement by id
console.log(document.getElementById('header-title'));
var headerTitle=document.getElementById('header-title');
console.log(headerTitle);
headerTitle.textContent='hello';
headerTitle.innerContent='hello';
headerTitle.innerText='GoodBYE';




var header=document.querySelector('main-header');
header.getElementsByClassName.borderBottom='solid 4px #ccc';

var input=document.querySelector('input');
input.value='hello World';
var submit =document.querySelector('input[type="submit"]');
submit.value="send";

var item=document.querySelector('.list-group-item');
item.getElementsByClassName.color='red';


var item=document.querySelector('.title');
item.getElementsByClassName.color='green';




