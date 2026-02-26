package com.unity3d.services.core.properties;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Session.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface Session {

    @NotNull
    public static final Default Default = Default.$$INSTANCE;

    /* JADX INFO: compiled from: Session.kt */
    public static final class Default implements Session {
        static final /* synthetic */ Default $$INSTANCE = new Default();

        @NotNull
        private static final String id = SessionIdReader.INSTANCE.getSessionId();

        private Default() {
        }

        @Override // com.unity3d.services.core.properties.Session
        @NotNull
        public String getId() {
            return id;
        }
    }

    @NotNull
    String getId();
}
