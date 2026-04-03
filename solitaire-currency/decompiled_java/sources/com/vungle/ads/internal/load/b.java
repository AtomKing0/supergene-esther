package com.vungle.ads.internal.load;

import com.vungle.ads.z1;
import java.io.Serializable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements Serializable {

    @Nullable
    private final com.vungle.ads.internal.model.e adMarkup;

    @NotNull
    private final com.vungle.ads.internal.model.j placement;

    @Nullable
    private final z1 requestAdSize;

    public b(@NotNull com.vungle.ads.internal.model.j placement, @Nullable com.vungle.ads.internal.model.e eVar, @Nullable z1 z1Var) {
        t.i(placement, "placement");
        this.placement = placement;
        this.adMarkup = eVar;
        this.requestAdSize = z1Var;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(b.class, obj.getClass())) {
            return false;
        }
        b bVar = (b) obj;
        if (!t.d(this.placement.getReferenceId(), bVar.placement.getReferenceId()) || !t.d(this.requestAdSize, bVar.requestAdSize)) {
            return false;
        }
        com.vungle.ads.internal.model.e eVar = this.adMarkup;
        com.vungle.ads.internal.model.e eVar2 = bVar.adMarkup;
        return eVar != null ? t.d(eVar, eVar2) : eVar2 == null;
    }

    @Nullable
    public final com.vungle.ads.internal.model.e getAdMarkup() {
        return this.adMarkup;
    }

    @NotNull
    public final com.vungle.ads.internal.model.j getPlacement() {
        return this.placement;
    }

    @Nullable
    public final z1 getRequestAdSize() {
        return this.requestAdSize;
    }

    public int hashCode() {
        int iHashCode = this.placement.getReferenceId().hashCode() * 31;
        z1 z1Var = this.requestAdSize;
        int iHashCode2 = (iHashCode + (z1Var != null ? z1Var.hashCode() : 0)) * 31;
        com.vungle.ads.internal.model.e eVar = this.adMarkup;
        return iHashCode2 + (eVar != null ? eVar.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AdRequest{placementId='" + this.placement.getReferenceId() + "', adMarkup=" + this.adMarkup + ", requestAdSize=" + this.requestAdSize + '}';
    }
}
