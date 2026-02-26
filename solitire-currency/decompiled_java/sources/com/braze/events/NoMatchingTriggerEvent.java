package com.braze.events;

import bo.app.h1;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class NoMatchingTriggerEvent {
    private final String sourceEventType;

    public NoMatchingTriggerEvent(String sourceEventType) {
        t.i(sourceEventType, "sourceEventType");
        this.sourceEventType = sourceEventType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NoMatchingTriggerEvent) && t.d(this.sourceEventType, ((NoMatchingTriggerEvent) obj).sourceEventType);
    }

    public final String getSourceEventType() {
        return this.sourceEventType;
    }

    public int hashCode() {
        return this.sourceEventType.hashCode();
    }

    public String toString() {
        return h1.a(new StringBuilder("NoMatchingTriggerEvent(sourceEventType="), this.sourceEventType, ')');
    }
}
