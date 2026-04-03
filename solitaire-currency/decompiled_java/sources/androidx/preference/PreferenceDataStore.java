package androidx.preference;

import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PreferenceDataStore {
    public void putBoolean(String str, boolean z10) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String str, float f10) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i10) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String str, long j10) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putString(String str, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public boolean getBoolean(String str, boolean z10) {
        return z10;
    }

    public float getFloat(String str, float f10) {
        return f10;
    }

    public int getInt(String str, int i10) {
        return i10;
    }

    public long getLong(String str, long j10) {
        return j10;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }
}
