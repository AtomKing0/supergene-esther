package com.google.firebase.messaging;

import androidx.core.app.NotificationCompat;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.io.IOException;

/* JADX INFO: compiled from: AutoProtoEncoderDoNotUseEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements q5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q5.a f10337a = new a();

    /* JADX INFO: renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    private static final class C0229a implements p5.d<d6.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0229a f10338a = new C0229a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f10339b = p5.c.a("projectNumber").b(s5.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final p5.c f10340c = p5.c.a("messageId").b(s5.a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final p5.c f10341d = p5.c.a("instanceId").b(s5.a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final p5.c f10342e = p5.c.a("messageType").b(s5.a.b().c(4).a()).a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final p5.c f10343f = p5.c.a("sdkPlatform").b(s5.a.b().c(5).a()).a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final p5.c f10344g = p5.c.a(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME).b(s5.a.b().c(6).a()).a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final p5.c f10345h = p5.c.a("collapseKey").b(s5.a.b().c(7).a()).a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final p5.c f10346i = p5.c.a("priority").b(s5.a.b().c(8).a()).a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final p5.c f10347j = p5.c.a("ttl").b(s5.a.b().c(9).a()).a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final p5.c f10348k = p5.c.a("topic").b(s5.a.b().c(10).a()).a();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final p5.c f10349l = p5.c.a("bulkId").b(s5.a.b().c(11).a()).a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final p5.c f10350m = p5.c.a(NotificationCompat.CATEGORY_EVENT).b(s5.a.b().c(12).a()).a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final p5.c f10351n = p5.c.a("analyticsLabel").b(s5.a.b().c(13).a()).a();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final p5.c f10352o = p5.c.a("campaignId").b(s5.a.b().c(14).a()).a();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final p5.c f10353p = p5.c.a("composerLabel").b(s5.a.b().c(15).a()).a();

        private C0229a() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d6.a aVar, p5.e eVar) throws IOException {
            eVar.b(f10339b, aVar.l());
            eVar.d(f10340c, aVar.h());
            eVar.d(f10341d, aVar.g());
            eVar.d(f10342e, aVar.i());
            eVar.d(f10343f, aVar.m());
            eVar.d(f10344g, aVar.j());
            eVar.d(f10345h, aVar.d());
            eVar.c(f10346i, aVar.k());
            eVar.c(f10347j, aVar.o());
            eVar.d(f10348k, aVar.n());
            eVar.b(f10349l, aVar.b());
            eVar.d(f10350m, aVar.f());
            eVar.d(f10351n, aVar.a());
            eVar.b(f10352o, aVar.c());
            eVar.d(f10353p, aVar.e());
        }
    }

    /* JADX INFO: compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    private static final class b implements p5.d<d6.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f10354a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f10355b = p5.c.a("messagingClientEvent").b(s5.a.b().c(1).a()).a();

        private b() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d6.b bVar, p5.e eVar) throws IOException {
            eVar.d(f10355b, bVar.a());
        }
    }

    /* JADX INFO: compiled from: AutoProtoEncoderDoNotUseEncoder.java */
    private static final class c implements p5.d<l0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f10356a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p5.c f10357b = p5.c.d("messagingClientEventExtension");

        private c() {
        }

        @Override // p5.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(l0 l0Var, p5.e eVar) throws IOException {
            eVar.d(f10357b, l0Var.b());
        }
    }

    private a() {
    }

    @Override // q5.a
    public void a(q5.b<?> bVar) {
        bVar.a(l0.class, c.f10356a);
        bVar.a(d6.b.class, b.f10354a);
        bVar.a(d6.a.class, C0229a.f10338a);
    }
}
