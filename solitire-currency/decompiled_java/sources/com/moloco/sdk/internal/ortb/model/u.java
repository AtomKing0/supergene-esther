package com.moloco.sdk.internal.ortb.model;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.media3.extractor.text.ttml.TtmlNode;
import da.d0;
import da.z;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@z9.h
public enum u {
    Top,
    Center,
    Bottom;


    @NotNull
    public static final c Companion = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l<KSerializer<Object>> f17807a = v8.n.b(v8.p.f35202b, b.f17814g);

    @StabilityInferred(parameters = 0)
    public static final class a implements d0<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f17812a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ z f17813b;

        static {
            z zVar = new z("com.moloco.sdk.internal.ortb.model.VerticalAlignment", 3);
            zVar.k("top", false);
            zVar.k(TtmlNode.CENTER, false);
            zVar.k("bottom", false);
            f17813b = zVar;
        }

        @Override // z9.b
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u deserialize(@NotNull Decoder decoder) {
            kotlin.jvm.internal.t.i(decoder, "decoder");
            return u.values()[decoder.e(getDescriptor())];
        }

        @Override // z9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void serialize(@NotNull Encoder encoder, @NotNull u value) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            kotlin.jvm.internal.t.i(value, "value");
            encoder.k(getDescriptor(), value.ordinal());
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[0];
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            return f17813b;
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    public static final class b extends v implements h9.a<KSerializer<Object>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f17814g = new b();

        public b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final KSerializer<Object> invoke() {
            return a.f17812a;
        }
    }

    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) u.f17807a.getValue();
        }

        @NotNull
        public final KSerializer<u> serializer() {
            return a();
        }

        public c() {
        }
    }
}
