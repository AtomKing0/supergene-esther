package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import h9.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p9.d;
import s9.o0;
import s9.y;
import v8.k0;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Storage extends JsonStorage {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final y<List<l<StorageEventInfo, k0>>> onStorageEventCallbacks = o0.a(v.l());

    @NotNull
    private final String _targetFileName;

    @NotNull
    private final StorageManager.StorageType type;

    /* JADX INFO: compiled from: Storage.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final void addStorageEventCallback(@NotNull l<? super StorageEventInfo, k0> callback) {
            Object value;
            t.i(callback, "callback");
            y yVar = Storage.onStorageEventCallbacks;
            do {
                value = yVar.getValue();
            } while (!yVar.d(value, d0.B0((List) value, callback)));
        }

        public final void removeStorageEventCallback(@NotNull l<? super StorageEventInfo, k0> callback) {
            Object value;
            t.i(callback, "callback");
            y yVar = Storage.onStorageEventCallbacks;
            do {
                value = yVar.getValue();
            } while (!yVar.d(value, d0.y0((List) value, callback)));
        }
    }

    public Storage(@NotNull String _targetFileName, @NotNull StorageManager.StorageType type) {
        t.i(_targetFileName, "_targetFileName");
        t.i(type, "type");
        this._targetFileName = _targetFileName;
        this.type = type;
    }

    public final synchronized boolean clearStorage() {
        clearData();
        return new File(this._targetFileName).delete();
    }

    @NotNull
    public final StorageManager.StorageType getType() {
        return this.type;
    }

    public final synchronized boolean initStorage() {
        readStorage();
        super.initData();
        return true;
    }

    public final synchronized boolean readStorage() {
        byte[] fileBytes;
        boolean z10 = true;
        try {
            try {
                fileBytes = Utilities.readFileBytes(new File(this._targetFileName));
            } catch (FileNotFoundException e10) {
                DeviceLog.debug("Storage JSON file not found in local cache:", e10);
            }
        } catch (Exception e11) {
            DeviceLog.debug("Failed to read storage JSON file:", e11);
        }
        if (fileBytes == null) {
            return false;
        }
        setData(new JSONObject(new String(fileBytes, d.f32952b)));
        return z10;
        z10 = false;
        return z10;
    }

    public final synchronized void sendEvent(@Nullable StorageEvent storageEvent, @Nullable Object obj) {
        List<l<StorageEventInfo, k0>> value = onStorageEventCallbacks.getValue();
        if (!(!value.isEmpty())) {
            if (!(WebViewApp.getCurrentApp() != null ? WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORAGE, storageEvent, this.type.name(), obj) : false)) {
                DeviceLog.debug("Couldn't send storage event to WebApp");
            }
            return;
        }
        t.f(storageEvent);
        StorageEventInfo storageEventInfo = new StorageEventInfo(storageEvent, this.type, obj);
        Iterator<T> it = value.iterator();
        while (it.hasNext()) {
            ((l) it.next()).invoke(storageEventInfo);
        }
    }

    public final synchronized boolean storageFileExists() {
        return new File(this._targetFileName).exists();
    }

    public final synchronized boolean writeStorage() {
        File file = new File(this._targetFileName);
        if (getData() == null) {
            return false;
        }
        return Utilities.writeFile(file, getData().toString());
    }
}
