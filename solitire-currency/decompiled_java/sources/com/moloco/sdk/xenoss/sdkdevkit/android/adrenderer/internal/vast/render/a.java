package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final f f20750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final c f20751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<String> f20752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<String> f20753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final s f20754e;

    public a(@NotNull f linear, @Nullable c cVar, @NotNull List<String> impressionTracking, @NotNull List<String> errorTracking, @Nullable s sVar) {
        t.i(linear, "linear");
        t.i(impressionTracking, "impressionTracking");
        t.i(errorTracking, "errorTracking");
        this.f20750a = linear;
        this.f20751b = cVar;
        this.f20752c = impressionTracking;
        this.f20753d = errorTracking;
        this.f20754e = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a a(a aVar, f fVar, c cVar, List list, List list2, s sVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fVar = aVar.f20750a;
        }
        if ((i10 & 2) != 0) {
            cVar = aVar.f20751b;
        }
        c cVar2 = cVar;
        if ((i10 & 4) != 0) {
            list = aVar.f20752c;
        }
        List list3 = list;
        if ((i10 & 8) != 0) {
            list2 = aVar.f20753d;
        }
        List list4 = list2;
        if ((i10 & 16) != 0) {
            sVar = aVar.f20754e;
        }
        return aVar.b(fVar, cVar2, list3, list4, sVar);
    }

    @NotNull
    public final a b(@NotNull f linear, @Nullable c cVar, @NotNull List<String> impressionTracking, @NotNull List<String> errorTracking, @Nullable s sVar) {
        t.i(linear, "linear");
        t.i(impressionTracking, "impressionTracking");
        t.i(errorTracking, "errorTracking");
        return new a(linear, cVar, impressionTracking, errorTracking, sVar);
    }

    @Nullable
    public final c c() {
        return this.f20751b;
    }

    @Nullable
    public final s d() {
        return this.f20754e;
    }

    @NotNull
    public final List<String> e() {
        return this.f20753d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.d(this.f20750a, aVar.f20750a) && t.d(this.f20751b, aVar.f20751b) && t.d(this.f20752c, aVar.f20752c) && t.d(this.f20753d, aVar.f20753d) && t.d(this.f20754e, aVar.f20754e);
    }

    @NotNull
    public final List<String> f() {
        return this.f20752c;
    }

    @NotNull
    public final f g() {
        return this.f20750a;
    }

    public int hashCode() {
        int iHashCode = this.f20750a.hashCode() * 31;
        c cVar = this.f20751b;
        int iHashCode2 = (((((iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f20752c.hashCode()) * 31) + this.f20753d.hashCode()) * 31;
        s sVar = this.f20754e;
        return iHashCode2 + (sVar != null ? sVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Ad(linear=" + this.f20750a + ", companion=" + this.f20751b + ", impressionTracking=" + this.f20752c + ", errorTracking=" + this.f20753d + ", dec=" + this.f20754e + ')';
    }

    public /* synthetic */ a(f fVar, c cVar, List list, List list2, s sVar, int i10, kotlin.jvm.internal.k kVar) {
        this(fVar, cVar, list, list2, (i10 & 16) != 0 ? null : sVar);
    }
}
