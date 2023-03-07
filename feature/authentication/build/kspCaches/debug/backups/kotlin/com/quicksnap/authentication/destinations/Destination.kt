package com.quicksnap.authentication.destinations

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.*

/**
 * Handy typealias of [AuthenticationTypedDestination] when you don't
 * care about the generic type (probably most cases for app's use)
 */
public typealias AuthenticationDestination = AuthenticationTypedDestination<*>

/**
 * AuthenticationTypedDestination is a sealed version of [DestinationSpec]
 */
public sealed interface AuthenticationTypedDestination<T>: DestinationSpec<T>

/**
 * AuthenticationDirectionDestination is a sealed version of [DirectionDestinationSpec]
 */
public sealed interface AuthenticationDirectionDestination: AuthenticationTypedDestination<Unit>, DirectionDestinationSpec

