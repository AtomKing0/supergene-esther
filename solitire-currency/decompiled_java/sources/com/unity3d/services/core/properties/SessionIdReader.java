package com.unity3d.services.core.properties;

import java.util.UUID;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SessionIdReader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionIdReader {

    @NotNull
    public static final SessionIdReader INSTANCE = new SessionIdReader();

    @NotNull
    private static final String sessionId;

    static {
        String string = UUID.randomUUID().toString();
        t.h(string, "randomUUID().toString()");
        sessionId = string;
    }

    private SessionIdReader() {
    }

    @NotNull
    public final String getSessionId() {
        return sessionId;
    }
}
