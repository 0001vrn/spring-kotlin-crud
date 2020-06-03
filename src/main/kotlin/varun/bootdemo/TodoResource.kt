package varun.bootdemo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.lang.Exception
import java.sql.Timestamp
import java.time.Instant
import java.util.UUID
import javax.persistence.*

interface TodoRepository : JpaRepository<Todo, Long>

@RestController @RequestMapping(value = ["/todo"]) @EnableWebMvc
class TodoResource(val todoRepository: TodoRepository) {

    @GetMapping(value = ["/"])
    fun getAll() = todoRepository.findAll()

    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable id: Long) = todoRepository.findById(id)

    @PostMapping(value = ["/"])
    fun new(@RequestBody text: String) = todoRepository.save(Todo(text = text))

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Long) = todoRepository.deleteById(id)

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody todo: Todo): Todo {
        val toUpdate: Todo = todoRepository.findById(id).orElseThrow{ Exception("server error") }
        toUpdate.text = todo.text
        toUpdate.done = todo.done
        toUpdate.updatedAt = Timestamp.from(Instant.now())
        return todoRepository.save(toUpdate)
    }
}


@Entity
class Todo(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val uuid: UUID = UUID.randomUUID(),
    var text: String = "",
    var done: Boolean = false,
    var createdAt: Timestamp = Timestamp.from(Instant.now()),
    var updatedAt: Timestamp = Timestamp.from(Instant.now())
)
