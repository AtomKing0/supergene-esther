package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.ortb.model.b;
import da.d0;
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
public final class m {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.internal.ortb.model.b f17747a;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17749b;

        static {
            a aVar = new a();
            f17748a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.MolocoSDKClickMetaData", aVar, 1);
            pluginGeneratedSerialDescriptor.k("banner", true);
            f17749b = pluginGeneratedSerialDescriptor;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m deserialize(@NotNull Decoder decoder) {
            Object objK;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i10 = 1;
            s1 s1Var = null;
            if (cVarB.p()) {
                objK = cVarB.k(descriptor, 0, b.a.f17685a, null);
            } else {
                int i11 = 0;
                objK = null;
                while (i10 != 0) {
                    int iO = cVarB.o(descriptor);
                    if (iO == -1) {
                        i10 = 0;
                    } else {
                        if (iO != 0) {
                            throw new z9.o(iO);
                        }
                        objK = cVarB.k(descriptor, 0, b.a.f17685a, objK);
                        i11 |= 1;
                    }
                }
                i10 = i11;
            }
            cVarB.c(descriptor);
            return new m(i10, (com.moloco.sdk.internal.ortb.model.b) objK, s1Var);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull m value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            m.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{aa.a.s(b.a.f17685a)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17749b;
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
        public final KSerializer<m> serializer() {
            return a.f17748a;
        }

        public b() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m() {
        this((com.moloco.sdk.internal.ortb.model.b) null, 1, (kotlin.jvm.internal.k) (0 == true ? 1 : 0));
    }

    public static final /* synthetic */ void b(m mVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        if (!dVar.z(serialDescriptor, 0) && mVar.f17747a == null) {
            return;
        }
        dVar.h(serialDescriptor, 0, b.a.f17685a, mVar.f17747a);
    }

    @Nullable
    public final com.moloco.sdk.internal.ortb.model.b a() {
        return this.f17747a;
    }

    public /* synthetic */ m(int i10, com.moloco.sdk.internal.ortb.model.b bVar, s1 s1Var) {
        if ((i10 & 1) == 0) {
            this.f17747a = null;
        } else {
            this.f17747a = bVar;
        }
    }

    public m(@Nullable com.moloco.sdk.internal.ortb.model.b bVar) {
        this.f17747a = bVar;
    }

    public /* synthetic */ m(com.moloco.sdk.internal.ortb.model.b bVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : bVar);
    }
}
