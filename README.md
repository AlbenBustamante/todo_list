# To-Do List
It's a RESTful API for a list of tasks.

### How does it work?
It's pretty simple.

The first thing will be to create a category (not very specific).

Then, create the task list with the name you want and assign it the category you just created.

Then, create a task with a brief description of what you want to do and assign it the list you want it to belong to.

The status is false by default.

And with that you are done. When you finish your task you can update it so that the status is true.

Also, you can create more specific tags and assign them to the tasks you want.

In this way, you can review your tasks according to the label you consult.

### How can I use the application?
You can access to the application here:

- https://alnicode-todo-list.herokuapp.com/api/swagger-ui/

Go to the auth-controller and use the /signin path.

![1](https://user-images.githubusercontent.com/81927187/169668511-f211aa8c-6032-433e-bbf5-b8e65f50e3ee.png)

Then, do click on 'Try out' button.

![2](https://user-images.githubusercontent.com/81927187/169668662-1ea10929-3a39-4bf3-969b-bc17ffc49db3.png)

Type a password and username to sign in and then click on 'Execute' button.

![3](https://user-images.githubusercontent.com/81927187/169668738-ae3b8325-d856-4509-be92-04ec34f81bf3.png)

You will have as a result your id, username and assigned role.

![4](https://user-images.githubusercontent.com/81927187/169668994-34c6a805-bd2e-4944-8ac5-915121518a21.png)

Now, go back to the auth-controller and use the method with the path ending in /login.

![5](https://user-images.githubusercontent.com/81927187/169669089-6bfcc7b1-9794-48d1-a96f-f787d7c639bf.png)

Use the data with which you registered and then click on 'Execute'.

![6](https://user-images.githubusercontent.com/81927187/169669231-9072d286-eb06-478c-90ad-f015830aefe2.png)

The server will return a 'jwt' response, copy the full code.

![7](https://user-images.githubusercontent.com/81927187/169669330-18855a70-b79c-4863-a2c3-71ad70a2ce9b.png)

Now, go up and click the 'Authorize' button.

![8](https://user-images.githubusercontent.com/81927187/169669406-2d6f8723-ef3b-4e81-ad86-549315f70eaa.png)

A window will open with a text field.
Type the word 'Bearer ' and then paste the generated code.
Click on 'Authorize'.

![9](https://user-images.githubusercontent.com/81927187/169669418-2ff0f4c6-be71-4447-b7c3-96a652c06644.png)

Now you are authenticated.
This token lasts only 5 minutes, so once It expires, It will be necessary to generate another one.

![10](https://user-images.githubusercontent.com/81927187/169669475-a3eb2696-434d-4363-bada-e735be6a8b60.png)

From here, you can now manage the API as you wish, for example:

Go to category-controller and register a new category.

![11](https://user-images.githubusercontent.com/81927187/169669633-93bd6f95-f6cb-48a1-8e81-ac47eb534a98.png)

Now, go to the todo-list-controller and register a new list with the category Id that you created or an existing one.

![12](https://user-images.githubusercontent.com/81927187/169669769-a3a936e1-882a-4d46-8bac-09740230f32e.png)

You can see the assigned category using the path ending in /category

![13](https://user-images.githubusercontent.com/81927187/169669770-9d039738-7fec-4a8e-b6ff-8f2160006c22.png)

Now you can register a new task with the to-do list Id.
The date must to be future.

![14](https://user-images.githubusercontent.com/81927187/169669771-095e6249-2fc9-4aad-938b-29f0187cb4fd.png)

Feel free to create the necessary labels, in my case I created these as an example.

![15](https://user-images.githubusercontent.com/81927187/169669772-c90ddd24-6843-4190-a430-4f7ec1b494ac.png)

Use the POST method terminated in /{tag Id} and use two parameters:
1. The Id of the task to which you are going to add the label.
2. The Id of the existing tag that you are going to add.

![16](https://user-images.githubusercontent.com/81927187/169669773-51207b5d-2717-4e8c-a55d-de99bd37d5e3.png)

Finally, this is what your to-do list will look like when you run queries.

![17](https://user-images.githubusercontent.com/81927187/169669774-8fe8cf01-1d9e-40d0-827a-3a6000de6324.png)


### How did I do it?

I developed it with Java 11, Spring Boot, Spring Data JPA, Spring Security and JWT.

Used libraries: Swagger, Mapstruct, Validation, Lombok.

Cloud: Heroku.

Database: PostgreSQL
