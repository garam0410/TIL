package com.kotlin.test.config

inline fun getStaticTempPath(): String = DocumentProperties().tempPath

inline fun getStaticRealPath(): String = DocumentProperties().realPath