console.log("JavaScript Loaded");


// Spring Boot port 1234

const API =
"http://localhost:1234/api/v1/products";




// ADD PRODUCT


document
.getElementById("productForm")
.addEventListener("submit", function(event){


    event.preventDefault();


    console.log("Button Clicked");



    let product = {


        name:
        document.getElementById("name").value,


        description:
        document.getElementById("description").value,


        price:
        document.getElementById("price").value,


        category:
        document.getElementById("category").value


    };



    fetch(API,{


        method:"POST",


        headers:{

            "Content-Type":"application/json"

        },


        body:JSON.stringify(product)


    })



    .then(response=>{


        if(!response.ok){

            throw new Error("Product not added");

        }


        return response.json();


    })


    .then(data=>{


        console.log(data);


        document.getElementById("message")
        .innerHTML =
        "Product Added Successfully";


        document
        .getElementById("productForm")
        .reset();



        getProducts();


    })


    .catch(error=>{


        console.log(error);


        document.getElementById("message")
        .innerHTML =
        "Error : "+error;


    });



});







// GET ALL PRODUCTS


function getProducts(){


fetch(API)


.then(response=>response.json())


.then(data=>{


let table =
document.getElementById("productTable");


table.innerHTML="";



data.forEach(product=>{


table.innerHTML +=

`

<tr>

<td>${product.id}</td>

<td>${product.name}</td>

<td>${product.description}</td>

<td>${product.price}</td>

<td>${product.category}</td>


</tr>

`;



});


});


}