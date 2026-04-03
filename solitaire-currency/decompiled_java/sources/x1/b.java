package x1;

import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import io.sentry.protocol.Device;
import java.io.IOException;

/* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements q5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q5.a f35570a = new b();

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class a implements p5.d<x1.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f35571a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f35572b = p5.c.d("sdkVersion");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final p5.c f35573c = p5.c.d("model");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final p5.c f35574d = p5.c.d("hardware");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final p5.c f35575e = p5.c.d("device");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final p5.c f35576f = p5.c.d(AppLovinEventTypes.USER_VIEWED_PRODUCT);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final p5.c f35577g = p5.c.d("osBuild");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final p5.c f35578h = p5.c.d(Device.JsonKeys.MANUFACTURER);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final p5.c f35579i = p5.c.d("fingerprint");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final p5.c f35580j = p5.c.d(Device.JsonKeys.LOCALE);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final p5.c f35581k = p5.c.d(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final p5.c f35582l = p5.c.d("mccMnc");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final p5.c f35583m = p5.c.d("applicationBuild");

        private a() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(x1.a aVar, p5.e eVar) throws IOException {
            eVar.d(f35572b, aVar.m());
            eVar.d(f35573c, aVar.j());
            eVar.d(f35574d, aVar.f());
            eVar.d(f35575e, aVar.d());
            eVar.d(f35576f, aVar.l());
            eVar.d(f35577g, aVar.k());
            eVar.d(f35578h, aVar.h());
            eVar.d(f35579i, aVar.e());
            eVar.d(f35580j, aVar.g());
            eVar.d(f35581k, aVar.c());
            eVar.d(f35582l, aVar.i());
            eVar.d(f35583m, aVar.b());
        }
    }

    /* JADX INFO: renamed from: x1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class C0729b implements p5.d<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0729b f35584a = new C0729b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f35585b = p5.c.d("logRequest");

        private C0729b() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j jVar, p5.e eVar) throws IOException {
            eVar.d(f35585b, jVar.c());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class c implements p5.d<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f35586a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f35587b = p5.c.d("clientType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final p5.c f35588c = p5.c.d("androidClientInfo");

        private c() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k kVar, p5.e eVar) throws IOException {
            eVar.d(f35587b, kVar.c());
            eVar.d(f35588c, kVar.b());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class d implements p5.d<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f35589a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f35590b = p5.c.d("eventTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final p5.c f35591c = p5.c.d("eventCode");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final p5.c f35592d = p5.c.d("eventUptimeMs");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final p5.c f35593e = p5.c.d("sourceExtension");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final p5.c f35594f = p5.c.d("sourceExtensionJsonProto3");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final p5.c f35595g = p5.c.d("timezoneOffsetSeconds");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final p5.c f35596h = p5.c.d("networkConnectionInfo");

        private d() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(l lVar, p5.e eVar) throws IOException {
            eVar.b(f35590b, lVar.c());
            eVar.d(f35591c, lVar.b());
            eVar.b(f35592d, lVar.d());
            eVar.d(f35593e, lVar.f());
            eVar.d(f35594f, lVar.g());
            eVar.b(f35595g, lVar.h());
            eVar.d(f35596h, lVar.e());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class e implements p5.d<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f35597a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f35598b = p5.c.d("requestTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final p5.c f35599c = p5.c.d("requestUptimeMs");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final p5.c f35600d = p5.c.d("clientInfo");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final p5.c f35601e = p5.c.d("logSource");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final p5.c f35602f = p5.c.d("logSourceName");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final p5.c f35603g = p5.c.d("logEvent");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final p5.c f35604h = p5.c.d("qosTier");

        private e() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, p5.e eVar) throws IOException {
            eVar.b(f35598b, mVar.g());
            eVar.b(f35599c, mVar.h());
            eVar.d(f35600d, mVar.b());
            eVar.d(f35601e, mVar.d());
            eVar.d(f35602f, mVar.e());
            eVar.d(f35603g, mVar.c());
            eVar.d(f35604h, mVar.f());
        }
    }

    /* JADX INFO: compiled from: AutoBatchedLogRequestEncoder.java */
    private static final class f implements p5.d<o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f35605a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f35606b = p5.c.d("networkType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final p5.c f35607c = p5.c.d("mobileSubtype");

        private f() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(o oVar, p5.e eVar) throws IOException {
            eVar.d(f35606b, oVar.c());
            eVar.d(f35607c, oVar.b());
        }
    }

    private b() {
    }

    @Override // q5.a
    public void a(q5.b<?> bVar) {
        C0729b c0729b = C0729b.f35584a;
        bVar.a(j.class, c0729b);
        bVar.a(x1.d.class, c0729b);
        e eVar = e.f35597a;
        bVar.a(m.class, eVar);
        bVar.a(g.class, eVar);
        c cVar = c.f35586a;
        bVar.a(k.class, cVar);
        bVar.a(x1.e.class, cVar);
        a aVar = a.f35571a;
        bVar.a(x1.a.class, aVar);
        bVar.a(x1.c.class, aVar);
        d dVar = d.f35589a;
        bVar.a(l.class, dVar);
        bVar.a(x1.f.class, dVar);
        f fVar = f.f35605a;
        bVar.a(o.class, fVar);
        bVar.a(i.class, fVar);
    }
}
