package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@KeepForSdk
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(l5.e eVar) {
        return new FirebaseMessaging((i5.e) eVar.a(i5.e.class), (v5.a) eVar.a(v5.a.class), eVar.g(f6.i.class), eVar.g(u5.j.class), (x5.e) eVar.a(x5.e.class), (w1.i) eVar.a(w1.i.class), (t5.d) eVar.a(t5.d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<l5.c<?>> getComponents() {
        return Arrays.asList(l5.c.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(l5.r.i(i5.e.class)).b(l5.r.g(v5.a.class)).b(l5.r.h(f6.i.class)).b(l5.r.h(u5.j.class)).b(l5.r.g(w1.i.class)).b(l5.r.i(x5.e.class)).b(l5.r.i(t5.d.class)).f(new l5.h() { // from class: com.google.firebase.messaging.c0
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return FirebaseMessagingRegistrar.lambda$getComponents$0(eVar);
            }
        }).c().d(), f6.h.b(LIBRARY_NAME, "23.4.1"));
    }
}
