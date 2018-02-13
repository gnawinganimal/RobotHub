package com.jamdan2.robohub.pages.welcomepage.components

import react.*
import react.dom.div

class TitleDisplay : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("TitleDisplay") {
            div("td-container") {
                children()
            }
        }
    }
}

fun RBuilder.titleDisplay(handler: RHandler<RProps>) = child(TitleDisplay::class, handler)