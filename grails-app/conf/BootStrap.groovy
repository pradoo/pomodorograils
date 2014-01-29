import org.example.pomodoro.Tag
import org.example.pomodoro.Task

class BootStrap {

    def init = { servletContext ->
		//creates new Tag and shows error if it does not validate.
		def workTag = new Tag(name: "Work").save(failOnError:true)
		def homeTag = new Tag(name: "Home").save(failOnError:true)
		def schoolTag = new Tag(name: "School").save(failOnError:true)
		
		def task = new Task(
			summary: "Carrer Fair",
			details: "Frank Erwin Center CNS career fair",
			status: "Open")
		/*
		 * anytime that a domain class has a collection property of
		 * has many it gains addTo___ and removeFrom___ methods 
		 */
		task.addToTags(workTag)
		task.addToTags(schoolTag)
		task.save(failOnError: true)
		
		task = new Task(
			summary: "Pick up nephews",
			details: "La shaygerl",
			status: "Open")
		task.addToTags(homeTag)
		task.save(failOnError:true)
		
		task = new Task( 
			summary: "Shopping", 
			details: "Do the grocery shopping - and don't forget the tomatoes!", 
			status: "Open", 
			deadline: new Date() + 15) 
		task.addToTags(homeTag) 
		task.save(failOnError: true)
	}
    def destroy = {
    }
}
