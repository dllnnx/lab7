package labs.commands

import labs.dto.Request
import labs.dto.Response
import labs.dto.ResponseStatus
import labs.objects.Person
import labs.utility.CollectionManager
import java.util.LinkedList

/**
 * Команда show. Выводит в стандартный поток вывода все элементы коллекции в строковом представлении.
 * @author dllnnx
 */
class ShowCommand(private val collectionManager: CollectionManager) :
    Command("show", ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении.") {
    /**
     * Выполнить команду
     */
    override fun execute(request: Request) : Response {
        if (request.args.isEmpty()) {
            val collection = collectionManager.collection
            if (collection.isEmpty()) {
                return Response(ResponseStatus.WARNING, "Коллекция пуста!")
            }
            return Response(ResponseStatus.OK, "Элементы коллекции: ", collection)
        } else return Response(ResponseStatus.WRONG_ARGUMENTS,"Для этой команды не требуются аргументы!")
    }
}
