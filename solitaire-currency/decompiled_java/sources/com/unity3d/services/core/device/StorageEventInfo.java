package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StorageEventInfo {

    @NotNull
    private final StorageEvent eventType;

    @NotNull
    private final StorageManager.StorageType storageType;

    @Nullable
    private final Object value;

    public StorageEventInfo(@NotNull StorageEvent eventType, @NotNull StorageManager.StorageType storageType, @Nullable Object obj) {
        t.i(eventType, "eventType");
        t.i(storageType, "storageType");
        this.eventType = eventType;
        this.storageType = storageType;
        this.value = obj;
    }

    public static /* synthetic */ StorageEventInfo copy$default(StorageEventInfo storageEventInfo, StorageEvent storageEvent, StorageManager.StorageType storageType, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            storageEvent = storageEventInfo.eventType;
        }
        if ((i10 & 2) != 0) {
            storageType = storageEventInfo.storageType;
        }
        if ((i10 & 4) != 0) {
            obj = storageEventInfo.value;
        }
        return storageEventInfo.copy(storageEvent, storageType, obj);
    }

    @NotNull
    public final StorageEvent component1() {
        return this.eventType;
    }

    @NotNull
    public final StorageManager.StorageType component2() {
        return this.storageType;
    }

    @Nullable
    public final Object component3() {
        return this.value;
    }

    @NotNull
    public final StorageEventInfo copy(@NotNull StorageEvent eventType, @NotNull StorageManager.StorageType storageType, @Nullable Object obj) {
        t.i(eventType, "eventType");
        t.i(storageType, "storageType");
        return new StorageEventInfo(eventType, storageType, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageEventInfo)) {
            return false;
        }
        StorageEventInfo storageEventInfo = (StorageEventInfo) obj;
        return this.eventType == storageEventInfo.eventType && this.storageType == storageEventInfo.storageType && t.d(this.value, storageEventInfo.value);
    }

    @NotNull
    public final StorageEvent getEventType() {
        return this.eventType;
    }

    @NotNull
    public final StorageManager.StorageType getStorageType() {
        return this.storageType;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = ((this.eventType.hashCode() * 31) + this.storageType.hashCode()) * 31;
        Object obj = this.value;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    @NotNull
    public String toString() {
        return "StorageEventInfo(eventType=" + this.eventType + ", storageType=" + this.storageType + ", value=" + this.value + ')';
    }
}
