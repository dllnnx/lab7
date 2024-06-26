package labs.commands

import labs.database.DatabaseConnector
import labs.dto.Request
import labs.dto.Response
import labs.dto.ResponseStatus
import org.apache.logging.log4j.kotlin.logger

class Login : Command("login", ": войти в аккаунт") {
    private val logger = logger()

    override suspend fun execute(request: Request): Response {
        logger.info("Вход в аккаунт пользователя с логином ${request.user.login}.")
        if (DatabaseConnector.usersDatabase.checkAuthUser(request.user)) {
            logger.info("Успешная авторизация пользователя с логином ${request.user.login}.")
            return Response(ResponseStatus.OK, "Авторизация прошла успешно!")
        }
        logger.error("Авторизация неуспешна: пользователя с таким логином и паролем не существует.")
        return Response(ResponseStatus.ERROR, "Пользователя с таким логином и паролем не существует!")
    }
}
