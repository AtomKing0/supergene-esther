package com.braze.events;

import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class SessionStateChangedEvent {
    private final ChangeType eventType;
    private final String sessionId;

    public enum ChangeType {
        SESSION_STARTED,
        SESSION_ENDED
    }

    public SessionStateChangedEvent(String sessionId, ChangeType eventType) {
        t.i(sessionId, "sessionId");
        t.i(eventType, "eventType");
        this.sessionId = sessionId;
        this.eventType = eventType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionStateChangedEvent)) {
            return false;
        }
        SessionStateChangedEvent sessionStateChangedEvent = (SessionStateChangedEvent) obj;
        return t.d(this.sessionId, sessionStateChangedEvent.sessionId) && this.eventType == sessionStateChangedEvent.eventType;
    }

    public int hashCode() {
        return this.eventType.hashCode() + (this.sessionId.hashCode() * 31);
    }

    public String toString() {
        return "SessionStateChangedEvent{sessionId='" + this.sessionId + "', eventType='" + this.eventType + "'}'";
    }
}
