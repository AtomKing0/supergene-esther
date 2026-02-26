package com.ironsource;

import android.os.Handler;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final c f14170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final d f14171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final b f14172c;

    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.ns$a$a, reason: collision with other inner class name */
        static final class C0263a extends kotlin.jvm.internal.v implements h9.a<ws> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TestSuiteActivity f14173a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Handler f14174b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0263a(TestSuiteActivity testSuiteActivity, Handler handler) {
                super(0);
                this.f14173a = testSuiteActivity;
                this.f14174b = handler;
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ws invoke() {
                return new ws(this.f14173a, this.f14174b);
            }
        }

        static final class b extends kotlin.jvm.internal.v implements h9.a<ct> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TestSuiteActivity f14175a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Handler f14176b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(TestSuiteActivity testSuiteActivity, Handler handler) {
                super(0);
                this.f14175a = testSuiteActivity;
                this.f14176b = handler;
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ct invoke() {
                return new ct(this.f14175a, this.f14176b);
            }
        }

        private static final ct b(v8.l<ct> lVar) {
            return lVar.getValue();
        }

        @NotNull
        public final ns a(@NotNull List<? extends IronSource.AD_UNIT> maduEnabledAdUnits, @NotNull TestSuiteActivity activity, @NotNull Handler handler) {
            kotlin.jvm.internal.t.i(maduEnabledAdUnits, "maduEnabledAdUnits");
            kotlin.jvm.internal.t.i(activity, "activity");
            kotlin.jvm.internal.t.i(handler, "handler");
            v8.l lVarA = v8.n.a(new C0263a(activity, handler));
            v8.l lVarA2 = v8.n.a(new b(activity, handler));
            return new ns(maduEnabledAdUnits.contains(IronSource.AD_UNIT.INTERSTITIAL) ? a(lVarA) : b(lVarA2), maduEnabledAdUnits.contains(IronSource.AD_UNIT.REWARDED_VIDEO) ? a(lVarA) : b(lVarA2), maduEnabledAdUnits.contains(IronSource.AD_UNIT.BANNER) ? a(lVarA) : b(lVarA2), null);
        }

        private static final ws a(v8.l<ws> lVar) {
            return lVar.getValue();
        }
    }

    public interface b {
        void a(double d10);

        void a(@NotNull ts tsVar, @NotNull String str, int i10, int i11);

        void b();
    }

    public interface c {
        void a(@NotNull ts tsVar);

        void c();

        boolean e();
    }

    public interface d {
        boolean a();

        void b(@NotNull ts tsVar);

        void d();
    }

    private ns(c cVar, d dVar, b bVar) {
        this.f14170a = cVar;
        this.f14171b = dVar;
        this.f14172c = bVar;
    }

    @NotNull
    public final b a() {
        return this.f14172c;
    }

    @NotNull
    public final c b() {
        return this.f14170a;
    }

    @NotNull
    public final d c() {
        return this.f14171b;
    }

    public /* synthetic */ ns(c cVar, d dVar, b bVar, kotlin.jvm.internal.k kVar) {
        this(cVar, dVar, bVar);
    }
}
