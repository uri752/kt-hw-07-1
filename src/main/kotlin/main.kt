package ru.netology

fun main() {

    val post1 =  Post(
        id = 0,
        ownerId = 1,
        text = "Новая нетология 1",
        date = 1590075360,
        likes = Likes(count = 22),
        attachment = arrayOf(
            PhotoAttachment(),
            VideoAttachment(),
            WikiAttachment()
        )
    )

    val post2 =  Post(
        id = 0,
        ownerId = 1,
        text = "Новая нетология 1",
        date = 1590075360,
        likes = Likes(count = 22)
    )

    post1.attachment.forEach { println(it) }

    val service = WallService

    // функция добавления поста
    val added1 = service.add(post1)
    val added2 = service.add(post2)
    service.addAtachment(added2.id, PhotoAttachment())

    val postWithAttachment = service.findPostById(added2.id)
    println("postWithAttachment: $postWithAttachment")

    println("added1: $added1")

    // функция обновления поста
    var post3 =  Post(
        id = 2,
        ownerId = 1,
        text = "Новая нетология 3",
        date = 1590075360,
        likes = Likes(count = 22)
    )

    val res = service.update(post3)
    println("Пост обновлен: $res")

    // для ДЗ №7 Исключения
    val comment = Comment(id = 1, text = "Комментарий для поста 1")
    // если пост с id найден, то возвращается комментарий
    val commentedPost1 = service.createComment(1,comment)
    println(commentedPost1)

    // если пост с id не найден, то выбрасывается исключение
    val commentedPost2 = service.createComment(15,comment)
}
