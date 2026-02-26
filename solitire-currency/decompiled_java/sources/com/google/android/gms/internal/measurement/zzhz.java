package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhz<MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zzhy<MessageType, BuilderType>> implements zzlg {
    protected int zza = 0;

    int zza(zzly zzlyVar) {
        int iZzbt = zzbt();
        if (iZzbt != -1) {
            return iZzbt;
        }
        int iZza = zzlyVar.zza(this);
        zzc(iZza);
        return iZza;
    }

    int zzbt() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final zzij zzbu() {
        try {
            zzio zzioVarZzc = zzij.zzc(zzbw());
            zza(zzioVarZzc.zzb());
            return zzioVarZzc.zza();
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }

    public final byte[] zzbv() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzja zzjaVarZzb = zzja.zzb(bArr);
            zza(zzjaVarZzb);
            zzjaVarZzb.zzb();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e10);
        }
    }

    void zzc(int i10) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzjw.zza(iterable);
        if (iterable instanceof zzkm) {
            List<?> listZze = ((zzkm) iterable).zze();
            zzkm zzkmVar = (zzkm) list;
            int size = list.size();
            for (Object obj : listZze) {
                if (obj == null) {
                    String str = "Element at index " + (zzkmVar.size() - size) + " is null.";
                    for (int size2 = zzkmVar.size() - 1; size2 >= size; size2--) {
                        zzkmVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zzij) {
                    zzkmVar.zza((zzij) obj);
                } else {
                    zzkmVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzls) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (T t10 : iterable) {
            if (t10 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list.add(t10);
        }
    }
}
