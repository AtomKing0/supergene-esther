package com.unity3d.ads.core.data.manager;

import android.content.Context;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidStorageManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidStorageManager implements StorageManager {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String KEY_INITIALIZED = "configuration.hasInitialized";

    /* JADX INFO: compiled from: AndroidStorageManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void addStorageLocation(@NotNull StorageManager.StorageType type, @NotNull String fileName) {
        t.i(type, "type");
        t.i(fileName, "fileName");
        com.unity3d.services.core.device.StorageManager.addStorageLocation(type, fileName);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    @NotNull
    public Storage getStorage(@NotNull StorageManager.StorageType type) {
        t.i(type, "type");
        Storage storage = com.unity3d.services.core.device.StorageManager.getStorage(type);
        t.h(storage, "getStorage(type)");
        return storage;
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void hasInitialized() {
        Storage storage = getStorage(StorageManager.StorageType.PRIVATE);
        storage.set(KEY_INITIALIZED, Boolean.TRUE);
        storage.writeStorage();
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public boolean hasStorage(@NotNull StorageManager.StorageType type) {
        t.i(type, "type");
        return com.unity3d.services.core.device.StorageManager.hasStorage(type);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public boolean init(@NotNull Context context) {
        t.i(context, "context");
        return com.unity3d.services.core.device.StorageManager.init(context);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void initStorage(@NotNull StorageManager.StorageType type) {
        t.i(type, "type");
        com.unity3d.services.core.device.StorageManager.initStorage(type);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void removeStorage(@NotNull StorageManager.StorageType type) {
        t.i(type, "type");
        com.unity3d.services.core.device.StorageManager.removeStorage(type);
    }
}
