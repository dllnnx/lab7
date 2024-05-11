package labs.commands

import labs.dto.Request
import labs.dto.Response
import labs.dto.ResponseStatus
import labs.utility.CommandManager

/**
 * Команда help. Выводит справку по доступным командам.
 * @author dllnnx
 */
class HelpCommand(private val commandManager: CommandManager) :
    Command("help", ": вывести справку по доступным командам.") {
    /**
     * Выполнить команду
     */
    override suspend fun execute(request: Request): Response {
        if (request.args.isNotEmpty()) {
            return Response(ResponseStatus.WRONG_ARGUMENTS, "Для этой команды не требуются аргументы!")
        }
        val str = commandManager.showUserCommands()
        return Response(ResponseStatus.OK, str)
    }
}
