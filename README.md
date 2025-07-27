# Task CLI

A simple command-line application to manage your tasks using Java and JSON.

## Features
- Add, update, delete tasks
- Mark tasks as done, in-progress
- Filter tasks by status
- Persist tasks in a JSON file

## Usage
```
java -jar task-cli.jar add "Buy groceries"
java -jar task-cli.jar update 1 "Cook dinner"
java -jar task-cli.jar mark-done 1
java -jar task-cli.jar list
java -jar task-cli.jar list done
```
