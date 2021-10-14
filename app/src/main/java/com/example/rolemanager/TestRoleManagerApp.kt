package com.example.rolemanager

import android.app.Application
import android.app.role.RoleManager
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.core.content.ContextCompat

class TestRoleManagerApp : Application() {

    private val roleManager: RoleManager? =
        if (isAtLeastQ()) {
            ContextCompat.getSystemService(this, RoleManager::class.java)
        } else {
            null
        }


    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.Q)
    fun isAtLeastQ(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
    }

}