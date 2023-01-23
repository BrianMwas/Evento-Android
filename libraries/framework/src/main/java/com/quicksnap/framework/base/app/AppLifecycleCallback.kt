package com.quicksnap.framework.base.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class AppLifecycleCallback: Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        activity.registerActivityLifecycleCallbacks()
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d(activity.localClassName, "OnStarted")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(activity.localClassName, "OnResumed")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(activity.localClassName, "OnActivityPaused")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(activity.localClassName, "OnActivityStopped")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d(activity.localClassName, "OnActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(activity.localClassName, "OnActivityDestroyed")
    }
}



private fun Activity.registerActivityLifecycleCallbacks() {
    if(this is FragmentActivity) {
        supportFragmentManager
            .registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(
                        fm: FragmentManager,
                        f: Fragment,
                        savedInstanceState: Bundle?
                    ) {
                        super.onFragmentCreated(fm, f, savedInstanceState)
                        Log.d(f.tag, "OnCreate View")
                    }

                    override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                        super.onFragmentResumed(fm, f)
                        Log.d(f.tag, "OnResume")
                    }

                    override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                        super.onFragmentPaused(fm, f)
                        Log.d(f.tag, "OnPaused")
                    }

                    override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                        super.onFragmentViewDestroyed(fm, f)
                        Log.d(f.tag, "OnFragmentDestroyed")
                    }
                },
                true
            )
    }
}