# AlphaBankTest
Данный репозиторий содержит проект Spring boot с системой сборки Gradle. Реализован веб-сервис, который выдаёт случайное gif изображение из
https://giphy.com/search/rich, если курс по отношению к рублю стал выше, из https://giphy.com/search/broke, иначе.
# Инструкция по запуску
Необходимо скачать все файлы и сохранить в папке AlphaBankTest. После этого открываем проект с помощью IDE (рекомендую IntelliJ IDEA). После открытия IDE переходим в
файл  src/main/java/com.example.AlphaBankTest/AlphaBankTestApplication. Запускаем его.
После запуска открываем браузер и вбиваем ссылку http://localhost:9000/test/{currency}, где currency - код валюты. Таким образом, если валюта по отношению
к рублю стала выше, то выдаётся случайная gif-ка из https://giphy.com/search/rich, иначе из https://giphy.com/search/broke.
