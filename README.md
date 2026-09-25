# Espresso Android UI tests

UI-тесты учебного Android-приложения на Espresso.

**Stack:** `Java` · `Espresso` · `Espresso Intents` · `Espresso Contrib` · `JUnit 4` · `AndroidX Test` · `IdlingResource`

## Что проверяется

| Тест | Что проверяет |
|------|---------------|
| `MainScreenTest` | на главном экране отображается текст «This is home fragment» |
| `IdlingResourceTest` | переход в Gallery через боковое меню, наличие элемента «7», что список является `RecyclerView` и содержит 10 элементов |
| `IntentTest` | пункт меню Settings отправляет Intent `ACTION_VIEW` с адресом `https://google.com` |

## Особенности

- `CustomViewMatcher` — собственный Matcher, проверяющий количество элементов в `RecyclerView`;
- `CustomViewAssertions` — собственная проверка, что элемент является `RecyclerView`;
- `EspressoIdlingResources` — IdlingResource в коде приложения, благодаря которому тесты ждут загрузку списка без фиксированных пауз.

## Запуск

Нужен Android Studio и запущенный эмулятор или подключённое устройство.

```
./gradlew connectedAndroidTest
```

Или в Android Studio: правой кнопкой по папке `app/src/androidTest` → **Run 'Tests in ...'**.
