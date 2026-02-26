package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
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
public final class b {

    @NotNull
    public static final C0308b Companion = new C0308b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f17683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f17684b;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17686b;

        static {
            a aVar = new a();
            f17685a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.BannerClickMetaData", aVar, 2);
            pluginGeneratedSerialDescriptor.k("click_tracking", true);
            pluginGeneratedSerialDescriptor.k("click_through", true);
            f17686b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b deserialize(@NotNull Decoder decoder) {
            Object objK;
            int i10;
            Object objK2;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            s1 s1Var = null;
            if (cVarB.p()) {
                w1 w1Var = w1.f24648a;
                objK2 = cVarB.k(descriptor, 0, w1Var, null);
                objK = cVarB.k(descriptor, 1, w1Var, null);
                i10 = 3;
            } else {
                boolean z10 = true;
                int i11 = 0;
                objK = null;
                Object objK3 = null;
                while (z10) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        z10 = false;
                    } else if (iO == 0) {
                        objK3 = cVarB.k(descriptor, 0, w1.f24648a, objK3);
                        i11 |= 1;
                    } else {
                        if (iO != 1) {
                            throw new z9.o(iO);
                        }
                        objK = cVarB.k(descriptor, 1, w1.f24648a, objK);
                        i11 |= 2;
                    }
                }
                i10 = i11;
                objK2 = objK3;
            }
            cVarB.c(descriptor);
            return new b(i10, (String) objK2, (String) objK, s1Var);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull b value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            b.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            w1 w1Var = w1.f24648a;
            return new KSerializer[]{aa.a.s(w1Var), aa.a.s(w1Var)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17686b;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ortb.model.b$b, reason: collision with other inner class name */
    public static final class C0308b {
        public /* synthetic */ C0308b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<b> serializer() {
            return a.f17685a;
        }

        public C0308b() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this((String) null, (String) (0 == true ? 1 : 0), 3, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
    }

    public static final /* synthetic */ void b(b bVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        if (dVar.z(serialDescriptor, 0) || bVar.f17683a != null) {
            dVar.h(serialDescriptor, 0, w1.f24648a, bVar.f17683a);
        }
        if (!dVar.z(serialDescriptor, 1) && bVar.f17684b == null) {
            return;
        }
        dVar.h(serialDescriptor, 1, w1.f24648a, bVar.f17684b);
    }

    @Nullable
    public final String a() {
        return this.f17684b;
    }

    @Nullable
    public final String c() {
        return this.f17683a;
    }

    public /* synthetic */ b(int i10, String str, String str2, s1 s1Var) {
        if ((i10 & 1) == 0) {
            this.f17683a = null;
        } else {
            this.f17683a = str;
        }
        if ((i10 & 2) == 0) {
            this.f17684b = null;
        } else {
            this.f17684b = str2;
        }
    }

    public b(@Nullable String str, @Nullable String str2) {
        this.f17683a = str;
        this.f17684b = str2;
    }

    public /* synthetic */ b(String str, String str2, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
