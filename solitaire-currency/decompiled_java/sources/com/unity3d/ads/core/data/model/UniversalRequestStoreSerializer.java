package com.unity3d.ads.core.data.model;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import com.google.protobuf.InvalidProtocolBufferException;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: UniversalRequestStoreSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalRequestStoreSerializer implements Serializer<UniversalRequestStoreOuterClass.UniversalRequestStore> {

    @NotNull
    private final UniversalRequestStoreOuterClass.UniversalRequestStore defaultValue;

    public UniversalRequestStoreSerializer() {
        UniversalRequestStoreOuterClass.UniversalRequestStore defaultInstance = UniversalRequestStoreOuterClass.UniversalRequestStore.getDefaultInstance();
        t.h(defaultInstance, "getDefaultInstance()");
        this.defaultValue = defaultInstance;
    }

    @Override // androidx.datastore.core.Serializer
    @Nullable
    public Object readFrom(@NotNull InputStream inputStream, @NotNull d<? super UniversalRequestStoreOuterClass.UniversalRequestStore> dVar) throws IOException {
        try {
            UniversalRequestStoreOuterClass.UniversalRequestStore from = UniversalRequestStoreOuterClass.UniversalRequestStore.parseFrom(inputStream);
            t.h(from, "parseFrom(input)");
            return from;
        } catch (InvalidProtocolBufferException e10) {
            throw new CorruptionException("Cannot read proto.", e10);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public /* bridge */ /* synthetic */ Object writeTo(UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, OutputStream outputStream, d dVar) {
        return writeTo2(universalRequestStore, outputStream, (d<? super k0>) dVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.Serializer
    @NotNull
    public UniversalRequestStoreOuterClass.UniversalRequestStore getDefaultValue() {
        return this.defaultValue;
    }

    @Nullable
    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(@NotNull UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, @NotNull OutputStream outputStream, @NotNull d<? super k0> dVar) throws IOException {
        universalRequestStore.writeTo(outputStream);
        return k0.f35197a;
    }
}
