package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import com.ironsource.v8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public enum p {
    Portrait,
    Landscape,
    None;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f19595a = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final p a(@Nullable String str) {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != 3387192) {
                    if (iHashCode != 729267099) {
                        if (iHashCode == 1430647483 && str.equals(v8.h.C)) {
                            return p.Landscape;
                        }
                    } else if (str.equals(v8.h.D)) {
                        return p.Portrait;
                    }
                } else if (str.equals("none")) {
                    return p.None;
                }
            }
            return null;
        }

        public a() {
        }
    }
}
