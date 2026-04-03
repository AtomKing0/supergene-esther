package com.braze.events;

import bo.app.h1;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeUserChangeEvent {
    private final String currentUserId;

    public BrazeUserChangeEvent(String currentUserId) {
        t.i(currentUserId, "currentUserId");
        this.currentUserId = currentUserId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrazeUserChangeEvent) && t.d(this.currentUserId, ((BrazeUserChangeEvent) obj).currentUserId);
    }

    public final String getCurrentUserId() {
        return this.currentUserId;
    }

    public int hashCode() {
        return this.currentUserId.hashCode();
    }

    public String toString() {
        return h1.a(new StringBuilder("BrazeUserChangeEvent(currentUserId="), this.currentUserId, ')');
    }
}
