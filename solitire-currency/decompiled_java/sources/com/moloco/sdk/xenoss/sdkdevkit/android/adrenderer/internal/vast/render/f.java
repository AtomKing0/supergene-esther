package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final t f21290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final File f21291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Integer f21292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f21293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f21294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final h f21295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final e f21296g;

    public f(@Nullable t tVar, @NotNull File localMediaResource, @Nullable Integer num, @NotNull String networkMediaResource, @Nullable String str, @NotNull h tracking, @Nullable e eVar) {
        kotlin.jvm.internal.t.i(localMediaResource, "localMediaResource");
        kotlin.jvm.internal.t.i(networkMediaResource, "networkMediaResource");
        kotlin.jvm.internal.t.i(tracking, "tracking");
        this.f21290a = tVar;
        this.f21291b = localMediaResource;
        this.f21292c = num;
        this.f21293d = networkMediaResource;
        this.f21294e = str;
        this.f21295f = tracking;
        this.f21296g = eVar;
    }

    public static /* synthetic */ f b(f fVar, t tVar, File file, Integer num, String str, String str2, h hVar, e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            tVar = fVar.f21290a;
        }
        if ((i10 & 2) != 0) {
            file = fVar.f21291b;
        }
        File file2 = file;
        if ((i10 & 4) != 0) {
            num = fVar.f21292c;
        }
        Integer num2 = num;
        if ((i10 & 8) != 0) {
            str = fVar.f21293d;
        }
        String str3 = str;
        if ((i10 & 16) != 0) {
            str2 = fVar.f21294e;
        }
        String str4 = str2;
        if ((i10 & 32) != 0) {
            hVar = fVar.f21295f;
        }
        h hVar2 = hVar;
        if ((i10 & 64) != 0) {
            eVar = fVar.f21296g;
        }
        return fVar.a(tVar, file2, num2, str3, str4, hVar2, eVar);
    }

    @NotNull
    public final f a(@Nullable t tVar, @NotNull File localMediaResource, @Nullable Integer num, @NotNull String networkMediaResource, @Nullable String str, @NotNull h tracking, @Nullable e eVar) {
        kotlin.jvm.internal.t.i(localMediaResource, "localMediaResource");
        kotlin.jvm.internal.t.i(networkMediaResource, "networkMediaResource");
        kotlin.jvm.internal.t.i(tracking, "tracking");
        return new f(tVar, localMediaResource, num, networkMediaResource, str, tracking, eVar);
    }

    @Nullable
    public final String c() {
        return this.f21294e;
    }

    @Nullable
    public final e d() {
        return this.f21296g;
    }

    @NotNull
    public final File e() {
        return this.f21291b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.t.d(this.f21290a, fVar.f21290a) && kotlin.jvm.internal.t.d(this.f21291b, fVar.f21291b) && kotlin.jvm.internal.t.d(this.f21292c, fVar.f21292c) && kotlin.jvm.internal.t.d(this.f21293d, fVar.f21293d) && kotlin.jvm.internal.t.d(this.f21294e, fVar.f21294e) && kotlin.jvm.internal.t.d(this.f21295f, fVar.f21295f) && kotlin.jvm.internal.t.d(this.f21296g, fVar.f21296g);
    }

    @Nullable
    public final Integer f() {
        return this.f21292c;
    }

    @NotNull
    public final String g() {
        return this.f21293d;
    }

    @Nullable
    public final t h() {
        return this.f21290a;
    }

    public int hashCode() {
        t tVar = this.f21290a;
        int iHashCode = (((tVar == null ? 0 : tVar.hashCode()) * 31) + this.f21291b.hashCode()) * 31;
        Integer num = this.f21292c;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f21293d.hashCode()) * 31;
        String str = this.f21294e;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.f21295f.hashCode()) * 31;
        e eVar = this.f21296g;
        return iHashCode3 + (eVar != null ? eVar.hashCode() : 0);
    }

    @NotNull
    public final h i() {
        return this.f21295f;
    }

    @NotNull
    public String toString() {
        return "Linear(skipOffset=" + this.f21290a + ", localMediaResource=" + this.f21291b + ", localMediaResourceBitrate=" + this.f21292c + ", networkMediaResource=" + this.f21293d + ", clickThroughUrl=" + this.f21294e + ", tracking=" + this.f21295f + ", icon=" + this.f21296g + ')';
    }
}
