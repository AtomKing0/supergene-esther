package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "MetadataBundleCreator")
@SafeParcelable.Reserved({1})
public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {

    @SafeParcelable.Field(id = 2)
    private final Bundle zzjh;
    private static final GmsLogger zzbz = new GmsLogger("MetadataBundle", "");
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzj();

    @SafeParcelable.Constructor
    MetadataBundle(@SafeParcelable.Param(id = 2) Bundle bundle) {
        int i10;
        Bundle bundle2 = (Bundle) Preconditions.checkNotNull(bundle);
        this.zzjh = bundle2;
        bundle2.setClassLoader(MetadataBundle.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = bundle2.keySet().iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (zzf.zzf(next) == null) {
                arrayList.add(next);
                zzbz.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", next);
            }
        }
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            this.zzjh.remove((String) obj);
        }
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t10) {
        MetadataBundle metadataBundleZzbe = zzbe();
        metadataBundleZzbe.zzb(metadataField, t10);
        return metadataBundleZzbe;
    }

    public static MetadataBundle zzbe() {
        return new MetadataBundle(new Bundle());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != MetadataBundle.class) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> setKeySet = this.zzjh.keySet();
        if (!setKeySet.equals(metadataBundle.zzjh.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!Objects.equal(this.zzjh.get(str), metadataBundle.zzjh.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Iterator<String> it = this.zzjh.keySet().iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + this.zzjh.get(it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzjh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final <T> void zzb(MetadataField<T> metadataField, T t10) {
        if (zzf.zzf(metadataField.getName()) == null) {
            String strValueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unregistered field: ".concat(strValueOf) : new String("Unregistered field: "));
        }
        metadataField.zza(t10, this.zzjh);
    }

    public final MetadataBundle zzbf() {
        return new MetadataBundle(new Bundle(this.zzjh));
    }

    public final Set<MetadataField<?>> zzbg() {
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.zzjh.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(zzf.zzf(it.next()));
        }
        return hashSet;
    }

    @Nullable
    public final <T> T zzc(MetadataField<T> metadataField) {
        T t10 = (T) zza(metadataField);
        this.zzjh.remove(metadataField.getName());
        return t10;
    }

    public final boolean zzd(MetadataField<?> metadataField) {
        return this.zzjh.containsKey(metadataField.getName());
    }

    @Nullable
    public final <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.zzjh);
    }

    public final void zza(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzhs.zzkq);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.setTempDir(context.getCacheDir());
        }
    }
}
