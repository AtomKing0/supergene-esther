package com.moloco.sdk.internal;

import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17650b;

    @StabilityInferred(parameters = 0)
    public static final class a extends i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final a f17651c = new a();

        public a() {
            super(AnimationConstants.DefaultDurationMillis, 250, null);
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final b f17652c = new b();

        public b() {
            super(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50, null);
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c extends i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final c f17653c = new c();

        public c() {
            super(728, 90, null);
        }
    }

    public /* synthetic */ i(int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(i10, i11);
    }

    public int a() {
        return this.f17650b;
    }

    public int b() {
        return this.f17649a;
    }

    public i(int i10, int i11) {
        this.f17649a = i10;
        this.f17650b = i11;
    }
}
