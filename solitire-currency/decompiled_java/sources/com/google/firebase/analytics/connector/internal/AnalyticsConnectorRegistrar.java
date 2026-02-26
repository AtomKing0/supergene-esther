package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import i5.e;
import java.util.Arrays;
import java.util.List;
import l5.c;
import l5.h;
import l5.r;
import t5.d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    @Keep
    @SuppressLint({"MissingPermission"})
    @KeepForSdk
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(j5.a.class).b(r.i(e.class)).b(r.i(Context.class)).b(r.i(d.class)).f(new h() { // from class: com.google.firebase.analytics.connector.internal.a
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return j5.b.c((e) eVar.a(e.class), (Context) eVar.a(Context.class), (d) eVar.a(d.class));
            }
        }).e().d(), f6.h.b("fire-analytics", "21.6.1"));
    }
}
