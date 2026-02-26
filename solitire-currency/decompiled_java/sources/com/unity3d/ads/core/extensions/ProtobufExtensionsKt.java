package com.unity3d.ads.core.extensions;

import android.util.Base64;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.d;

/* JADX INFO: compiled from: ProtobufExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ProtobufExtensionsKt {
    @NotNull
    public static final ByteString fromBase64(@NotNull String str) {
        t.i(str, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(Base64.decode(str, 2));
        t.h(byteStringCopyFrom, "copyFrom(android.util.Ba…oid.util.Base64.NO_WRAP))");
        return byteStringCopyFrom;
    }

    @NotNull
    public static final String toBase64(@NotNull ByteString byteString) {
        t.i(byteString, "<this>");
        String strEncodeToString = Base64.encodeToString(byteString.toByteArray(), 2);
        t.h(strEncodeToString, "encodeToString(this.toBy…roid.util.Base64.NO_WRAP)");
        return strEncodeToString;
    }

    @NotNull
    public static final ByteString toByteString(@NotNull UUID uuid) {
        t.i(uuid, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(ByteBuffer.wrap(new byte[16]).order(ByteOrder.BIG_ENDIAN).putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits()).array());
        t.h(byteStringCopyFrom, "copyFrom(bytes.array())");
        return byteStringCopyFrom;
    }

    @NotNull
    public static final ByteString toISO8859ByteString(@NotNull String str) {
        t.i(str, "<this>");
        byte[] bytes = str.getBytes(d.f32957g);
        t.h(bytes, "this as java.lang.String).getBytes(charset)");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bytes);
        t.h(byteStringCopyFrom, "copyFrom(this.toByteArray(Charsets.ISO_8859_1))");
        return byteStringCopyFrom;
    }

    @NotNull
    public static final String toISO8859String(@NotNull ByteString byteString) {
        t.i(byteString, "<this>");
        String string = byteString.toString(d.f32957g);
        t.h(string, "this.toString(Charsets.ISO_8859_1)");
        return string;
    }

    @NotNull
    public static final UUID toUUID(@NotNull ByteString byteString) {
        t.i(byteString, "<this>");
        ByteBuffer byteBufferAsReadOnlyByteBuffer = byteString.asReadOnlyByteBuffer();
        t.h(byteBufferAsReadOnlyByteBuffer, "this.asReadOnlyByteBuffer()");
        if (byteBufferAsReadOnlyByteBuffer.remaining() == 36) {
            UUID uuidFromString = UUID.fromString(byteString.toStringUtf8());
            t.h(uuidFromString, "fromString(uuidString)");
            return uuidFromString;
        }
        if (byteBufferAsReadOnlyByteBuffer.remaining() == 16) {
            return new UUID(byteBufferAsReadOnlyByteBuffer.getLong(), byteBufferAsReadOnlyByteBuffer.getLong());
        }
        throw new IllegalArgumentException("Expected 16 byte ByteString or UUID string");
    }
}
