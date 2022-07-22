import org.junit.Test

import org.junit.Assert.*
import ru.netology.*

class WallServiceTest {

    @Test
    fun add() {
        var post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Новая нетология Тест",
            date = 1590075360,
            likes = Likes(count = 22)
        )

        val service = WallService
        val added1 = service.add(post1)

        assertNotEquals(0,added1.id)
    }

    @Test
    fun updateExistId() {
        var post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Новая нетология Тест",
            date = 1590075360,
            likes = Likes(count = 22)
        )

        var postNew =  Post(
            id = 1,
            ownerId = 1,
            text = "Новая нетология ТестНовый",
            date = 1590075360,
            likes = Likes(count = 22)
        )
        val service = WallService
        val result = service.update(postNew)

        assertEquals(true, result)
    }

    @Test
    fun updateNotExistId() {
        var post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Новая нетология Тест",
            date = 1590075360,
            likes = Likes(count = 22)
        )

        var postNew =  Post(
            id = 33,
            ownerId = 1,
            text = "Новая нетология ТестНовый",
            date = 1590075360,
            likes = Likes(count = 22)
        )
        val service = WallService
        val result = service.update(postNew)

        assertEquals(false, result)
    }

    // Тесты для ДЗ №7 - Исключения
    // 1 - Функция отрабатывает правильно, если добавляется комментарий к правильному посту.
    @Test
    fun shouldNotThrow() {

        var post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Новая нетология Тест",
            date = 1590075360,
            likes = Likes(count = 22)
        )

        val service = WallService
        val added1 = service.add(post1)

        val comment = Comment(id = 1, text = "Комментарий для поста 1")
        val commentedPost = service.createComment(1,comment)

        assertNotEquals(null, commentedPost)

    }

    // 2 - Функция выкидывает исключение, если была попытка добавить комментарий к несуществующему посту.
    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {

        var post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Новая нетология Тест",
            date = 1590075360,
            likes = Likes(count = 22)
        )

        val service = WallService
        val added1 = service.add(post1)

        val comment = Comment(id = 1, text = "Комментарий для поста 1")
        val commentedPost2 = service.createComment(15,comment)
    }



}