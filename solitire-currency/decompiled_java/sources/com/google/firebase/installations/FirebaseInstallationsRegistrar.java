package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import l5.e0;
import l5.r;
import m5.j;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x5.e lambda$getComponents$0(l5.e eVar) {
        return new c((i5.e) eVar.a(i5.e.class), eVar.g(u5.i.class), (ExecutorService) eVar.d(e0.a(k5.a.class, ExecutorService.class)), j.a((Executor) eVar.d(e0.a(k5.b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<l5.c<?>> getComponents() {
        return Arrays.asList(l5.c.c(x5.e.class).h(LIBRARY_NAME).b(r.i(i5.e.class)).b(r.h(u5.i.class)).b(r.j(e0.a(k5.a.class, ExecutorService.class))).b(r.j(e0.a(k5.b.class, Executor.class))).f(new l5.h() { // from class: x5.f
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(eVar);
            }
        }).d(), u5.h.a(), f6.h.b(LIBRARY_NAME, "17.2.0"));
    }
}
