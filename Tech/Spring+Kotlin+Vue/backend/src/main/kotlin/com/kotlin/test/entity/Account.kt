package com.kotlin.test.entity

import com.kotlin.test.security.AccountRole
import javax.persistence.*

@Entity
data class Account(

    @Id @GeneratedValue
    var id: Long? = null,
    var email: String,
    var password: String,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    var roles: MutableSet<AccountRole>
) {
}