package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import da.d0;
import da.e2;
import da.s1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public final class k {

    @NotNull
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final c0 f17734a;

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PluginGeneratedSerialDescriptor f17736b;

        static {
            a aVar = new a();
            f17735a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DECSkipClose", aVar, 1);
            pluginGeneratedSerialDescriptor.k("delay_seconds", true);
            f17736b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k deserialize(@NotNull Decoder decoder) {
            Object objK;
            kotlin.jvm.internal.t.i(decoder, "decoder");
            SerialDescriptor descriptor = getDescriptor();
            ca.c cVarB = decoder.b(descriptor);
            int i10 = 1;
            s1 s1Var = null;
            Object[] objArr = 0;
            if (cVarB.p()) {
                objK = cVarB.k(descriptor, 0, e2.f24564a, null);
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
                        objK = cVarB.k(descriptor, 0, e2.f24564a, objK);
                        i11 |= 1;
                    }
                }
                i10 = i11;
            }
            cVarB.c(descriptor);
            return new k(i10, (c0) objK, s1Var, objArr == true ? 1 : 0);
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull k value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            SerialDescriptor descriptor = getDescriptor();
            ca.d dVarB = encoder.b(descriptor);
            k.b(value, dVarB, descriptor);
            dVarB.c(descriptor);
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{aa.a.s(e2.f24564a)};
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17736b;
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
        public final KSerializer<k> serializer() {
            return a.f17735a;
        }

        public b() {
        }
    }

    public /* synthetic */ k(int i10, c0 c0Var, s1 s1Var, kotlin.jvm.internal.k kVar) {
        this(i10, c0Var, s1Var);
    }

    public static final /* synthetic */ void b(k kVar, ca.d dVar, SerialDescriptor serialDescriptor) {
        if (!dVar.z(serialDescriptor, 0) && kVar.f17734a == null) {
            return;
        }
        dVar.h(serialDescriptor, 0, e2.f24564a, kVar.f17734a);
    }

    @Nullable
    public final c0 a() {
        return this.f17734a;
    }

    public k(int i10, c0 c0Var, s1 s1Var) {
        if ((i10 & 1) == 0) {
            this.f17734a = null;
        } else {
            this.f17734a = c0Var;
        }
    }
}
