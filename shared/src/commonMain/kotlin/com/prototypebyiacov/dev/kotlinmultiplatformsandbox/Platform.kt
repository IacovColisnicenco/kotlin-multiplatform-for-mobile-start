package com.prototypebyiacov.dev.kotlinmultiplatformsandbox

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform