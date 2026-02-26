package com.moloco.sdk.publisher.bidrequest;

import com.moloco.sdk.i;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class GeoKt {
    @NotNull
    public static final Geo toGeo(@NotNull i.g gVar) {
        t.i(gVar, "<this>");
        return new Geo(gVar.getCity(), gVar.c(), gVar.b(), gVar.f(), Float.valueOf(gVar.d()), Float.valueOf(gVar.e()));
    }
}
