package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.cct.a;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import java.util.Arrays;
import java.util.List;
import l5.c;
import l5.e;
import l5.h;
import l5.r;
import w1.i;
import y1.t;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i lambda$getComponents$0(e eVar) {
        t.f((Context) eVar.a(Context.class));
        return t.c().g(a.f8419h);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(i.class).h(LIBRARY_NAME).b(r.i(Context.class)).f(new h() { // from class: n5.a
            @Override // l5.h
            public final Object a(e eVar) {
                return TransportRegistrar.lambda$getComponents$0(eVar);
            }
        }).d(), f6.h.b(LIBRARY_NAME, "18.1.7"));
    }
}
