package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidStoreDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidStoreDataSource implements StoreDataSource {

    @NotNull
    private final Context context;

    public AndroidStoreDataSource(@NotNull Context context) {
        t.i(context, "context");
        this.context = context;
    }

    @Override // com.unity3d.ads.core.data.datasource.StoreDataSource
    @NotNull
    public List<String> fetchStores(@NotNull List<String> additionalStores) {
        t.i(additionalStores, "additionalStores");
        AndroidKnownStore[] androidKnownStoreArrValues = AndroidKnownStore.values();
        ArrayList arrayList = new ArrayList(androidKnownStoreArrValues.length);
        for (AndroidKnownStore androidKnownStore : androidKnownStoreArrValues) {
            arrayList.add(androidKnownStore.getPackageName());
        }
        List listC0 = d0.c0(d0.A0(arrayList, additionalStores));
        PackageManager packageManager = this.context.getPackageManager();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listC0) {
            String str = (String) obj;
            boolean z10 = (Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(str, 0)) != null;
            if (z10) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
