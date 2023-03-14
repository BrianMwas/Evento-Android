package com.quicksnap.framework.extension

import kotlinx.coroutines.flow.Flow

inline fun <reified T> observeDoc(docRef: DocumentReference): Flow<T> {

}