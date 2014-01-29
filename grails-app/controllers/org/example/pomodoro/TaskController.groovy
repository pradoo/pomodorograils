package org.example.pomodoro
//suffix controllor is grails convention
class TaskController {
	static scaffold = Task
	//index invoked by default
	
	def index = {
		def tasks = Task.findAllByStatus("Open",[sort: "deadline", order:"asc"])
		def tags = Tag.list(sort:"name", order: "asc")
		
		return [tasks: tasks, tags: tags]
	}
}
