package com.jamdan2.robohub.components.forms

import kotlinx.html.ButtonType
import kotlinx.html.InputType
import react.*
import react.dom.*

class LoginForm : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("LoginForm form") {
            button(classes = "close-button") { +"X" }
            div("form-container") {
                form {
                    div("form-content") {
                        h1 { +"Login" }
                    }
                    div("form-content") {
                        label { +"Username" }
                        input(type = InputType.text, name = "username") {}
                    }
                    div("form-content") {
                        label { +"Password" }
                        input(type = InputType.password, name = "password") {}
                    }
                    div("form-content") {
                        button(classes = "b-purple", type = ButtonType.submit) { +"Submit" }
                    }
                }
            }
        }
    }
}

fun RBuilder.loginForm() = child(LoginForm::class) {}