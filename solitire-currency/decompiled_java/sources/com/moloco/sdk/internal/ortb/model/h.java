package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import ba.e;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements KSerializer<Color> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f17712a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final SerialDescriptor f17713b = ba.h.a("Color", e.i.f2297a);

    public long a(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return ColorKt.Color(android.graphics.Color.parseColor(decoder.z()));
    }

    public void b(@NotNull Encoder encoder, long j10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        throw new v8.r("Color encoding is not supported");
    }

    @Override // z9.b
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Color.m1588boximpl(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f17713b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Color) obj).m1608unboximpl());
    }
}
