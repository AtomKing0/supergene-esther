package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0310a f17818d = new C0310a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final AdFormatType f17819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17821c;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.a$a, reason: collision with other inner class name */
    public static final class C0310a {
        public /* synthetic */ C0310a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public C0310a() {
        }
    }

    public /* synthetic */ a(AdFormatType adFormatType, long j10, kotlin.jvm.internal.k kVar) {
        this(adFormatType, j10);
    }

    public final long a(long j10) {
        long jB = j10 - b();
        long jT = q9.d.t(q9.b.q(this.f17820b) - jB, q9.e.f33186d);
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdCreateLoadTimeoutManager", this.f17819a + " timeout: " + ((Object) q9.b.I(this.f17820b)) + " , create ad duration: " + jB + " ms (createTime: " + b() + " ms, loadStartTime: " + j10 + " ms). Return value: " + ((Object) q9.b.I(jT)), false, 4, null);
        return jT;
    }

    public long b() {
        return this.f17821c;
    }

    @Override // com.moloco.sdk.internal.publisher.a0
    public void setCreateAdObjectStartTime(long j10) {
        this.f17821c = j10;
    }

    public a(AdFormatType adFormatType, long j10) {
        kotlin.jvm.internal.t.i(adFormatType, "adFormatType");
        this.f17819a = adFormatType;
        this.f17820b = j10;
    }
}
