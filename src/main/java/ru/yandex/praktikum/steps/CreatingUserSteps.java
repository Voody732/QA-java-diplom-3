package ru.yandex.praktikum.steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.dto.CreateUserRequest;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.Statics.*;


public class CreatingUserSteps {
    @Step("Создаем пользователя")
    public ValidatableResponse createUser(String email, String password, String name) {
        CreateUserRequest user = new CreateUserRequest();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(user)
                .when()
                .post(CREATE_USER_HANDLER)
                .then();
    }

    @Step("Удаляем пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        RestAssured.defaultParser = Parser.JSON;
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete(DELETE_USER_HANDLER)
                .then();
    }

}
