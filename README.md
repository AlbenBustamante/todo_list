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
You can access the application here:

- https://alnicode-todo-list.herokuapp.com/api/swagger-ui/
- `username: my_admin`
- `password: adminroot123`

### How did I do it?
I developed it from the Spring Boot Frameworks, Spring Data and Spring Security (basic security).

Also, I used some libraries like Validation for data validation, Mapstruct to map entities to data transfer objects, and Lombok.

The graphic environment is thanks to Swagger.
