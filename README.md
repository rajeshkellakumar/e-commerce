# e-commerce
Sample e-commerce backend application(Java, Spring Boot, MYSQL)

###### User APIs:
1. Create User:
    ```
    url: http://localhost:8080/users
    request: post
    body: {
          	"userName": "user_04",
          	"emailId": "user_04@email.com"
          }
    ```
2. Delete User by Id:
   ``` 
    url: http://localhost:8080/users/{id}
    request: delete
    ```   
3. Get User by Id:
    ```
    url: http://localhost:8080/users/{id}
    request: get
    ```
4. Get User by emailId:
    ```
    url: http://localhost:8080/users/{emailId}
    request: get
    ```
5. Get All users:
    ```
    url: http://localhost:8080/users
    request: get
    ```
    
###### Item APIs:
1. Create Item:
    ```
    url: http://localhost:8080/items
    request: post
    body: {
              "itemName": "Shoe",
              "itemDesc": "sparx shoe",
              "itemPrice": 750,
              "availableQty": 60
          }
    ```
2. Update Item:
    ```
    url: http://localhost:8080/items/{id}
    request: put
    body: {
              "id": 7,
              "itemName": "Shoe",
              "itemDesc": "sparx shoe",
              "itemPrice": 750,
              "availableQty": 60
          }
    ```          
3. Delete Item:
    ```
    url: http://localhost:8080/items/{id}
    request: delete
    ```
4. Get Item by Id:
    ```
    url: http://localhost:8080/items/{id}
    request: get
    ```
5. Get All Items:
    ```
    url: http://localhost:8080/items
    request: get
    ```

###### Order APIs:
1. Create Order:
    ```
    url: http://localhost:8080/orders
    request: post
    body:  {
          	"itemId": 7,
          	"noOfItems": 20,
          	"emailId": "user_04@email.com"
          }
    ```            
2. Get Order by Id:
    ```
    url: http://localhost:8080/orders/{id}
    request: get
    ```
3. Get All Orders:
    ```
    url: http://localhost:8080/orders
    request: get
    ```
