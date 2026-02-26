package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.ironsource.v8;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Preference.kt */
/* JADX INFO: loaded from: classes2.dex */
@Entity
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Preference {

    @PrimaryKey
    @ColumnInfo(name = v8.h.W)
    @NotNull
    private final String key;

    @ColumnInfo(name = "long_value")
    @Nullable
    private final Long value;

    public Preference(@NotNull String key, @Nullable Long l10) {
        t.i(key, "key");
        this.key = key;
        this.value = l10;
    }

    public static /* synthetic */ Preference copy$default(Preference preference, String str, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = preference.key;
        }
        if ((i10 & 2) != 0) {
            l10 = preference.value;
        }
        return preference.copy(str, l10);
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @Nullable
    public final Long component2() {
        return this.value;
    }

    @NotNull
    public final Preference copy(@NotNull String key, @Nullable Long l10) {
        t.i(key, "key");
        return new Preference(key, l10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return t.d(this.key, preference.key) && t.d(this.value, preference.value);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        Long l10 = this.value;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    @NotNull
    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Preference(@NotNull String key, boolean z10) {
        this(key, Long.valueOf(z10 ? 1L : 0L));
        t.i(key, "key");
    }
}
