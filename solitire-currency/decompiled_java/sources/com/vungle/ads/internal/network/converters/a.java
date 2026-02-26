package com.vungle.ads.internal.network.converters;

import java.io.IOException;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Converter.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a<In, Out> {
    @Nullable
    Out convert(In in) throws IOException;
}
