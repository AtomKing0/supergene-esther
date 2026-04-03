package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.ortb.model.m;
import com.moloco.sdk.internal.ortb.model.o;
import com.moloco.sdk.internal.ortb.model.q;
import da.d0;
import da.s1;
import da.w1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class d {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final o f17693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f17694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final q f17695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final m f17696d;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17698b;

        static {
            a aVar = new a();
            f17697a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.BidExt", aVar, 4);
            pluginGeneratedSerialDescriptor.k("player", true);
            pluginGeneratedSerialDescriptor.k("mtid", true);
            pluginGeneratedSerialDescriptor.k("moloco_sdk_events", true);
            pluginGeneratedSerialDescriptor.k("moloco_sdk_click_metadata", true);
            f17698b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d deserialize(@NotNull Decoder decoder) {
            Object objK;
            Object objK2;
            Object objK3;
            int i10;
            Object objK4;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            Object objK5 = null;
            if (cVarB.p()) {
                objK4 = cVarB.k(descriptor, 0, o.a.f17769a, null);
                objK = cVarB.k(descriptor, 1, w1.f24648a, null);
                objK2 = cVarB.k(descriptor, 2, q.a.f17787a, null);
                objK3 = cVarB.k(descriptor, 3, m.a.f17748a, null);
                i10 = 15;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Object objK6 = null;
                Object objK7 = null;
                Object objK8 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK5 = cVarB.k(descriptor, 0, o.a.f17769a, objK5);
                        i11 |= 1;
                    } else if (iO == 1) {
                        objK6 = cVarB.k(descriptor, 1, w1.f24648a, objK6);
                        i11 |= 2;
                    } else if (iO == 2) {
                        objK7 = cVarB.k(descriptor, 2, q.a.f17787a, objK7);
                        i11 |= 4;
                    } else {
                        if (iO != 3) {
                            throw new z9.o(iO);
                        }
                        objK8 = cVarB.k(descriptor, 3, m.a.f17748a, objK8);
                        i11 |= 8;
                    }
                }
                objK = objK6;
                objK2 = objK7;
                objK3 = objK8;
                Object obj = objK5;
                i10 = i11;
                objK4 = obj;
            }
            cVarB.c(descriptor);
            return new d(i10, (o) objK4, (String) objK, (q) objK2, (m) objK3, (s1) null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull d value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            d.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{aa.a.s(o.a.f17769a), aa.a.s(w1.f24648a), aa.a.s(q.a.f17787a), aa.a.s(m.a.f17748a)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17698b;
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
        public final KSerializer<d> serializer() {
            return a.f17697a;
        }

        public b() {
        }
    }

    public d() {
        this((o) null, (String) null, (q) null, (m) null, 15, (kotlin.jvm.internal.k) null);
    }

    public static final /* synthetic */ void b(d dVar, ca.d dVar2, SerialDescriptor serialDescriptor) {
        if (dVar2.z(serialDescriptor, 0) || dVar.f17693a != null) {
            dVar2.h(serialDescriptor, 0, o.a.f17769a, dVar.f17693a);
        }
        if (dVar2.z(serialDescriptor, 1) || dVar.f17694b != null) {
            dVar2.h(serialDescriptor, 1, w1.f24648a, dVar.f17694b);
        }
        if (dVar2.z(serialDescriptor, 2) || dVar.f17695c != null) {
            dVar2.h(serialDescriptor, 2, q.a.f17787a, dVar.f17695c);
        }
        if (!dVar2.z(serialDescriptor, 3) && dVar.f17696d == null) {
            return;
        }
        dVar2.h(serialDescriptor, 3, m.a.f17748a, dVar.f17696d);
    }

    @Nullable
    public final m a() {
        return this.f17696d;
    }

    @Nullable
    public final String c() {
        return this.f17694b;
    }

    @Nullable
    public final o d() {
        return this.f17693a;
    }

    @Nullable
    public final q e() {
        return this.f17695c;
    }

    public /* synthetic */ d(int i10, o oVar, String str, q qVar, m mVar, s1 s1Var) {
        if ((i10 & 1) == 0) {
            this.f17693a = null;
        } else {
            this.f17693a = oVar;
        }
        if ((i10 & 2) == 0) {
            this.f17694b = null;
        } else {
            this.f17694b = str;
        }
        if ((i10 & 4) == 0) {
            this.f17695c = null;
        } else {
            this.f17695c = qVar;
        }
        if ((i10 & 8) == 0) {
            this.f17696d = null;
        } else {
            this.f17696d = mVar;
        }
    }

    public d(@Nullable o oVar, @Nullable String str, @Nullable q qVar, @Nullable m mVar) {
        this.f17693a = oVar;
        this.f17694b = str;
        this.f17695c = qVar;
        this.f17696d = mVar;
    }

    public /* synthetic */ d(o oVar, String str, q qVar, m mVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : oVar, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : qVar, (i10 & 8) != 0 ? null : mVar);
    }
}
