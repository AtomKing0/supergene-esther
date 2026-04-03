package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import da.d0;
import da.i1;
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
public final class a {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f17680c;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.a$a, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static final class C0307a implements d0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0307a f17681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17682b;

        static {
            C0307a c0307a = new C0307a();
            f17681a = c0307a;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.AutoStore", c0307a, 3);
            pluginGeneratedSerialDescriptor.k("enabled", false);
            pluginGeneratedSerialDescriptor.k("on_skip", true);
            pluginGeneratedSerialDescriptor.k("event_link", true);
            f17682b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a deserialize(@NotNull Decoder decoder) {
            boolean z10;
            boolean z11;
            int i10;
            Object objK;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            if (cVarB.p()) {
                boolean zC = cVarB.C(descriptor, 0);
                boolean zC2 = cVarB.C(descriptor, 1);
                objK = cVarB.k(descriptor, 2, w1.f24648a, null);
                z10 = zC;
                z11 = zC2;
                i10 = 7;
            } else {
                boolean z12 = true;
                boolean zC3 = false;
                int i11 = 0;
                Object objK2 = null;
                boolean zC4 = false;
                while (z12) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        z12 = false;
                    } else if (iO == 0) {
                        zC3 = cVarB.C(descriptor, 0);
                        i11 |= 1;
                    } else if (iO == 1) {
                        zC4 = cVarB.C(descriptor, 1);
                        i11 |= 2;
                    } else {
                        if (iO != 2) {
                            throw new z9.o(iO);
                        }
                        objK2 = cVarB.k(descriptor, 2, w1.f24648a, objK2);
                        i11 |= 4;
                    }
                }
                z10 = zC3;
                z11 = zC4;
                i10 = i11;
                objK = objK2;
            }
            cVarB.c(descriptor);
            return new a(i10, z10, z11, (String) objK, (s1) null);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull a value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            a.a(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            da.h hVar = da.h.f24574a;
            return new KSerializer[]{hVar, hVar, aa.a.s(w1.f24648a)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17682b;
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
        public final KSerializer<a> serializer() {
            return C0307a.f17681a;
        }

        public b() {
        }
    }

    public /* synthetic */ a(int i10, boolean z10, boolean z11, String str, s1 s1Var) {
        if (1 != (i10 & 1)) {
            i1.a(i10, 1, C0307a.f17681a.getDescriptor());
        }
        this.f17678a = z10;
        if ((i10 & 2) == 0) {
            this.f17679b = true;
        } else {
            this.f17679b = z11;
        }
        if ((i10 & 4) == 0) {
            this.f17680c = null;
        } else {
            this.f17680c = str;
        }
    }

    public static final /* synthetic */ void a(a aVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        dVar.x(serialDescriptor, 0, aVar.f17678a);
        if (dVar.z(serialDescriptor, 1) || !aVar.f17679b) {
            dVar.x(serialDescriptor, 1, aVar.f17679b);
        }
        if (!dVar.z(serialDescriptor, 2) && aVar.f17680c == null) {
            return;
        }
        dVar.h(serialDescriptor, 2, w1.f24648a, aVar.f17680c);
    }

    public final boolean b() {
        return this.f17678a;
    }

    @Nullable
    public final String c() {
        return this.f17680c;
    }

    public final boolean d() {
        return this.f17679b;
    }

    public a(boolean z10, boolean z11, @Nullable String str) {
        this.f17678a = z10;
        this.f17679b = z11;
        this.f17680c = str;
    }

    public /* synthetic */ a(boolean z10, boolean z11, String str, int i10, kotlin.jvm.internal.k kVar) {
        this(z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? null : str);
    }
}
