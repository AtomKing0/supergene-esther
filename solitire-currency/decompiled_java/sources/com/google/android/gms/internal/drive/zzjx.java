package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class zzjx {
    private static volatile boolean zzol = false;
    private static volatile zzjx zzon;
    private final Map<zza, zzkk.zzd<?, ?>> zzop;
    private static final Class<?> zzom = zzch();
    static final zzjx zzoo = new zzjx(true);

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i10) {
            this.object = obj;
            this.number = i10;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.object == zzaVar.object && this.number == zzaVar.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzjx() {
        this.zzop = new HashMap();
    }

    static zzjx zzcg() {
        return zzki.zza(zzjx.class);
    }

    private static Class<?> zzch() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzjx zzci() {
        return zzjw.zzcf();
    }

    public static zzjx zzcj() {
        zzjx zzjxVarZzcg = zzon;
        if (zzjxVarZzcg == null) {
            synchronized (zzjx.class) {
                zzjxVarZzcg = zzon;
                if (zzjxVarZzcg == null) {
                    zzjxVarZzcg = zzjw.zzcg();
                    zzon = zzjxVarZzcg;
                }
            }
        }
        return zzjxVarZzcg;
    }

    public final <ContainingType extends zzlq> zzkk.zzd<ContainingType, ?> zza(ContainingType containingtype, int i10) {
        return (zzkk.zzd) this.zzop.get(new zza(containingtype, i10));
    }

    private zzjx(boolean z10) {
        this.zzop = Collections.emptyMap();
    }
}
