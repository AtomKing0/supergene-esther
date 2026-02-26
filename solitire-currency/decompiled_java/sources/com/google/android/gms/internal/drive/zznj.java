package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes3.dex */
final class zznj extends IllegalArgumentException {
    zznj(int i10, int i11) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i10);
        sb.append(" of ");
        sb.append(i11);
        super(sb.toString());
    }
}
