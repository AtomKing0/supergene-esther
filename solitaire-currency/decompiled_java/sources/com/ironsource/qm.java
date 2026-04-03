package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class qm implements oo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14539a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f14540a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f14541b = "IronSource";

        private a() {
        }
    }

    public qm(@NotNull String networkInstanceId) {
        kotlin.jvm.internal.t.i(networkInstanceId, "networkInstanceId");
        this.f14539a = networkInstanceId;
    }

    @Override // com.ironsource.oo
    @NotNull
    public String value() {
        if (this.f14539a.length() == 0) {
            return "";
        }
        if (kotlin.jvm.internal.t.d(this.f14539a, "0") || kotlin.jvm.internal.t.d(this.f14539a, "IronSource")) {
            return "IronSource";
        }
        return "IronSource_" + this.f14539a;
    }
}
