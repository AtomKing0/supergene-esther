package com.ironsource;

import com.ironsource.jd;
import com.ironsource.md;
import com.ironsource.mt;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f11379a = c.f11386a;

    public static final class a implements b9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final id f11380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final mt f11381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final AtomicBoolean f11382d;

        /* JADX INFO: renamed from: com.ironsource.b9$a$a, reason: collision with other inner class name */
        public static final class C0250a implements mt.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f11383a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f11384b;

            C0250a(d dVar, a aVar) {
                this.f11383a = dVar;
                this.f11384b = aVar;
            }

            @Override // com.ironsource.mt.a
            public void a() {
                this.f11383a.a(new md.a(new jd.a(this.f11384b.f11380b.b())));
                this.f11384b.f11382d.set(false);
            }
        }

        public a(@NotNull id config, @NotNull mt timer) {
            kotlin.jvm.internal.t.i(config, "config");
            kotlin.jvm.internal.t.i(timer, "timer");
            this.f11380b = config;
            this.f11381c = timer;
            this.f11382d = new AtomicBoolean(false);
        }

        @Override // com.ironsource.b9
        public synchronized void a() {
            this.f11381c.cancel();
            this.f11382d.set(false);
        }

        @Override // com.ironsource.b9
        public synchronized void a(@NotNull d callback) {
            kotlin.jvm.internal.t.i(callback, "callback");
            if (this.f11382d.compareAndSet(false, true)) {
                this.f11381c.a(new C0250a(callback, this));
            }
        }
    }

    public static final class b implements b9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f11385b = new b();

        private b() {
        }

        @Override // com.ironsource.b9
        public void a() {
        }

        @Override // com.ironsource.b9
        public void a(@NotNull d callback) {
            kotlin.jvm.internal.t.i(callback, "callback");
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ c f11386a = new c();

        private c() {
        }

        @NotNull
        public final b9 a() {
            return b.f11385b;
        }

        @NotNull
        public final b9 a(@NotNull kd featureFlag) {
            kotlin.jvm.internal.t.i(featureFlag, "featureFlag");
            if (!featureFlag.c()) {
                return b.f11385b;
            }
            hd hdVar = new hd(featureFlag);
            mt.b bVar = new mt.b();
            bVar.b(hdVar.a());
            bVar.a(hdVar.a());
            return new a(hdVar, new mt.d().a(bVar));
        }
    }

    public interface d {
        void a(@NotNull md mdVar);
    }

    void a();

    void a(@NotNull d dVar);
}
