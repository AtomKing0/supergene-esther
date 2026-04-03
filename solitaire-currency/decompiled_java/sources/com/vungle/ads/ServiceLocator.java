package com.vungle.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.internal.omsdk.d;
import com.vungle.ads.internal.persistence.b;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ServiceLocator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ServiceLocator {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static volatile ServiceLocator INSTANCE;

    @NotNull
    private final Map<Class<?>, Object> cache;

    @NotNull
    private final Map<Class<?>, a<?>> creators;

    @NotNull
    private final Context ctx;

    /* JADX INFO: compiled from: ServiceLocator.kt */
    private abstract class a<T> {
        private final boolean isSingleton;

        public a(boolean z10) {
            this.isSingleton = z10;
        }

        public abstract T create();

        public final boolean isSingleton() {
            return this.isSingleton;
        }

        public /* synthetic */ a(ServiceLocator serviceLocator, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? true : z10);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class b extends a<com.vungle.ads.internal.bidding.a> {
        b() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.bidding.a create() {
            return new com.vungle.ads.internal.bidding.a(ServiceLocator.this.ctx);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class c extends a<com.vungle.ads.internal.util.q> {
        c() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.util.q create() {
            return new com.vungle.ads.internal.util.q(ServiceLocator.this.ctx);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class d extends a<com.vungle.ads.internal.downloader.e> {
        d() {
            super(false);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.downloader.e create() {
            return new com.vungle.ads.internal.downloader.c(((com.vungle.ads.internal.executor.a) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.executor.a.class)).getDownloaderExecutor(), (com.vungle.ads.internal.util.q) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.util.q.class));
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class e extends a<com.vungle.ads.internal.util.e> {
        e(ServiceLocator serviceLocator) {
            super(serviceLocator, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.util.e create() {
            return new com.vungle.ads.internal.util.e();
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends a<com.vungle.ads.internal.signals.b> {
        f() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.signals.b create() {
            return new com.vungle.ads.internal.signals.b(ServiceLocator.this.ctx);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class g extends a<com.vungle.ads.internal.task.c> {
        g() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.task.c create() {
            return new com.vungle.ads.internal.task.l(ServiceLocator.this.ctx, (com.vungle.ads.internal.util.q) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.util.q.class));
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class h extends a<com.vungle.ads.internal.task.f> {
        h() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.task.f create() {
            return new com.vungle.ads.internal.task.m((com.vungle.ads.internal.task.c) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.task.c.class), ((com.vungle.ads.internal.executor.a) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.executor.a.class)).getJobExecutor(), new com.vungle.ads.internal.task.g());
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class i extends a<com.vungle.ads.internal.network.i> {
        i() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.network.i create() {
            return new com.vungle.ads.internal.network.i(ServiceLocator.this.ctx, (com.vungle.ads.internal.platform.d) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.platform.d.class), (com.vungle.ads.internal.persistence.b) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.persistence.b.class));
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class j extends a<com.vungle.ads.internal.platform.d> {
        j() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.platform.d create() {
            return new com.vungle.ads.internal.platform.c(ServiceLocator.this.ctx, ((com.vungle.ads.internal.executor.a) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.executor.a.class)).getUaExecutor());
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class k extends a<com.vungle.ads.internal.executor.a> {
        k(ServiceLocator serviceLocator) {
            super(serviceLocator, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.executor.a create() {
            return new com.vungle.ads.internal.executor.d();
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class l extends a<com.vungle.ads.internal.omsdk.c> {
        l() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.omsdk.c create() {
            return new com.vungle.ads.internal.omsdk.c(ServiceLocator.this.ctx);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class m extends a<d.b> {
        m(ServiceLocator serviceLocator) {
            super(serviceLocator, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public d.b create() {
            return new d.b();
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class n extends a<com.vungle.ads.internal.persistence.b> {
        n() {
            super(ServiceLocator.this, false, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public com.vungle.ads.internal.persistence.b create() {
            return b.a.get$default(com.vungle.ads.internal.persistence.b.Companion, ((com.vungle.ads.internal.executor.a) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.executor.a.class)).getIoExecutor(), (com.vungle.ads.internal.util.q) ServiceLocator.this.getOrBuild(com.vungle.ads.internal.util.q.class), null, 4, null);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class o extends a<p7.a> {
        o(ServiceLocator serviceLocator) {
            super(serviceLocator, false, 1, null);
        }

        @Override // com.vungle.ads.ServiceLocator.a
        @NotNull
        public p7.a create() {
            return new p7.b();
        }
    }

    public /* synthetic */ ServiceLocator(Context context, kotlin.jvm.internal.k kVar) {
        this(context);
    }

    private final void buildCreators() {
        this.creators.put(com.vungle.ads.internal.task.c.class, new g());
        this.creators.put(com.vungle.ads.internal.task.f.class, new h());
        this.creators.put(com.vungle.ads.internal.network.i.class, new i());
        this.creators.put(com.vungle.ads.internal.platform.d.class, new j());
        this.creators.put(com.vungle.ads.internal.executor.a.class, new k(this));
        this.creators.put(com.vungle.ads.internal.omsdk.c.class, new l());
        this.creators.put(d.b.class, new m(this));
        this.creators.put(com.vungle.ads.internal.persistence.b.class, new n());
        this.creators.put(p7.a.class, new o(this));
        this.creators.put(com.vungle.ads.internal.bidding.a.class, new b());
        this.creators.put(com.vungle.ads.internal.util.q.class, new c());
        this.creators.put(com.vungle.ads.internal.downloader.e.class, new d());
        this.creators.put(com.vungle.ads.internal.util.e.class, new e(this));
        this.creators.put(com.vungle.ads.internal.signals.b.class, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T getOrBuild(Class<T> cls) {
        Class<?> serviceClass = getServiceClass(cls);
        T t10 = (T) this.cache.get(serviceClass);
        if (t10 != null) {
            return t10;
        }
        a<?> aVar = this.creators.get(serviceClass);
        if (aVar == null) {
            throw new IllegalArgumentException("Unknown class");
        }
        T t11 = (T) aVar.create();
        if (aVar.isSingleton()) {
            this.cache.put(serviceClass, t11);
        }
        return t11;
    }

    private final Class<?> getServiceClass(Class<?> cls) {
        for (Class<?> cls2 : this.creators.keySet()) {
            if (cls2.isAssignableFrom(cls)) {
                return cls2;
            }
        }
        throw new IllegalArgumentException("Unknown dependency for " + cls);
    }

    @VisibleForTesting
    public final <T> void bindService$vungle_ads_release(@NotNull Class<?> serviceClass, T t10) {
        kotlin.jvm.internal.t.i(serviceClass, "serviceClass");
        this.cache.put(serviceClass, t10);
    }

    public final synchronized <T> T getService(@NotNull Class<T> serviceClass) {
        kotlin.jvm.internal.t.i(serviceClass, "serviceClass");
        return (T) getOrBuild(serviceClass);
    }

    public final synchronized <T> boolean isCreated(@NotNull Class<T> serviceClass) {
        kotlin.jvm.internal.t.i(serviceClass, "serviceClass");
        return this.cache.containsKey(getServiceClass(serviceClass));
    }

    private ServiceLocator(Context context) {
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.t.h(applicationContext, "context.applicationContext");
        this.ctx = applicationContext;
        this.creators = new HashMap();
        this.cache = new HashMap();
        buildCreators();
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    @Keep
    public static final class Companion {

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* JADX INFO: compiled from: ServiceLocator.kt */
        public static final class a<T> extends kotlin.jvm.internal.v implements h9.a<T> {
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context) {
                super(0);
                this.$context = context;
            }

            @Override // h9.a
            @NotNull
            public final T invoke() {
                ServiceLocator companion = ServiceLocator.Companion.getInstance(this.$context);
                kotlin.jvm.internal.t.o(4, "T");
                return (T) companion.getService(Object.class);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final synchronized void deInit() {
            setINSTANCE$vungle_ads_release(null);
        }

        @Nullable
        public final ServiceLocator getINSTANCE$vungle_ads_release() {
            return ServiceLocator.INSTANCE;
        }

        @NotNull
        public final ServiceLocator getInstance(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            ServiceLocator iNSTANCE$vungle_ads_release = getINSTANCE$vungle_ads_release();
            if (iNSTANCE$vungle_ads_release == null) {
                synchronized (this) {
                    Companion companion = ServiceLocator.Companion;
                    ServiceLocator iNSTANCE$vungle_ads_release2 = companion.getINSTANCE$vungle_ads_release();
                    if (iNSTANCE$vungle_ads_release2 == null) {
                        iNSTANCE$vungle_ads_release2 = new ServiceLocator(context, null);
                        companion.setINSTANCE$vungle_ads_release(iNSTANCE$vungle_ads_release2);
                    }
                    iNSTANCE$vungle_ads_release = iNSTANCE$vungle_ads_release2;
                }
            }
            return iNSTANCE$vungle_ads_release;
        }

        public final /* synthetic */ <T> v8.l<T> inject(Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            v8.p pVar = v8.p.f35201a;
            kotlin.jvm.internal.t.n();
            return v8.n.b(pVar, new a(context));
        }

        public final void setINSTANCE$vungle_ads_release(@Nullable ServiceLocator serviceLocator) {
            ServiceLocator.INSTANCE = serviceLocator;
        }

        @VisibleForTesting
        public static /* synthetic */ void getINSTANCE$vungle_ads_release$annotations() {
        }
    }
}
