// const http = require('http');
// const { readFileSync } = require('fs');

// const homePage = readFileSync('./navbar-app/index.html')
// const homeStyles = readFileSync('./navbar-app/styles.css')
// const homeImage = readFileSync('./navbar-app/logo.svg')
// const homeLogic = readFileSync('./navbar-app/browser-app.js')

// const server = http.createServer((req, res) => {
//     console.log(req.method);
//     console.log(req.url);

//     if (req.url === '/') {
//         res.writeHead(200, { 'Content-Type': 'text/html' });
//         res.write(homePage);
//         res.end();
//     } else if (req.url === '/about') {
//         res.writeHead(200, { 'Content-Type': 'text/html' });
//         res.write('<h1>About Page</h1>');
//         res.end();
//     } else if (req.url === '/styles.css') {
//         res.writeHead(200, { 'Content-Type': 'text/css' });
//         res.write(homeStyles);
//         res.end();
//     } else if (req.url === '/logo.svg') {
//         res.writeHead(200, { 'Content-Type': 'image/svg+xml' });
//         res.write(homeImage);
//         res.end();
//     } else if (req.url === '/browser-app.js') {
//         res.writeHead(200, { 'Content-Type': 'text/javascript' });
//         res.write(homeLogic);
//         res.end();
//     }  else {
//         res.writeHead(404, { 'Content-Type': 'text/html' });
//         res.write('<h1>Page Not Found</h1>');
//         res.end();
//     }
// });

// server.listen(5000, () => {
//     console.log('Server is listening on port 5000');
// });


// const express = require('express');
// const path =require('path');
// const app= express();
//  app.use(express.static('./public'))
// app.get('/',(req,res)=>{

//     res.sendFile(path.resolve(__dirname,'./navbar-app/index.html'))
// })
// app.get('/about',(req,res)=>{
//     res.status(200).send('About Page')
// })
// app.get('*',(req,res)=>{
//     res.status(200).send('<h1>Resource not found</h1>')
// })

// app.listen(5000,()=>{
//     console.log('server is listening on port 5000')
// })




// const express = require('express');
// const app= express();

// const {products}= require('./data');
// app.get('/',(req,res)=>{

//     res.send('<h1> Home Page </h1><a href="/api/products">products</a>')
// })
// app.get('/api/products',(req,res)=>{

//     const newProducts =products.map((product)=>
//     {
//         const {id,name,image}=product
//         return {id,name,image}
//     })
//     res.json(newProducts)
// })
// app.get('/api/products/:productID',(req,res)=>{

//     const {productID}=req.params;
//     const singleProduct =products.find((product)=>
//     product.id===Number(productID))
//     if(!singleProduct)
//         {
//             return res.status(404).send("Product not found");
//         }
//     res.json(singleProduct)
    
// })

// app.get('/api/v1/query',(req,res)=>{

//     const {search,limit}=req.query;
//    let sortedProducts =[...products]
//     console.log(sortedProducts);
//     if(search)
//         {
//            sortedProducts=sortedProducts.filter((product)=>{
//             return product.name.startsWith(search)
//            })
//         }
//     if(limit)
//         {
//             sortedProducts=sortedProducts.slice(0,Number(limit))
            
//         }
//         if(sortedProducts.length<1)
//         {
//             res.status(200).json({success: true,data:[]})
//         }
//     res.status(200).json(sortedProducts)
   
    
// })

// app.listen(5000,()=>{
//     console.log('Server is listening to port 5000....');
// })


// const express=require('express')
// const app= express()
// const morgan = require('morgan')
// const logger=require('./logger');
// const authorized=require('./authorized');
// //app.use([logger,authorized]);
// app.use(morgan('tiny'))
// app.get('/',(req,res)=>
// {
   
//     res.send('Home')
// })

// app.get('/About',(req,res)=>
//     {
//         res.send('About')
//     })

//     app.get('/api/items',[logger,authorized],(req,res)=>
//         {
//             res.send('About')
//         })
    
    
//     app.listen(500,() =>{
//         console.log('Server is listening to port 500....')
//     })

const express=require('express')
const app=express()
const people=require('./routes/people')
const auth=require('./routes/auth')
const morgan = require('morgan')
// let {people} =require('./data');

app.use(express.static('./methods-public'))
app.use(express.urlencoded({extended:false}))
app.use(express.json());
app.use('/api/people',people)
app.use('/login',auth)









app.listen(500,()=>
{

    console.log('Server is listening on port 5000...')
})
