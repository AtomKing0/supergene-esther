package com.vungle.ads.internal.network.converters;

import ga.e0;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EmptyResponseConverter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements a<e0, Void> {
    @Override // com.vungle.ads.internal.network.converters.a
    @Nullable
    public Void convert(@Nullable e0 e0Var) {
        if (e0Var == null) {
            return null;
        }
        e0Var.close();
        return null;
    }
}
