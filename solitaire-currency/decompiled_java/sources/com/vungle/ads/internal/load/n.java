package com.vungle.ads.internal.load;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RTADebugger.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    public static final String RTA_DEBUG_ENDPOINT = "https://events.ads.vungle.com/rtadebugging";

    @NotNull
    private final com.vungle.ads.internal.network.i apiClient;

    /* JADX INFO: compiled from: RTADebugger.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public n(@NotNull com.vungle.ads.internal.network.i apiClient) {
        t.i(apiClient, "apiClient");
        this.apiClient = apiClient;
    }

    public final void reportAdMarkup(@NotNull String adm) {
        t.i(adm, "adm");
        this.apiClient.sendAdMarkup(adm, RTA_DEBUG_ENDPOINT);
    }
}
