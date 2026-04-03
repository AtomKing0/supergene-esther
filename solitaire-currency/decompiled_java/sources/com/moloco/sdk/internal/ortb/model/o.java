package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.ortb.model.a;
import com.moloco.sdk.internal.ortb.model.g;
import com.moloco.sdk.internal.ortb.model.i;
import com.moloco.sdk.internal.ortb.model.j;
import com.moloco.sdk.internal.ortb.model.n;
import com.moloco.sdk.internal.ortb.model.p;
import com.moloco.sdk.internal.ortb.model.s;
import com.moloco.sdk.internal.ortb.model.t;
import da.d0;
import da.i1;
import da.s1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class o {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final s f17759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final s f17760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final p f17761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final n f17762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final g f17763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.internal.ortb.model.a f17765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final t f17766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final j f17767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final i f17768j;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17770b;

        static {
            a aVar = new a();
            f17769a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Player", aVar, 10);
            pluginGeneratedSerialDescriptor.k("skip", true);
            pluginGeneratedSerialDescriptor.k("close", false);
            pluginGeneratedSerialDescriptor.k("progress_bar", true);
            pluginGeneratedSerialDescriptor.k("mute", false);
            pluginGeneratedSerialDescriptor.k("cta", true);
            pluginGeneratedSerialDescriptor.k("is_all_area_clickable", false);
            pluginGeneratedSerialDescriptor.k("auto_store", true);
            pluginGeneratedSerialDescriptor.k("vast_privacy_icon", true);
            pluginGeneratedSerialDescriptor.k("dec", true);
            pluginGeneratedSerialDescriptor.k("countdown_timer", true);
            f17770b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object objK3;
            Object objK4;
            Object objK5;
            Object objY;
            Object objK6;
            int i10;
            Object objK7;
            boolean z10;
            Object objY2;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i11 = 9;
            int i12 = 8;
            if (cVarB.p()) {
                s.a aVar = s.a.f17800a;
                objK7 = cVarB.k(descriptor, 0, aVar, null);
                objY2 = cVarB.y(descriptor, 1, aVar, null);
                objK6 = cVarB.k(descriptor, 2, p.a.f17775a, null);
                objY = cVarB.y(descriptor, 3, n.a.f17757a, null);
                objK5 = cVarB.k(descriptor, 4, g.a.f17710a, null);
                boolean zC = cVarB.C(descriptor, 5);
                objK3 = cVarB.k(descriptor, 6, a.C0307a.f17681a, null);
                objK4 = cVarB.k(descriptor, 7, t.a.f17805a, null);
                objK2 = cVarB.k(descriptor, 8, j.a.f17732a, null);
                objK = cVarB.k(descriptor, 9, i.a.f17722a, null);
                i10 = 1023;
                z10 = zC;
            } else {
                boolean z11 = true;
                boolean zC2 = false;
                Object objK8 = null;
                Object objK9 = null;
                Object objK10 = null;
                Object objK11 = null;
                Object objK12 = null;
                Object objY3 = null;
                Object objK13 = null;
                Object objY4 = null;
                Object objK14 = null;
                int i13 = 0;
                while (z11) {
                    int iO = cVarB.o(descriptor);
                    switch (iO) {
                        case -1:
                            z11 = false;
                            i12 = 8;
                            break;
                        case 0:
                            objK13 = cVarB.k(descriptor, 0, s.a.f17800a, objK13);
                            i13 |= 1;
                            i11 = 9;
                            i12 = 8;
                            break;
                        case 1:
                            objY4 = cVarB.y(descriptor, 1, s.a.f17800a, objY4);
                            i13 |= 2;
                            i11 = 9;
                            i12 = 8;
                            break;
                        case 2:
                            objK14 = cVarB.k(descriptor, 2, p.a.f17775a, objK14);
                            i13 |= 4;
                            i11 = 9;
                            i12 = 8;
                            break;
                        case 3:
                            objY3 = cVarB.y(descriptor, 3, n.a.f17757a, objY3);
                            i13 |= 8;
                            i11 = 9;
                            i12 = 8;
                            break;
                        case 4:
                            objK12 = cVarB.k(descriptor, 4, g.a.f17710a, objK12);
                            i13 |= 16;
                            i11 = 9;
                            i12 = 8;
                            break;
                        case 5:
                            zC2 = cVarB.C(descriptor, 5);
                            i13 |= 32;
                            i11 = 9;
                            break;
                        case 6:
                            objK10 = cVarB.k(descriptor, 6, a.C0307a.f17681a, objK10);
                            i13 |= 64;
                            i11 = 9;
                            break;
                        case 7:
                            objK11 = cVarB.k(descriptor, 7, t.a.f17805a, objK11);
                            i13 |= 128;
                            i11 = 9;
                            break;
                        case 8:
                            objK9 = cVarB.k(descriptor, i12, j.a.f17732a, objK9);
                            i13 |= 256;
                            break;
                        case 9:
                            objK8 = cVarB.k(descriptor, i11, i.a.f17722a, objK8);
                            i13 |= 512;
                            break;
                        default:
                            throw new z9.o(iO);
                    }
                }
                objK = objK8;
                objK2 = objK9;
                objK3 = objK10;
                objK4 = objK11;
                objK5 = objK12;
                objY = objY3;
                objK6 = objK14;
                i10 = i13;
                objK7 = objK13;
                z10 = zC2;
                objY2 = objY4;
            }
            cVarB.c(descriptor);
            return new o(i10, (s) objK7, (s) objY2, (p) objK6, (n) objY, (g) objK5, z10, (com.moloco.sdk.internal.ortb.model.a) objK3, (t) objK4, (j) objK2, (i) objK, (s1) null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull o value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            o.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            s.a aVar = s.a.f17800a;
            return new KSerializer[]{aa.a.s(aVar), aVar, aa.a.s(p.a.f17775a), n.a.f17757a, aa.a.s(g.a.f17710a), da.h.f24574a, aa.a.s(a.C0307a.f17681a), aa.a.s(t.a.f17805a), aa.a.s(j.a.f17732a), aa.a.s(i.a.f17722a)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17770b;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<o> serializer() {
            return a.f17769a;
        }

        public b() {
        }
    }

    public /* synthetic */ o(int i10, s sVar, s sVar2, p pVar, n nVar, g gVar, boolean z10, com.moloco.sdk.internal.ortb.model.a aVar, t tVar, j jVar, i iVar, s1 s1Var) {
        if (42 != (i10 & 42)) {
            i1.a(i10, 42, a.f17769a.getDescriptor());
        }
        if ((i10 & 1) == 0) {
            this.f17759a = null;
        } else {
            this.f17759a = sVar;
        }
        this.f17760b = sVar2;
        if ((i10 & 4) == 0) {
            this.f17761c = null;
        } else {
            this.f17761c = pVar;
        }
        this.f17762d = nVar;
        if ((i10 & 16) == 0) {
            this.f17763e = null;
        } else {
            this.f17763e = gVar;
        }
        this.f17764f = z10;
        if ((i10 & 64) == 0) {
            this.f17765g = null;
        } else {
            this.f17765g = aVar;
        }
        if ((i10 & 128) == 0) {
            this.f17766h = null;
        } else {
            this.f17766h = tVar;
        }
        if ((i10 & 256) == 0) {
            this.f17767i = null;
        } else {
            this.f17767i = jVar;
        }
        if ((i10 & 512) == 0) {
            this.f17768j = null;
        } else {
            this.f17768j = iVar;
        }
    }

    public static final /* synthetic */ void b(o oVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        if (dVar.z(serialDescriptor, 0) || oVar.f17759a != null) {
            dVar.h(serialDescriptor, 0, s.a.f17800a, oVar.f17759a);
        }
        dVar.j(serialDescriptor, 1, s.a.f17800a, oVar.f17760b);
        if (dVar.z(serialDescriptor, 2) || oVar.f17761c != null) {
            dVar.h(serialDescriptor, 2, p.a.f17775a, oVar.f17761c);
        }
        dVar.j(serialDescriptor, 3, n.a.f17757a, oVar.f17762d);
        if (dVar.z(serialDescriptor, 4) || oVar.f17763e != null) {
            dVar.h(serialDescriptor, 4, g.a.f17710a, oVar.f17763e);
        }
        dVar.x(serialDescriptor, 5, oVar.f17764f);
        if (dVar.z(serialDescriptor, 6) || oVar.f17765g != null) {
            dVar.h(serialDescriptor, 6, a.C0307a.f17681a, oVar.f17765g);
        }
        if (dVar.z(serialDescriptor, 7) || oVar.f17766h != null) {
            dVar.h(serialDescriptor, 7, t.a.f17805a, oVar.f17766h);
        }
        if (dVar.z(serialDescriptor, 8) || oVar.f17767i != null) {
            dVar.h(serialDescriptor, 8, j.a.f17732a, oVar.f17767i);
        }
        if (!dVar.z(serialDescriptor, 9) && oVar.f17768j == null) {
            return;
        }
        dVar.h(serialDescriptor, 9, i.a.f17722a, oVar.f17768j);
    }

    @Nullable
    public final com.moloco.sdk.internal.ortb.model.a a() {
        return this.f17765g;
    }

    @NotNull
    public final s c() {
        return this.f17760b;
    }

    @Nullable
    public final i d() {
        return this.f17768j;
    }

    @Nullable
    public final g e() {
        return this.f17763e;
    }

    @Nullable
    public final j f() {
        return this.f17767i;
    }

    @NotNull
    public final n g() {
        return this.f17762d;
    }

    @Nullable
    public final p h() {
        return this.f17761c;
    }

    @Nullable
    public final s i() {
        return this.f17759a;
    }

    @Nullable
    public final t j() {
        return this.f17766h;
    }

    public final boolean k() {
        return this.f17764f;
    }

    public o(@Nullable s sVar, @NotNull s close, @Nullable p pVar, @NotNull n mute, @Nullable g gVar, boolean z10, @Nullable com.moloco.sdk.internal.ortb.model.a aVar, @Nullable t tVar, @Nullable j jVar, @Nullable i iVar) {
        kotlin.jvm.internal.t.i(close, "close");
        kotlin.jvm.internal.t.i(mute, "mute");
        this.f17759a = sVar;
        this.f17760b = close;
        this.f17761c = pVar;
        this.f17762d = mute;
        this.f17763e = gVar;
        this.f17764f = z10;
        this.f17765g = aVar;
        this.f17766h = tVar;
        this.f17767i = jVar;
        this.f17768j = iVar;
    }

    public /* synthetic */ o(s sVar, s sVar2, p pVar, n nVar, g gVar, boolean z10, com.moloco.sdk.internal.ortb.model.a aVar, t tVar, j jVar, i iVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : sVar, sVar2, (i10 & 4) != 0 ? null : pVar, nVar, (i10 & 16) != 0 ? null : gVar, z10, (i10 & 64) != 0 ? null : aVar, (i10 & 128) != 0 ? null : tVar, (i10 & 256) != 0 ? null : jVar, (i10 & 512) != 0 ? null : iVar);
    }
}
