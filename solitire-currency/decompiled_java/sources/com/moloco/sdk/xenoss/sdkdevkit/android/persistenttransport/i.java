package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface i extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f21737a = a.f21738a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f21738a = new a();

        @NotNull
        public final i a(@NotNull l worker) {
            t.i(worker, "worker");
            return new j(worker);
        }
    }
}
