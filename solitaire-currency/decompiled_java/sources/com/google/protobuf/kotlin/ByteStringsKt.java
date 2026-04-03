package com.google.protobuf.kotlin;

import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ByteStrings.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ByteStringsKt {
    public static final byte get(@NotNull ByteString byteString, int i10) {
        t.i(byteString, "<this>");
        return byteString.byteAt(i10);
    }

    @NotNull
    public static final ByteString plus(@NotNull ByteString byteString, @NotNull ByteString other) {
        t.i(byteString, "<this>");
        t.i(other, "other");
        ByteString byteStringConcat = byteString.concat(other);
        t.h(byteStringConcat, "concat(other)");
        return byteStringConcat;
    }

    @NotNull
    public static final ByteString toByteString(@NotNull byte[] bArr) {
        t.i(bArr, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(bArr);
        t.h(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }

    @NotNull
    public static final ByteString toByteStringUtf8(@NotNull String str) {
        t.i(str, "<this>");
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8(str);
        t.h(byteStringCopyFromUtf8, "copyFromUtf8(this)");
        return byteStringCopyFromUtf8;
    }

    @NotNull
    public static final ByteString toByteString(@NotNull ByteBuffer byteBuffer) {
        t.i(byteBuffer, "<this>");
        ByteString byteStringCopyFrom = ByteString.copyFrom(byteBuffer);
        t.h(byteStringCopyFrom, "copyFrom(this)");
        return byteStringCopyFrom;
    }
}
