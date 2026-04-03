package com.unity3d.services.core.di;

import h9.a;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: IServiceComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IServiceComponentKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.unity3d.services.core.di.IServiceComponentKt$inject$1, reason: invalid class name */
    /* JADX INFO: compiled from: IServiceComponent.kt */
    public static final class AnonymousClass1<T> extends v implements a<T> {
        final /* synthetic */ String $named;
        final /* synthetic */ IServiceComponent $this_inject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(IServiceComponent iServiceComponent, String str) {
            super(0);
            this.$this_inject = iServiceComponent;
            this.$named = str;
        }

        @Override // h9.a
        @NotNull
        public final T invoke() {
            IServiceComponent iServiceComponent = this.$this_inject;
            String str = this.$named;
            IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
            t.o(4, "T");
            return (T) registry.getService(str, o0.b(Object.class));
        }
    }

    public static final /* synthetic */ <T> T get(IServiceComponent iServiceComponent, String named) {
        t.i(iServiceComponent, "<this>");
        t.i(named, "named");
        IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
        t.o(4, "T");
        return (T) registry.getService(named, o0.b(Object.class));
    }

    public static /* synthetic */ Object get$default(IServiceComponent iServiceComponent, String named, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        t.i(iServiceComponent, "<this>");
        t.i(named, "named");
        IServicesRegistry registry = iServiceComponent.getServiceProvider().getRegistry();
        t.o(4, "T");
        return registry.getService(named, o0.b(Object.class));
    }

    public static final /* synthetic */ <T> l<T> inject(IServiceComponent iServiceComponent, String named, p mode) {
        t.i(iServiceComponent, "<this>");
        t.i(named, "named");
        t.i(mode, "mode");
        t.n();
        return n.b(mode, new AnonymousClass1(iServiceComponent, named));
    }

    public static /* synthetic */ l inject$default(IServiceComponent iServiceComponent, String named, p mode, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            named = "";
        }
        if ((i10 & 2) != 0) {
            mode = p.f35203c;
        }
        t.i(iServiceComponent, "<this>");
        t.i(named, "named");
        t.i(mode, "mode");
        t.n();
        return n.b(mode, new AnonymousClass1(iServiceComponent, named));
    }
}
