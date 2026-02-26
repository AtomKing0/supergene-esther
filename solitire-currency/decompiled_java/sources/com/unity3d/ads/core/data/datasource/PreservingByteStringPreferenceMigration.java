package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: PreservingByteStringPreferenceMigration.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PreservingByteStringPreferenceMigration implements DataMigration<ByteStringStoreOuterClass.ByteStringStore> {

    @NotNull
    private final Context context;

    @NotNull
    private final GetByteStringData getByteStringData;

    @NotNull
    private final String key;

    @NotNull
    private final String name;

    public PreservingByteStringPreferenceMigration(@NotNull Context context, @NotNull String name, @NotNull String key, @NotNull GetByteStringData getByteStringData) {
        t.i(context, "context");
        t.i(name, "name");
        t.i(key, "key");
        t.i(getByteStringData, "getByteStringData");
        this.context = context;
        this.name = name;
        this.key = key;
        this.getByteStringData = getByteStringData;
    }

    @Override // androidx.datastore.core.DataMigration
    @Nullable
    public Object cleanUp(@NotNull d<? super k0> dVar) {
        return k0.f35197a;
    }

    @Override // androidx.datastore.core.DataMigration
    public /* bridge */ /* synthetic */ Object shouldMigrate(ByteStringStoreOuterClass.ByteStringStore byteStringStore, d dVar) {
        return shouldMigrate2(byteStringStore, (d<? super Boolean>) dVar);
    }

    @Override // androidx.datastore.core.DataMigration
    @Nullable
    public Object migrate(@NotNull ByteStringStoreOuterClass.ByteStringStore byteStringStore, @NotNull d<? super ByteStringStoreOuterClass.ByteStringStore> dVar) {
        if (!byteStringStore.getData().isEmpty()) {
            return byteStringStore;
        }
        String string = this.context.getSharedPreferences(this.name, 0).getString(this.key, null);
        if (string == null || string.length() == 0) {
            return byteStringStore;
        }
        ByteStringStoreOuterClass.ByteStringStore byteStringStoreBuild = ByteStringStoreOuterClass.ByteStringStore.newBuilder().setData(this.getByteStringData.invoke(string)).build();
        t.h(byteStringStoreBuild, "newBuilder()\n           …                 .build()");
        return byteStringStoreBuild;
    }

    @Nullable
    /* JADX INFO: renamed from: shouldMigrate, reason: avoid collision after fix types in other method */
    public Object shouldMigrate2(@NotNull ByteStringStoreOuterClass.ByteStringStore byteStringStore, @NotNull d<? super Boolean> dVar) {
        return b.a(byteStringStore.getData().isEmpty());
    }
}
