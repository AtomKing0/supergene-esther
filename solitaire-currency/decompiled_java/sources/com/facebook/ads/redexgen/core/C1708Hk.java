package com.facebook.ads.redexgen.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MdtaMetadataEntry;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1708Hk implements Parcelable.Creator<MdtaMetadataEntry> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final MdtaMetadataEntry createFromParcel(Parcel parcel) {
        return new MdtaMetadataEntry(parcel, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final MdtaMetadataEntry[] newArray(int i10) {
        return new MdtaMetadataEntry[i10];
    }
}
