package com.vungle.ads;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m0 extends b2 {
    public /* synthetic */ m0(int i10, String str, int i11, kotlin.jvm.internal.k kVar) {
        this(i10, (i11 & 2) != 0 ? null : str);
    }

    @Override // com.vungle.ads.b2
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.t.d(m0.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        int code = getCode();
        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type com.vungle.ads.InternalError");
        return code == ((m0) obj).getCode();
    }

    @Override // com.vungle.ads.b2
    public int hashCode() {
        return m0.class.hashCode();
    }

    public m0(int i10, @Nullable String str) {
        super(Integer.valueOf(i10), null, str, null, null, null, 58, null);
    }
}
