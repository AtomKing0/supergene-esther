package bo.app;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class bc0 {
    public static cc0 a(String sessionId) {
        kotlin.jvm.internal.t.i(sessionId, "sessionId");
        UUID uuidFromString = UUID.fromString(sessionId);
        kotlin.jvm.internal.t.h(uuidFromString, "fromString(sessionId)");
        return new cc0(uuidFromString);
    }
}
