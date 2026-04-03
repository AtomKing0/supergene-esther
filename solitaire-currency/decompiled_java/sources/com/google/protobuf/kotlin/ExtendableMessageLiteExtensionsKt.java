package com.google.protobuf.kotlin;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessageLite;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExtendableMessageLiteExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExtendableMessageLiteExtensionsKt {
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MorBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>> boolean contains(@NotNull MorBT morbt, @NotNull ExtensionLite<M, ?> extension) {
        t.i(morbt, "<this>");
        t.i(extension, "extension");
        return morbt.hasExtension(extension);
    }

    @NotNull
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MOrBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>, T> T get(@NotNull MOrBT morbt, @NotNull ExtensionLite<M, T> extension) {
        t.i(morbt, "<this>");
        t.i(extension, "extension");
        T t10 = (T) morbt.getExtension(extension);
        t.h(t10, "getExtension(extension)");
        return t10;
    }

    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, B>, B extends GeneratedMessageLite.ExtendableBuilder<M, B>, T> void set(@NotNull B b10, @NotNull ExtensionLite<M, T> extension, @NotNull T value) {
        t.i(b10, "<this>");
        t.i(extension, "extension");
        t.i(value, "value");
        b10.setExtension(extension, value);
    }
}
