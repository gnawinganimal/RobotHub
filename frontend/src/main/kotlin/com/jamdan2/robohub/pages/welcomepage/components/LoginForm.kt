package com.jamdan2.robohub.pages.welcomepage.components

import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest
import react.*
import react.dom.*
import kotlin.browser.window
import kotlin.js.json

data class Credentials(val username: String, val password: String)

class LoginForm : RComponent<LoginFormProps, LoginFormState>() {
    override fun RBuilder.render() {
        div("LoginForm form") {
            button(classes = "close-button") {
                attrs.onClickFunction = props.onClose
                +"X"
            }
            div("form-container") {
                form {
                    attrs.onSubmitFunction = {
                        it.preventDefault()
                        XMLHttpRequest().apply {
                            open("POST", "${window.location.href}/login")
                            setRequestHeader("Content-Type", "application/json")
                            send(JSON.stringify(json(
                                    "username" to state.username,
                                    "password" to state.password
                            )))
                        }
                    }
                    div("form-content") {
                        h1 { +"Login" }
                    }
                    div("form-content") {
                        label { +"Username" }
                        input(type = InputType.text, name = "username") {
                            attrs.onChangeFunction = {
                                val target = it.target as HTMLInputElement
                                setState { username = target.value }
                            }
                        }
                    }
                    div("form-content") {
                        label { +"Password" }
                        input(type = InputType.password, name = "password") {
                            attrs.onChangeFunction = {
                                val target = it.target as HTMLInputElement
                                setState { password = target.value }
                            }
                        }
                    }
                    div("form-content") {
                        button(classes = "b-purple", type = ButtonType.submit) { +"Submit" }
                    }
                }
            }
        }
    }
}

interface LoginFormProps : RProps {
    var onClose: (Event) -> Unit
}

interface LoginFormState : RState {
    var username: String
    var password: String
}

fun RBuilder.loginForm(onClose: (Event) -> Unit) = child(LoginForm::class) {
    attrs.onClose = onClose
}