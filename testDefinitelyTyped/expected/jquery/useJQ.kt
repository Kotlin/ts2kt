package use.jq

import JQueryAnimationOptions
import jQuery
import kotlin.browser.window


fun main() {
    jQuery("#area").hover { window.alert("Hello!") }.slideDown().slideDown(1).slideDown("1").slideDown(1, "")
            .animate("").animate("", "").animate("", 1).animate("", object : JQueryAnimationOptions {})
            .animate("", "", "")
}