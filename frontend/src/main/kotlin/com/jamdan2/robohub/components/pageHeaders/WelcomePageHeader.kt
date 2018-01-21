package com.jamdan2.robohub.components.pageHeaders

import kotlinx.html.*
import react.*
import react.dom.*

class WelcomePageHeader : RComponent<WelcomePageHeaderProps, RState>() {
    override fun RBuilder.render() {
        div("WelcomePageHeader") {
            div("container") {
                if (props.text != "") h1 {
                    attrs.classes += "text"
                    +props.text
                }
                if (props.subtext != "") h1 {
                        attrs.classes += "subtext"
                        +props.subtext
                }
            }
            if (props.imgSrc != "") img(props.imgAlt, props.imgSrc) {}
        }
    }
}

interface WelcomePageHeaderProps : RProps {
    var text: String
    var subtext: String
    var imgAlt: String
    var imgSrc: String
}

fun RBuilder.welcomePageHeader(
        text: String = "",
        subtext: String = "",
        imgAlt: String = "",
        imgSrc: String = ""
) = child(WelcomePageHeader::class) {
    attrs.text = text
    attrs.subtext = subtext
    attrs.imgAlt = imgAlt
    attrs.imgSrc = imgSrc
}