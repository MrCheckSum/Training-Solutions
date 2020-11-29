package intromethods.ToDo;

import intromethods.todo.TodoList;

import java.util.Arrays;

public class TodoListMain {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.addTodo("Bevásárlás");
        todoList.addTodo("Kertészkedés");
        todoList.addTodo("Főzés");


        System.out.println(todoList);

        todoList.finishTodos("Bevásárlás");

        System.out.println(todoList);

        todoList.finishAllTodos(Arrays.asList("Bevásárlás", "Főzés"));

        System.out.println(todoList.todosToFinish());
        System.out.println(todoList.numberOfFinishedTodos());

    }
    
}
