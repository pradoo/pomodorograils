package org.example.pomodoro

class Tag {
	String name
	//can associate with multiple tasks
	//tasks is a collection
	static hasMany = [tasks: Task]
	//task is the owner
	static belongsTo = Task
    static constraints = {
		name blank: false, unique: true
    }
	
	String toString(){
		return name
	}
}
